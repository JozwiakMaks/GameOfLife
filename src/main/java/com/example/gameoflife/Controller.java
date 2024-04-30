package com.example.gameoflife;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class Controller {
    public Button playButton;
    public Button resetButton;
    public GridPane gridPane;


    public void cellClicked(MouseEvent mouseEvent) {
        Pane pane = (Pane) mouseEvent.getSource();
        String[] coords;
        int row = 0;
        int col = 0;

        coords = pane.getId().split(",");
        row = Integer.parseInt(coords[0]);
        col = Integer.parseInt(coords[1]);

        if(Logic.getGrid()[row][col] == 0) {
            pane.setStyle("-fx-background-color:  #1e1f1f; -fx-border-color: #3c3d3d; -fx-border-width: 1px");
            Logic.setCellStatus(true, row, col);
        }else if(Logic.getGrid()[row][col] == 1){
            pane.setStyle("-fx-background-color:  #f0f5f5; -fx-border-color: #3c3d3d; -fx-border-width: 1px");
            Logic.setCellStatus(false, row, col);
        }
    }


}