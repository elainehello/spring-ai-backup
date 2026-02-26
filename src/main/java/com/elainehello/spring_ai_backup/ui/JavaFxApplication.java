package com.elainehello.spring_ai_backup.ui;

import com.elainehello.spring_ai_backup.config.SpringContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {

    @Override
    public void init() {
        SpringContext.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/main.fxml")
        );
        loader.setControllerFactory(SpringContext.getContext()::getBean);

        Scene scene = new Scene(loader.load());
        stage.setTitle("Spring AI Backup");
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setWidth(600);
        stage.show();
    }

    @Override
    public void stop() {
        SpringContext.close();
    }
}
