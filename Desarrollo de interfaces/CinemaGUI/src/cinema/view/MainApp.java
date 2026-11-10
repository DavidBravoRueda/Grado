package cinema.view;

import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SalaApp salaApp = new SalaApp();
            salaApp.setVisible(true);
        });
    }
}
