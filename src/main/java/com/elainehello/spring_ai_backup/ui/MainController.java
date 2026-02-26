package com.elainehello.spring_ai_backup.ui;

import com.elainehello.spring_ai_backup.backup.BackupService;
import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class MainController {

    private final BackupService backupService;

    private File sourceDir;
    private File destinationDir;

    public MainController(BackupService backupService) {
        this.backupService = backupService;
    }

    @FXML
    public void chooseSource() {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select Source Folder");
        sourceDir = chooser.showDialog(new Stage());
    }

    @FXML
    public void chooseDestination() {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select Destination Folder");
        destinationDir = chooser.showDialog(new Stage());
    }

    @FXML
    public void startBackup() {
        if (sourceDir != null && destinationDir != null) {
            backupService.performBackup(sourceDir.toPath(), destinationDir.toPath());
        }
    }
}