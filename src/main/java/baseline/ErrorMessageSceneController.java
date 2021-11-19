/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ErrorMessageSceneController {
    //  FXML Elements
    @FXML private Button goBackButton;
    @FXML private Label labelError;

    //  Attributes
    private Scene inventoryScene;

    //  Methods to set and go to scenes
    @FXML
    void setInventoryScene(Scene scene){
        //  Sets the inventory scene
    }

    @FXML
    void goInventoryScene(ActionEvent event){
        //  Switches scene to inventory scene
    }

    //  FXML Events
    @FXML
    void goBackButtonPressed(ActionEvent event) {
        //  Goes back to the inventory scene after the user sees the error
    }

    void setLabelError(String error){
        //  Sets the label to print the specific error
    }
}
