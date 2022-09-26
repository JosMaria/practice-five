package org.genesiscode.practicefive.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PanelMenuBar implements EventHandler<ActionEvent> {

    private static final String METHOD_1 = "_Metodo 1";
    private static final String INVERSE = "_Transformada Inversa";
    private static final String RECHAZO = "_Rechazo";

    private static final String METHOS_2 = "_Metodo";


    private static final String EXERCISES = "Ejercicios";
    private static final String EXERCISE_A = "Ejercicio a)";
    private static final String EXERCISE_B = "Ejercicio b)";

    private static final int PANEL_TESTS = 1;

    private final MenuItem menuItemInverse, menuItemRechazo;
    private final MenuItem menuItemExerciseA, menuItemExerciseB;

    private final VBox paneMain;
    private Pane paneBottom;

    public VBox getPaneMain() {
        return paneMain;
    }

    public PanelMenuBar() {
        menuItemExerciseA = new MenuItem(EXERCISE_A);
        menuItemExerciseA.setOnAction(this);
        menuItemExerciseB = new MenuItem(EXERCISE_B);
        menuItemExerciseB.setOnAction(this);

        menuItemInverse = new MenuItem(INVERSE);
        menuItemInverse.setOnAction(this);

        menuItemRechazo = new MenuItem(RECHAZO);
        menuItemRechazo.setOnAction(this);

        paneBottom = new VBox();
        paneMain = new VBox(10, getMenuBar(), paneBottom);
    }

    private MenuBar getMenuBar() {
/*
        Menu menuUniformity = new Menu(METHOD_1);
        menuUniformity.getItems().addAll(menuItemInverse);
*/

        Menu menu = new Menu(EXERCISES);
        menu.getItems().addAll(menuItemExerciseA, menuItemExerciseB);

        return new MenuBar(/*menuUniformity, */menu);
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
            setPaneBottom(new VBox(10, new Label("EJERCICIO A)")));
            //setPaneBottom(PaneReachMethod.getInstance().getMainPane());
        }
    }
}
