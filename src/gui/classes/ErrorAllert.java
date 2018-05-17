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

public class ErrorAllert {

    static boolean ansver;

    public static void display(Label name) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("APT Error");
        window.setWidth(700);

        Label label1 = new Label();
        label1.setText("Что-то не так с полем \"" + name.getText() + "\"!");
        Label label2 = new Label();
        label2.setText("Пожалуйста проверьте, что значение в поле - число и, что оно не нулевое.");

        //Create two buttons
        HBox hBox = new HBox(20);
        Button okButton = new Button();
        okButton.setText("  OK  ");
        hBox.getChildren().add(okButton);
        hBox.setAlignment(Pos.CENTER);

        okButton.setOnAction(e -> {
            ansver = true;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1, label2);
        layout.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(layout);
        borderPane.setCenter(hBox);

        Scene scene = new Scene(borderPane, 250, 100);
        window.setScene(scene);
        window.showAndWait();

    }
}
