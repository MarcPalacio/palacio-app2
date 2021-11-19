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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditItemSceneController {
    //  FXML Elements
    @FXML private TextField editInputName;
    @FXML private TextField editInputPrice;
    @FXML private TextField editInputSerial;
    @FXML private Button editItemButton;

    //  Attributes
    ObservableList<Item> listOfItems = FXCollections.observableArrayList();
    private int index;
    private Scene inventoryScene;
    private Scene errorScene;
    private FXMLLoader inventoryController;
    private FXMLLoader errorController;

    //  Methods to set and go to scenes
    @FXML
    void setInventoryScene(Scene scene){
        //  Sets inventory scene
    }

    @FXML
    void setErrorScene(Scene scene){
        //  Sets error scene
    }

    @FXML
    void goInventoryScene(ActionEvent event){
        //  Goes to the inventory scene
    }

    @FXML
    void goErrorScene(ActionEvent event){
        //  Goes to the error scene
    }

    //  FXML Events
    @FXML
    void editItemButtonPressed(ActionEvent event) {
        //  Creates an instance of ListOfItems and inventoryController to use
        //  Gets the data from the input fields (Name, price, and serial)
        //  If editItem from ListOfItems returns a string, the edit failed and will change to an error screen
        //  Else, it was successful and will update the list
    }

    //  Other methods to help
    void setTextInputs(String name, double price, String serial){
        //  Sets the text inputs to the previous description
    }

    void setItemList(ObservableList<Item> item){
        //  Sets this list to a list from an outside function
    }

    void setIndex(int index){
        //  Sets the index of the element that is going to be edited
    }
}