package com.elainehello.spring_ai_backup.config;

import com.elainehello.spring_ai_backup.SpringAiBackupApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.lang.Contract;

public class SpringContext {
    /**
     * Handles Spring lifecycle inside JavaFX.
     */
    private static ConfigurableApplicationContext context;

    public static void init() {
        context = new SpringApplicationBuilder(SpringAiBackupApplication.class)
                .run();
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }

    public static void close() {
        context.close();
    }
}