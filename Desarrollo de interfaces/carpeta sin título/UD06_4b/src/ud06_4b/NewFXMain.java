/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package ud06_4b;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author davidbravorueda
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");

        CustomMenuItem menuItem1 = new CustomMenuItem(new Button("MenuItem 1"));
        CustomMenuItem menuItem2 = new CustomMenuItem(new Label("MenuItem 2"));
        CustomMenuItem menuItem3 = new CustomMenuItem(new CheckBox("MenuItem 3"));

        menu.getItems().addAll(menuItem1, menuItem2, menuItem3);
        menuBar.getMenus().add(menu);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);

        Scene scene = new Scene(root, 399, 315);
        primaryStage.setTitle("JavaFX Menu Example");
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
