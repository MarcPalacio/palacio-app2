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
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class InventoryListSceneController implements Initializable {
    //  FXML Elements
    @FXML private TextField addInputName;
    @FXML private TextField addInputPrice;
    @FXML private TextField addInputSerial;
    @FXML private Button addItemButton;
    @FXML private Button deleteInventoryButton;
    @FXML private Button deleteItemButton;
    @FXML private Button editItemButton;
    @FXML private Button loadInventoryButton;
    @FXML private TableColumn<?, ?> nameColumn;
    @FXML private TableColumn<?, ?> priceColumn;
    @FXML private Button saveInventoryButton;
    @FXML private TextField searchInput;
    @FXML private Button searchItemButton;
    @FXML private TableColumn<?, ?> serialColumn;

    //  Attributes
    ObservableList<Item> listOfItems = FXCollections.observableArrayList();
    private Scene errorScene;
    private Scene editScene;
    private FXMLLoader errorController;
    private FXMLLoader editController;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //  Initializes the table with the observablelist
    }

    //  Methods to set and go to scenes
    @FXML
    void setErrorScene(Scene scene){
        // Sets the error scene
    }

    @FXML
    void setEditScene(Scene scene){
        //  Sets the edit scene
    }

    @FXML
    void goErrorScene(ActionEvent event){
        //  Sets the error scene
    }

    @FXML
    void goEditScene(ActionEvent event){
        //  Sets the edit scene
    }

    //  FXML events
    @FXML
    void addItemPressed(ActionEvent event) {
        //  Calls an instance of ListOfItems to utilize functions within that method
        //  Gets the information from each of the input fields and passes them to a function within ListOfItems
        //      Error checks the serial to ensure its in format
        //  Checks if a string was returned
        //      If a string was returned
        //          An item wasn't added to the list, and an error message will show with the corresponding error
        //      If a string wasn't returned
        //          An item was added to the list successfully
    }

    @FXML
    void deleteInventoryPressed(ActionEvent event) {
        //  Calls an instance of ListOfItems to utilize functions within that method
        //  Calls method in ListOfItems to clear list
    }

    @FXML
    void deleteItemPressed(ActionEvent event) {
        //  Calls an instance of ListOfItems to utilize functions within that method
        //  Calls method in ListOfItems to delete item
        //  Gets an index from the selected element in the table
        //  If there is an IndexOutOfBounds, then it will go to the error screen with the corresponding error
    }

    @FXML
    void editItemPressed(ActionEvent event) {
        //  Gets an index from the selected element in the table
        //  Transfers the information to the edit scene screen, where it will handle changing the element in the list
        //  If the index is invalid, then it will go to the error screen where it shows the corresponding error
    }

    @FXML
    void loadInventoryPressed(ActionEvent event) {
        //  Calls an instance of ListOfItems to utilize functions within that method
        //  Uses a FileChooser to get the file that it is choosing to load from (With an initial directory as well as
        //  the selectable files)
        //  If the file selected was null
        //      Depending on which was chosen, it will choose the corresponding method in the instance of ListOfItems
        //      to load the file
    }

    @FXML
    void saveInventoryPressed(ActionEvent event) {
        //  Calls an instance of ListOfItems to utilize functions within that method
        //  Uses a FileChooser to save the file (With an initial directory as well as
        //  the selectable files)
        //  If the file selected was null
        //      Depending on which was chosen, it will choose the corresponding method in the instance of ListOfItems
        //      to save the file appropriately
    }

    @FXML
    void searchItemPressed(ActionEvent event) {
        //  Calls an instance of ListOfItems to utilize functions within that method
        //  Gets whatever is in the input field and passes it to a function in the instance of ListOfItems
        //  Will update the list to show those items
    }

    //  Functions to set elements within this controller
    void setItemList(ObservableList<Item> item){
        //  Sets this list to a list from the outside
    }
}