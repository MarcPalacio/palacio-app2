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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.text.DecimalFormat;
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
    @FXML private TableView<Item> inventoryTable;
    @FXML private Button loadInventoryButton;
    @FXML private TableColumn<Item, String> nameColumn;
    @FXML private TableColumn<Item, Double> priceColumn;
    @FXML private Button saveInventoryButton;
    @FXML private TextField searchInput;
    @FXML private Button searchItemButton;
    @FXML private TableColumn<Item, String> serialColumn;

    //  Attributes
    ObservableList<Item> inventoryList = FXCollections.observableArrayList();
    private Scene errorScene;
    private Scene editScene;
    private FXMLLoader errorController;
    private FXMLLoader editController;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //  Initializes the table with the ObservableList
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        serialColumn.setCellValueFactory(new PropertyValueFactory<>("serial"));
        inventoryTable.setItems(inventoryList);
    }

    //  Methods to set and go to scenes and get controller info
    @FXML
    void setErrorScene(Scene scene){
        // Sets the error scene
        errorScene = scene;
    }

    @FXML
    void setEditScene(Scene scene){
        //  Sets the edit scene
        editScene = scene;
    }

    @FXML
    void goErrorScene(ActionEvent event){
        //  Sets the error scene
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(errorScene);
    }

    @FXML
    void goEditScene(ActionEvent event){
        //  Sets the edit scene
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(editScene);
    }

    @FXML
    void getErrorController(FXMLLoader errorController){
        //  Gets the error controller
        this.errorController = errorController;
    }

    @FXML
    void getEditController(FXMLLoader editController){
        //  Gets the edit controller
        this.editController = editController;
    }

    //  FXML events
    @FXML
    void addItemPressed(ActionEvent event) {
        //  Calls an instance of ListOfItems to utilize functions within that method
        ListOfItems helper = new ListOfItems();
        ErrorMessageSceneController error = errorController.getController();
        DecimalFormat df = new DecimalFormat("0.00");
        StringBuilder errorMessage = new StringBuilder();

        //  Gets the information from each of the input fields and passes them to a function within ListOfItems
        try{
            String name = addInputName.getText();

            double priceDouble = Double.parseDouble(addInputPrice.getText());
            if(priceDouble < 0){
                errorMessage.append("Invalid price for money. ");
            }
            String priceString = "$" + df.format(priceDouble);

            String serial = addInputSerial.getText();
            errorMessage.append(helper.addItemToList(inventoryList, name, priceString, serial));

            //  Checks if a string was returned
            //  If the string isn't empty
            if(!(errorMessage.toString().isEmpty())){
                //  An item wasn't added to the list, and an error message will show with the corresponding error
                errorMessage.append("Please validate your inputs.");
                error.setLabelError(errorMessage.toString());
                goErrorScene(event);
            }
            //  If a string wasn't returned
            else{
                //  An item was added to the list successfully and the list will update
                addInputName.clear();
                addInputPrice.clear();
                addInputSerial.clear();
                inventoryTable.refresh();
            }
        } catch(NumberFormatException e){
            //  An error that can be caught here
            //  Note: NullPointerException would be one, but when it pulls the information from the price
            //  text input, it actually is an empty string ""
            error.setLabelError("Invalid input for money. Please input a valid input.");
            goErrorScene(event);
        }
    }

    @FXML
    void deleteInventoryPressed(ActionEvent event) {
        //  Calls an instance of ListOfItems to utilize functions within that method
        ListOfItems helper = new ListOfItems();
        //  Calls method in ListOfItems to clear list
        helper.deleteAllItems(inventoryList);
        inventoryTable.refresh();
    }

    @FXML
    void deleteItemPressed(ActionEvent event) {
        //  Calls an instance of ListOfItems to utilize functions within that method
        ListOfItems helper = new ListOfItems();
        ErrorMessageSceneController error = errorController.getController();
        int index;

        try{
            //  Gets an index from the selected element in the table
            index = inventoryList.indexOf(inventoryTable.getSelectionModel().getSelectedItem());
            //  Calls method in ListOfItems to delete item
            helper.deleteItemInList(inventoryList, index);
            inventoryTable.refresh();
        } catch(IndexOutOfBoundsException a){
            //  If there is an IndexOutOfBounds, then it will go to the error screen with the corresponding error
            error.setLabelError("Please ensure you are selecting an element in the inventory.");
            goErrorScene(event);
        }
    }

    @FXML
    void editItemPressed(ActionEvent event) {
        // Creates instance of controllers
        EditItemSceneController edit = editController.getController();
        ErrorMessageSceneController error = errorController.getController();

        //  Gets an index from the selected element in the table
        int index = inventoryList.indexOf(inventoryTable.getSelectionModel().getSelectedItem());

        // Checks the index to decide where it goes
        try{
            //  Transfers the information to the edit scene screen, where it will handle changing the element in the list
            edit.setTextInputs(inventoryList.get(index).getName(), inventoryList.get(index).getPrice(), inventoryList.get(index).getSerial());
            goEditScene(event);
        } catch(IndexOutOfBoundsException a) {
            //  If the index is invalid, then it will go to the error screen where it shows the corresponding error
            error.setLabelError("Please ensure you are selecting an element in the inventory.");
            goErrorScene(event);
        }
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