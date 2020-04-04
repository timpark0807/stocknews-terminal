package com.stocknewsterminal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("!stocknews");

        // Create Grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Create Search Fields
        Label tickerLabel = new Label("Enter a Ticker:");
        TextField tickerText = new TextField();
        Button search = new Button("Search");

        // Set Grid w/ Fields
        GridPane.setConstraints(tickerLabel, 0, 0);
        GridPane.setConstraints(tickerText, 1, 0);
        GridPane.setConstraints(search, 1, 1);
        grid.getChildren().addAll(tickerLabel, tickerText, search);

        // Create Scene
        Scene scene = new Scene(grid, 300, 100);
        scene.getStylesheets().add((new File("src/resources/style.css")).toURI().toString());
        primaryStage.setScene(scene);
        primaryStage.show();

        // Search Button Action
        search.setOnAction(e -> {
            try {
                Stock stock = new Stock(tickerText.getText());
                Terminal.display(stock);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
