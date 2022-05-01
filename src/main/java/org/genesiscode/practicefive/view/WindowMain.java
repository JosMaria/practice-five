package org.genesiscode.practicefive.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowMain extends Application {

    @Override
    public void start(Stage stage) {
        PanelMenuBar panelMenuBar = new PanelMenuBar();
        Scene scene = new Scene(panelMenuBar.getPaneMain(), 800, 500);
        stage.setTitle("Practica 5");
        stage.setScene(scene);
        stage.show();
    }
}
