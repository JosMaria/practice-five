package org.genesiscode.practicefive.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PanelMenuBar implements EventHandler<ActionEvent> {

    private static final String EXERCISES = "Ejercicios";
    private static final String EXERCISE_A = "Ejercicio a)";
    private static final String EXERCISE_B = "Ejercicio b)";

    private static final int PANEL_TESTS = 1;

    private final MenuItem menuItemExerciseA, menuItemExerciseB;

    private final VBox paneMain;

    public VBox getPaneMain() {
        return paneMain;
    }

    public PanelMenuBar() {
        menuItemExerciseA = new MenuItem(EXERCISE_A);
        menuItemExerciseA.setOnAction(this);
        menuItemExerciseB = new MenuItem(EXERCISE_B);
        menuItemExerciseB.setOnAction(this);

        VBox homePane = new VBox(10, new Label("ESTUDIANTE: Jose Maria Aguilar Chambi\nDOCENTE: Richard"));
        homePane.setAlignment(Pos.CENTER);
        homePane.setPadding(new Insets(50, 0, 0, 0));

        paneMain = new VBox(10, getMenuBar(), homePane);
    }

    private MenuBar getMenuBar() {
        Menu menu = new Menu(EXERCISES);
        menu.getItems().addAll(menuItemExerciseA, menuItemExerciseB);

        return new MenuBar(menu);
    }

    public void setPaneBottom(Pane paneBottom) {
        paneMain.getChildren().remove(PANEL_TESTS);
        paneMain.getChildren().add(paneBottom);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        MenuItem source = (MenuItem) actionEvent.getSource();

        if (source.equals(menuItemExerciseA)) {
            setPaneBottom(ExerciseAPane.getInstance().getMainPane());

        } else if (source.equals(menuItemExerciseB)) {
            setPaneBottom(ExerciseBPane.getInstance().getMainPane());
        }
    }
}
