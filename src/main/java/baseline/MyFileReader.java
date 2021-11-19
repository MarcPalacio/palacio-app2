/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

import javafx.collections.ObservableList;
import java.io.File;

public class MyFileReader {
    public void scanInputFileTSV(ObservableList<Item> item, File inputFile){
        //  Creates a file reader based on the file type
        //  Scans the file and check where there are tabs
        //  Separates the name, price, and serial accordingly then adds that item to the list
        //  Also add exception handling
    }

    public void scanInputFileHTML(ObservableList<Item> item, File inputFile){
        //  Creates file reader based on the file type
        //  Scans the file and check for the certain headers of the HTML file
        //  Adds information accordingly to the based on which column/row is being scanned at the time
        //  Also add exception handling
    }

    public void scanInputFileJSON(ObservableList<Item> item, File inputFile){
        //  Creates a file reader based on the file type
        //  Scans the JSON file and adds the items to the list
    }
}
