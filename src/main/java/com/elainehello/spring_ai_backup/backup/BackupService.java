package com.elainehello.spring_ai_backup.backup;

import com.elainehello.spring_ai_backup.repository.BackupRepository;
import com.elainehello.spring_ai_backup.service.FileHashService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

@Service
public class BackupService {

    private final FileHashService fileHashService;
    private final BackupRepository backupRepository;

    public BackupService(FileHashService fileHashService,
                         BackupRepository backupRepository) {
        this.fileHashService = fileHashService;
        this.backupRepository = backupRepository;
    }

    public void performBackup(Path source, Path destination) {
        try (Stream<Path> paths = Files.walk(source)) {
            paths.filter(Files::isRegularFile).forEach(path -> {
                try {
                    Path target = destination.resolve(source.relativize(path));
                    Files.createDirectories(target.getParent());
                    Files.copy(path, target, StandardCopyOption.REPLACE_EXISTING);

                    String hash = fileHashService.calculateHash(path);
                    backupRepository.save(path.toString(), hash);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}