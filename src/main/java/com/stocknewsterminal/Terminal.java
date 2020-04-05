package com.stocknewsterminal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;

public class Terminal {

    public static void display(Stock stock) {
        // Data from API Request
        String symbol = stock.getSymbol();
        String company = stock.getCompanyName();
        String price = stock.getPriceLatest();
        String high = stock.getPriceHigh();
        String low = stock.getPriceLow();
        News[] news = stock.getNews();

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

        // Create News Article Table
        TableColumn<News, String> headlineColumn = new TableColumn<>("Headline");
        headlineColumn.setCellValueFactory(new PropertyValueFactory<>("headline"));
        headlineColumn.setPrefWidth(300);

        TableColumn<News, String> sourceColumn = new TableColumn<>("Source");
        sourceColumn.setCellValueFactory(new PropertyValueFactory<>("source"));

        TableView tableView = new TableView();
        tableView.setItems(getObservableListNews(news));
        tableView.getColumns().addAll(headlineColumn, sourceColumn);
        tableView.setPrefWidth(1000);
        grid.setConstraints(tableView, 0, 6, 10, 10);

        grid.getChildren().add(tableView);


        // Create the window and content
        Stage window = new Stage();
        window.setTitle("$" + symbol);
        window.setMinWidth(25);
        Scene scene = new Scene(grid, 500, 300);
        scene.getStylesheets().add((new File("src/resources/style.css")).toURI().toString());
        window.setScene(scene);
        window.show();
    }

    public static ObservableList<News> getObservableListNews(News[] news){
        ObservableList<News> observableList = FXCollections.observableArrayList();
        observableList.addAll(Arrays.asList(news));
        return observableList;
    }
}
