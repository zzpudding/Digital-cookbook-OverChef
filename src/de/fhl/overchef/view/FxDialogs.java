package de.fhl.overchef.view;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class FxDialogs {

    public static void showInformation(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Overchef");
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}