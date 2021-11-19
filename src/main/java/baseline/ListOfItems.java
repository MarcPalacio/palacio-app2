/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

import javafx.collections.ObservableList;
import java.io.File;

public class ListOfItems {
    public String addItemToList(ObservableList<Item> list, String name, double price, String serial){
        //  Returns a string depending on if an item is added to the list or not
        //  If the list is full
        //      Return a string that says the list is full
        //  If the item is already in the list
        //      Return a string that says that the item already exists
        //  If the name is invalid
        //      Return that the name is invalid
        //  If the price is invalid
        //      Return that the price is invalid
        //  If the serial is invalid
        //      Return that the serial invalid
        //  Else
        //      Add the item to the list
        //  Return the output string
        return "";
    }

    public String editItemInList(Item editItem, String name, double price, String serial){
        //  Returns a string depending on if an item is edited or not
        //  If the name is invalid
        //      Return that the name is invalid
        //  If the price is invalid
        //      Return that the price is invalid
        //  If the serial is invalid
        //      Return that the serial invalid
        //  Else
        //      Edit item using setters and getters
        //  Return the output string
        return "";
    }

    public void deleteItemInList(ObservableList<Item> list, int index){
        //  Deletes selected items in the list
    }

    public void deleteAllItems(ObservableList<Item> list){
        //  Just clears list
    }

    public ObservableList<Item> searchItems(ObservableList<Item> list, String search){
        //  Checks which format the string is in (Serial or not serial)
        //  If it is in the format of serial number, then it will only search the serial numbers
        //  Else, it will only search the names of the items
        return list;
    }

    public void saveListFile(ObservableList<Item> list, File outputFile){
        //  Figures out which file format was chosen then uses function from MyFileWriter to write the file
        //  Note: Alternative would be to add buttons to save each file accordingly
    }

    public void loadSaveFile(ObservableList<Item> list){
        //  Reads in the file and determines which methods to use to read in the file
        //  Calls methods from MyFileReader
        //  Note: Alternative would be to add buttons to load each file accordingly
    }

    public String writeSaveFileTSV(ObservableList<Item> list){
        //  Takes each item and stores them into a TSV
        //  Returns the string
        return "";
    }

    public String writeSaveFileHTML(ObservableList<Item> list){
        //  Takes each item and stores them into an HTML file
        //  Returns the string to print on the file
        return "";
    }

    public String writeSaveFileJSON(ObservableList<Item> list){
        //  Takes each item and creates a JSON string
        return "";
    }
}