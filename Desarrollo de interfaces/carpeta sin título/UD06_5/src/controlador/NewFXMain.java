/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package controlador;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author davidbravorueda
 */
public class NewFXMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        ContextMenu contextMenu = new ContextMenu();

        MenuItem preview = createMenuItem("Preview", "https://img.icons8.com/?size=100&id=986&format=png&color=000000");
        Menu shareMenu = new Menu("Share", createIcon("https://img.icons8.com/ios/32/share.png"));
        MenuItem getLine = createMenuItem("GetLine", "https://img.icons8.com/ios/32/line.png");
        MenuItem rename = createMenuItem("Rename", "https://img.icons8.com/ios/32/rename.png");
        MenuItem delete = createMenuItem("Delete", "https://img.icons8.com/ios/32/delete.png");
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem settings = createMenuItem("Settings", "https://img.icons8.com/ios/32/settings.png");

        MenuItem twitter = createMenuItem("Twitter", "https://img.icons8.com/ios/32/twitter.png");
        MenuItem instagram = createMenuItem("Instagram", "https://img.icons8.com/ios/32/instagram.png");
        MenuItem dribbble = createMenuItem("Dribbble", "https://img.icons8.com/ios/32/dribbble.png");
        MenuItem telegram = createMenuItem("Telegram", "https://img.icons8.com/ios/32/telegram.png");

        shareMenu.getItems().addAll(twitter, instagram, dribbble, telegram);

        contextMenu.getItems().addAll(preview, shareMenu, getLine, rename, delete, separator, settings);

        StackPane root = new StackPane();
        root.setBackground(new Background(new BackgroundFill(Color.VIOLET, CornerRadii.EMPTY, Insets.EMPTY)));

        root.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                contextMenu.show(root, event.getScreenX(), event.getScreenY());
            } else {
                contextMenu.hide();
            }
        });

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Context Menu");
        primaryStage.show();
    }

    private MenuItem createMenuItem(String text, String imageUrl) {
        return new MenuItem(text, createIcon(imageUrl));
    }

    private ImageView createIcon(String imageUrl) {
        ImageView icon = new ImageView(new Image(imageUrl));
        icon.setFitWidth(16);
        icon.setFitHeight(16);
        return icon;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
