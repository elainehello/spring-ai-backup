package com.elainehello.spring_ai_backup.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BackupFile {

    private String filePath;
    private String hash;
    private LocalDateTime backupTime;
}