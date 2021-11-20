/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InventoryManagementApplication extends Application {
    public static void main(String[] args){
        //  Launches the application
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        //  Creates all the FXMLLoaders
        FXMLLoader inventoryLoad = new FXMLLoader(getClass().getResource("/baseline/InventoryListScene.fxml"));
        FXMLLoader editLoad = new FXMLLoader(getClass().getResource("/baseline/EditItemScene.fxml"));
        FXMLLoader errorLoad = new FXMLLoader(getClass().getResource("/baseline/ErrorMessageScene.fxml"));

        //  Set up roots
        Parent inventoryRoot = inventoryLoad.load();
        Parent editRoot = editLoad.load();
        Parent errorRoot = errorLoad.load();

        //  Set up Scenes
        Scene inventoryScene = new Scene(inventoryRoot);
        Scene editScene = new Scene(editRoot);
        Scene errorScene = new Scene(errorRoot);

        //  Set up controllers as well as allows them to have access to other controllers and scenes
        //  Inventory scene set up
        InventoryListSceneController inventoryControl = inventoryLoad.getController();
        inventoryControl.getEditController(editLoad);
        inventoryControl.setEditScene(editScene);
        inventoryControl.getErrorController(errorLoad);
        inventoryControl.setErrorScene(errorScene);

        //  Edit scene set up
        EditItemSceneController editControl = editLoad.getController();
        editControl.getInventoryController(inventoryLoad);
        editControl.setInventoryScene(inventoryScene);
        editControl.getErrorController(errorLoad);
        editControl.setErrorScene(errorScene);

        //  Error scene set up
        ErrorMessageSceneController errorControl = errorLoad.getController();
        errorControl.setInventoryScene(inventoryScene);

        //  Sets the main scene
        primaryStage.setTitle("Inventory Management");
        primaryStage.setScene(inventoryScene);
        primaryStage.show();
    }
}