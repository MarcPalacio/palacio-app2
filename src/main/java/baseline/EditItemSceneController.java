/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditItemSceneController {
    //  FXML Elements
    @FXML private Button cancelEditButton;
    @FXML private TextField editInputName;
    @FXML private TextField editInputPrice;
    @FXML private TextField editInputSerial;
    @FXML private Button editItemButton;

    //  Attributes
    ObservableList<Item> inventoryList = FXCollections.observableArrayList();
    private int index;
    private Scene inventoryScene;
    private Scene errorScene;
    private FXMLLoader inventoryController;
    private FXMLLoader errorController;

    //  Methods to set and go to scenes
    @FXML
    void setInventoryScene(Scene scene){
        //  Sets inventory scene
        inventoryScene = scene;
    }

    @FXML
    void setErrorScene(Scene scene){
        //  Sets error scene
        errorScene = scene;
    }

    @FXML
    void goInventoryScene(ActionEvent event){
        //  Goes to the inventory scene
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(inventoryScene);
    }

    @FXML
    void goErrorScene(ActionEvent event){
        //  Goes to the error scene
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(errorScene);
    }

    @FXML
    void getErrorController(FXMLLoader errorController){
        //  Gets the error message scene controller
        this.errorController = errorController;
    }

    @FXML
    void getInventoryController(FXMLLoader inventoryController){
        //  Gets the inventory list scene controller
        this.inventoryController = inventoryController;
    }

    //  FXML Events
    @FXML
    void cancelEditButtonPressed(ActionEvent event) {
        //  Goes back to the inventory scene without making any changes
        goInventoryScene(event);
    }

    @FXML
    void editItemButtonPressed(ActionEvent event) {
        //  Calls an instance of ListOfItems to utilize functions within that method
        ListOfItems helper = new ListOfItems();
        //  Gets the controller information of the error message scene in case the user makes an error
        ErrorMessageSceneController error = errorController.getController();
        //  Create the output string
        StringBuilder errorMessage = new StringBuilder();

        //  Gets the information from each of the input fields and passes them to a function within ListOfItems
        String name = editInputName.getText();
        String price = editInputPrice.getText();
        String serial = editInputSerial.getText();

        errorMessage.append(helper.editItemInList(inventoryList.get(index), name, price, serial));

        //  Checks if a string was returned
        //  If the string isn't empty
        if(!(errorMessage.toString().isEmpty())){
            //  An item wasn't edited properly and an error message will show with the corresponding error
            errorMessage.append("Please validate your inputs.");
            error.setLabelError(errorMessage.toString());
            goErrorScene(event);
        }
        else{   //  If a string wasn't returned
            //  An item was edited in the list successfully and the list will update
            editInputName.clear();
            editInputPrice.clear();
            editInputSerial.clear();
            goInventoryScene(event);
        }
    }

    //  Setter methods to get information from other controllers
    void setTextInputs(String name, String price, String serial){
        //  Sets the text inputs to the previous description
        editInputName.setText(name);
        editInputPrice.setText(price.substring(1));
        editInputSerial.setText(serial);
    }

    void setItemList(ObservableList<Item> item){
        //  Sets this list to a list from an outside function
        this.inventoryList = item;
    }

    void setIndex(int index){
        //  Sets the index of the element that is going to be edited
        this.index = index;
    }
}