/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.File;
import java.text.DecimalFormat;
import java.util.regex.Pattern;


public class ListOfItems {
    public String addItemToList(ObservableList<Item> list, String name, String price, String serial){
        //  Returns a string depending on if an item is added to the list or not
        StringBuilder output = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.00");
        String priceString = "";
        
        //  If the list is full
        if(list.size() >= 1024){
            //  Return a string that says the list is full
            output.append("The inventory is full. Please delete an item from the list. ");
        }

        //  If the item is already in the list (This is based off serial number)
        if(doesAlreadyExist(list, serial)){
            //  Return a string that says that the item already exists
            output.append("This item already exists in the inventory. Please enter a new serial number. ");
        }

        //  If the item's price is invalid (Either less than 0 or contains characters)
        try{
            double priceDouble = Double.parseDouble(price);
            if(priceDouble < 0){
                //  Return a string that says the item's price is less than 0
                output.append("Invalid price for money. Please ensure that the price is above 0. ");
            } else {
                //  Converts the price to a string with the dollar sign
                priceString = "$" + df.format(priceDouble);
            }
        } catch(NumberFormatException a){
            //  Returns a string that says the item's price contains letters (which it shouldn't)
            output.append("Invalid format for money. Please ensure that there is only digits and decimals when necessary. ");
        }

        //  If the name is invalid
        if(name.length() < 2 || name.length() > 256){
            //  Return that the name is invalid
            output.append("The name is invalid. Please ensure that the length is between 2-256 characters. ");
        }

        //  If the serial is invalid
        if(!(Pattern.matches("[A-Z][-][\\dA-Z]{3}[-][\\dA-Z]{3}[-][\\dA-Z]{3}", serial))){
            //  Return that the serial invalid
            output.append("The serial number is invalid. Please ensure that the format is A-XXX-XXX-XXX. ");
        }

        //  Else
        if(output.isEmpty()){
            //  Add the item to the list
            list.add(new Item(name, priceString, serial));
        }

        //  Return the output string
        return output.toString();
    }

    public String editItemInList(Item editItem, String name, String price, String serial){
        StringBuilder output = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.00");
        String priceString = "";
        //  Returns a string depending on if an item is edited or not

        //  If the item's price is invalid (Either less than 0 or contains characters)
        try{
            double priceDouble = Double.parseDouble(price);
            if(priceDouble < 0){
                //  Return a string that says the item's price is less than 0
                output.append("Invalid price for money. Please ensure that the price is above 0. ");
            } else {
                //  Converts the price to a string with the dollar sign
                priceString = "$" + df.format(priceDouble);
            }
        } catch(NumberFormatException a){
            //  Returns a string that says the item's price contains letters (which it shouldn't)
            output.append("Invalid format for money. Please ensure that there is only digits and decimals when necessary. ");
        }

        //  If the name is invalid
        if(name.length() < 2 || name.length() > 256){
            //  Return that the name is invalid
            output.append("The name is invalid. Please ensure that the length is between 2-256 characters. ");
        }

        //  If the serial is invalid
        if(!(Pattern.matches("[A-Z][-][\\dA-Z]{3}[-][\\dA-Z]{3}[-][\\dA-Z]{3}", serial))){
            //  Return that the serial invalid
            output.append("The serial number is invalid. Please ensure that the format is A-XXX-XXX-XXX. ");
        }

        //  Else
        if(output.isEmpty()){
            //  Edit the items using setters and getters
            editItem.setName(name);
            editItem.setPrice(priceString);
            editItem.setSerial(serial);
        }

        //  Return the output string
        return output.toString();
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
        ObservableList<Item> filteredList = FXCollections.observableArrayList();

        for(int i = 0; i < list.size(); i++){
            String name = list.get(i).getName();
            String serial = list.get(i).getSerial();

            //  This if statement will ignore the case values
            if(Pattern.compile(Pattern.quote(search), Pattern.CASE_INSENSITIVE).matcher(name).find() ||
                    Pattern.compile(Pattern.quote(search), Pattern.CASE_INSENSITIVE).matcher(serial).find()){
                filteredList.add(list.get(i));
            }
        }

        return filteredList;
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
        //  Goes through each element of the list and checks the serial
        for(int i = 0; i < list.size(); i++){
            //  If the serial does much, it will return true
            if(list.get(i).getSerial().equals(serial)){
                return true;
            }
        }

        //  Else it will just return false
        return false;
    }
}