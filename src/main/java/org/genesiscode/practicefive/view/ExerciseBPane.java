package org.genesiscode.practicefive.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ExerciseBPane {
    
    private static ExerciseBPane exerciseBPane;
    private VBox mainPane;

    private ExerciseBPane() {
        mainPane = new VBox(new Label("Este es el ejercicio 2"));
    }

    public synchronized static ExerciseBPane getInstance() {
        return exerciseBPane == null ? new ExerciseBPane() : exerciseBPane;
    }

    public VBox getMainPane() {
        return mainPane;
    }
}
