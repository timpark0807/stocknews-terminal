package com.stocknewsterminal;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;

public class Terminal {

    static String ticker;
    static String price;
    static String high;
    static String low;
    static String company;

    public static void display(Stock stock) {
        ticker = stock.getTicker();
        company = stock.getCompany();
        price = Float.toString(stock.getPrice());
        high = Float.toString(stock.getHigh());
        low = Float.toString(stock.getLow());

        Stage window = new Stage();
        window.setTitle(ticker);
        window.setMinWidth(25);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label tickerLabel = new Label("$" + ticker);
        Label companyLabel = new Label(company);
        Label priceLabel = new Label(price);
        Label highLabel = new Label(high);
        Label lowLabel = new Label(low);

        GridPane.setConstraints(tickerLabel, 0, 0);
        GridPane.setConstraints(companyLabel, 0, 1);
        GridPane.setConstraints(priceLabel, 2, 1);
        GridPane.setConstraints(highLabel, 3, 1);
        GridPane.setConstraints(lowLabel, 4, 1);

        grid.getChildren().addAll(tickerLabel, priceLabel, highLabel, lowLabel, companyLabel);
        Scene scene = new Scene(grid, 450, 300);
        scene.getStylesheets().add((new File("src/resources/style.css")).toURI().toString());
        window.setScene(scene);
        window.show();
    }
}
