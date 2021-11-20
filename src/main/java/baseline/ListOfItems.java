/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

import javafx.collections.ObservableList;
import java.io.File;
import java.util.regex.Pattern;


public class ListOfItems {
    public String addItemToList(ObservableList<Item> list, String name, String price, String serial){
        //  Returns a string depending on if an item is added to the list or not
        StringBuilder output = new StringBuilder();

        //  If the list is full
        if(list.size() >= 1024){
            //  Return a string that says the list is full
            output.append("The inventory is full. ");
        }

        //  If the item is already in the list (This is based off serial number)
        else if(doesAlreadyExist(list, serial)){
            //  Return a string that says that the item already exists
            output.append("This item already exists in the inventory. ");
        }

        //  If the name is invalid
        else if(name.length() < 2 || name.length() > 256){
            //  Return that the name is invalid
            output.append("The name is invalid. ");
        }

        //  If the serial is invalid
        else if(!(Pattern.matches("[A-Z][-][\\dA-Z]{3}[-][\\dA-Z]{3}[-][\\dA-Z]{3}", serial))){
            //  Return that the serial invalid
            output.append("The serial number is invalid. ");
        }

        //  Else
        else{
            //  Add the item to the list
            list.add(new Item(name, price, serial));
        }

        //  Return the output string
        return output.toString();
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
        list.remove(list.get(index));
    }

    public void deleteAllItems(ObservableList<Item> list){
        //  Just clears list
        list.clear();
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

    private boolean doesAlreadyExist(ObservableList<Item> list, String serial){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getSerial().equals(serial)){
                return true;
            }
        }
        return false;
    }
}