package org.genesiscode.practicefive.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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


    private static final int PANEL_TESTS = 1;

    private final MenuItem menuItemInverse, menuItemRechazo;


    private final VBox paneMain;
    private Pane paneBottom;

    public VBox getPaneMain() {
        return paneMain;
    }

    public PanelMenuBar() {
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

        Menu menuIndependence = new Menu(METHOS_2);
        menuIndependence.getItems().addAll(menuItemRechazo);

        return new MenuBar(/*menuUniformity, */menuIndependence);
    }

    public void setPaneBottom(Pane paneBottom) {
        paneMain.getChildren().remove(PANEL_TESTS);
        paneMain.getChildren().add(paneBottom);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        MenuItem source = (MenuItem) actionEvent.getSource();

        if (source.equals(menuItemInverse)) {
            setPaneBottom(null);

        } else if (source.equals(menuItemRechazo)) {
            setPaneBottom(PaneReachMethod.getInstance().getMainPane());
        }
    }
}
