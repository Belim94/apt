package gui.classes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean ansver;

    public static boolean display(String title, String message, Scene scene1, Stage window1) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(500);

        Label label1 = new Label();
        label1.setText(message);

        //Create two buttons
        HBox hBox = new HBox(20);
        Button yesButton = new Button();
        yesButton.setText("Да");
        Button noButton = new Button();
        noButton.setText("Нет");
        hBox.getChildren().addAll(yesButton, noButton);
        hBox.setAlignment(Pos.CENTER);

        yesButton.setOnAction(e -> {
            ansver = true;
            window.close();
            window1.setScene(scene1);
        });

        noButton.setOnAction(e -> {
            ansver = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().add(label1);
        layout.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(layout);
        borderPane.setCenter(hBox);

        Scene scene = new Scene(borderPane, 500, 100);
        window.setScene(scene);
        window.showAndWait();

        return ansver;
    }
}
