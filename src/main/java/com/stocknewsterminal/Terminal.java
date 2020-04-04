package com.stocknewsterminal;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;

public class Terminal {

    public static void display(Stock stock) {
        String symbol = stock.getSymbol();
        String company = stock.getCompanyName();
        String price = stock.getPriceLatest();
        String high = stock.getPriceHigh();
        String low = stock.getPriceLow();

        Stage window = new Stage();
        window.setTitle("$" + symbol);
        window.setMinWidth(25);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label symbolLabel = new Label("$" + symbol);
        Label companyLabel = new Label(company);
        Label priceLabel = new Label("Price");
        Label highLabel = new Label("High");
        Label lowLabel = new Label("Low");
        Label priceValue = new Label(price);
        Label highValue = new Label(high);
        Label lowValue = new Label(low);

        GridPane.setConstraints(companyLabel, 0, 0);
        GridPane.setConstraints(symbolLabel, 1, 0);

        GridPane.setConstraints(priceLabel, 0, 1);
        GridPane.setConstraints(priceValue, 1, 1);

        GridPane.setConstraints(highLabel, 0, 2);
        GridPane.setConstraints(highValue, 1, 2);

        GridPane.setConstraints(lowLabel, 0, 3);
        GridPane.setConstraints(lowValue, 1, 3);

        grid.getChildren().addAll(symbolLabel, priceLabel, highLabel, highValue, lowLabel, lowValue, companyLabel, priceValue);
        Scene scene = new Scene(grid, 450, 300);
        scene.getStylesheets().add((new File("src/resources/style.css")).toURI().toString());
        window.setScene(scene);
        window.show();
    }
}
