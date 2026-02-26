package com.elainehello.spring_ai_backup.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BackupRepository {

    public void save(String filePath, String hash) {
        // TODO: Implement SQLite persistence
        System.out.println("Saved: " + filePath + " Hash: " + hash);
    }
}