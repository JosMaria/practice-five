package org.genesiscode.practicefive.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ExerciseAPane {

    private static ExerciseAPane exerciseAPane;
    private VBox mainPane;

    private ExerciseAPane() {
        mainPane = new VBox(new Label("Este es el ejercicio 1"));
    }

    public synchronized static ExerciseAPane getInstance() {
        return exerciseAPane == null ? new ExerciseAPane() : exerciseAPane;
    }

    public VBox getMainPane() {
        return mainPane;
    }
}
