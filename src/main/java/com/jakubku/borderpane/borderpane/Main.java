package com.jakubku.borderpane.borderpane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane borderPane = new BorderPane();
        // Left Nodes
        ListView<String> FruitList = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList();
        items.add("Apples");
        items.add("Oranges");
        items.add("Pineapples");
        FruitList.setItems(items);
        // Top Nodes
        Label topLabel = new Label("FruitListApplication");
        topLabel.setPadding(new Insets(10));
        // Bottom Nodes
        Label bottomLabel = new Label("Recently Added Fruit: None");
        bottomLabel.setPadding(new Insets(10));
        // Right Nodes
        Label rightLabel = new Label("Total Number Of Fruit Types: " + FruitList.getItems().size());
        rightLabel.setRotate(90);
        rightLabel.setPadding(new Insets(0,0,0,60));
        // Center Nodes
        TextField field = new TextField();
        Button btn = new Button("ADD");
        HBox centerContainer = new HBox(10, field, btn);
        // Setting BorderPane Regions
        borderPane.setTop(topLabel);
        borderPane.setRight(rightLabel);
        borderPane.setBottom(bottomLabel);
        borderPane.setLeft(FruitList);
        borderPane.setCenter(centerContainer);
        // Register an Event Handler
        btn.setOnMouseClicked(mouseEvent -> {
            if(!field.getText().isEmpty()) {
                String item = field.getText();
                items.add(item);
                bottomLabel.setText("Recently Added Fruit: " + item);
                rightLabel.setText("Total Number of Fruit Types: " + FruitList.getItems().size());
                field.clear();
            }
        });
        Scene scene = new Scene(borderPane, 700, 650);
        stage.setScene(scene);
        stage.setTitle("FlowPane Layout Example");
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
