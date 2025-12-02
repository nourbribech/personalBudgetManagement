package com.example.gestion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddTransaction extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AddTransaction.class.getResource("AddTransaction.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Add Transaction");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(); // launches JavaFX application
    }
}
