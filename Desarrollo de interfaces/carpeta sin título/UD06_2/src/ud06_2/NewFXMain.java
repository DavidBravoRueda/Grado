/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package ud06_2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author davidbravorueda
 */
public class NewFXMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        double width = 400, height = 300;

        Circle circle = new Circle(80, height / 2, 50, Color.AQUA);

        ContextMenu contextMenu = new ContextMenu();

        MenuItem menuItem1 = new MenuItem("Menu Item    Ctrl+O");
        menuItem1.setOnAction(e -> System.out.println("Menu Item seleccionado"));

        Menu parentMenu = new Menu("Parent");
        MenuItem child1 = new MenuItem("Child 1");
        MenuItem child2 = new MenuItem("Child 2");
        parentMenu.getItems().addAll(child1, child2);

        child1.setOnAction(e -> System.out.println("Child 1 seleccionado"));
        child2.setOnAction(e -> System.out.println("Child 2 seleccionado"));

        CheckMenuItem checkMenuItem = new CheckMenuItem("Check Menu Item");
        checkMenuItem.setOnAction(e -> {
            if (checkMenuItem.isSelected()) {
                System.out.println("Opción activada");
            } else {
                System.out.println("Opción desactivada");
            }
        });

        SeparatorMenuItem separator = new SeparatorMenuItem();

        ToggleGroup radioGroup = new ToggleGroup();
        RadioMenuItem radio1 = new RadioMenuItem("Radio - Opción 1");
        RadioMenuItem radio2 = new RadioMenuItem("Radio - Opción 2");
        radio1.setToggleGroup(radioGroup);
        radio2.setToggleGroup(radioGroup);

        radio1.setOnAction(e -> System.out.println("Opción 1 seleccionada"));
        radio2.setOnAction(e -> System.out.println("Opción 2 seleccionada"));

        contextMenu.getItems().addAll(menuItem1, parentMenu, checkMenuItem, separator, radio1, radio2);

        circle.setOnContextMenuRequested(e
                -> contextMenu.show(circle, e.getScreenX(), e.getScreenY())
        );

        root.getChildren().add(circle);

        Scene scene = new Scene(root, width, height);
        primaryStage.setTitle("Menú Contextual Avanzado");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
