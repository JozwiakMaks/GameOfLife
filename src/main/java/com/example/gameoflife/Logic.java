package com.example.gameoflife;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Logic {
    private static int[][] grid;
    private static int rows;
    private static int cols;

    public Logic(int rows, int cols) {
        grid = new int[rows][cols];
        this.rows = setRows(rows);
        this.cols = setCols(cols);
    }

    public void init(FXMLLoader fxmlLoader) {
        Controller controller = fxmlLoader.getController();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                Pane pane = new Pane();
                pane.setMinSize(10,10);
                pane.setStyle("-fx-background-color:  #1e1f1f; -fx-border-color: #3c3d3d; -fx-border-width: 1px");
                pane.setOnMouseClicked(controller::cellClicked);
                pane.setId(i+","+j);
                grid[i][j] = 0;
                GridPane.setConstraints(pane,i,j);
                controller.gridPane.getChildren().add(pane);
            }
        }
    }

    public static int setRows(int rows) {
        if(rows > 0){
            Logic.rows = rows;
        }else{
            throw new IllegalArgumentException("rows must be greater than 0");
        }
        return rows;
    }

    public static int setCols(int cols) {
        if(cols > 0){
            Logic.cols = cols;
        }else{
            throw new IllegalArgumentException("cols must be greater than 0");
        }
        return cols;
    }

    public static int[][] getGrid() {
        return grid;
    }

    public static void setCellStatus(boolean status, int row, int col) {
        if(status){
            grid[row][col] = 1;
        }else{
            grid[row][col] = 0;
        }
    }
}
