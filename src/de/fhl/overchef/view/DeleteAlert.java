package de.fhl.overchef.view;

import de.fhl.overchef.model.Picture;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class is used to generated an alert window which contains alert message and cancel and confirm button.
 * @author HU
 * @version 1.0
 */
public class DeleteAlert {
	static Button cancel;
	static Button confirm;
	static Stage alertWin;
	/**
	 * define the handle functions of the two buttons. Any subclass of this class can change the handle function by override this function
	 */
	public static void buttonReaction(Picture p, ImageView iv) {
		cancel.setOnAction(e -> alertWin.close());
        confirm.setOnAction(e -> {p.deletePicture(); iv.setVisible(false);alertWin.close();});
        
	}
	/**
	 * generate an alert window with handle functions of the buttons set automatically
	 * @param title the title of the alert window
	 * @param msg the message that this alert window wants to present
	 */
	public static void popUp(String title, String msg,  Picture picture, ImageView iv) {
		alertWin = new Stage();
        alertWin.initModality(Modality.APPLICATION_MODAL);
        alertWin.setTitle(title);
        
        cancel = new Button("Cancel");
        confirm = new Button("Confirm");
        cancel.setPrefWidth(65);
        confirm.setPrefWidth(65);
        cancel.setPrefHeight(30);
        confirm.setPrefHeight(30);

        buttonReaction(picture,iv);
        
        Label alertMsg = new Label(msg);
        VBox.setMargin(alertMsg, new Insets(0,0,30,0));
        
        VBox vBox = new VBox(2);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefWidth(400);
        vBox.setPrefHeight(200);
        HBox hBox = new HBox(2);
        hBox.setAlignment(Pos.CENTER);
        HBox.setMargin(cancel,new Insets(10,10,0,0));
        HBox.setMargin(confirm,new Insets(10,0,0,10));
        vBox.getChildren().add(alertMsg);
        vBox.getChildren().add(hBox);
        hBox.getChildren().add(cancel);
        hBox.getChildren().add(confirm);
        
        alertWin.setScene(new Scene(vBox, 400, 200));
        alertWin.showAndWait();
	}

}
