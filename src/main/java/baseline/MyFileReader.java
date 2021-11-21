/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

import javafx.collections.ObservableList;

import java.io.*;

public class MyFileReader {
    public void scanInputFileTSV(ObservableList<Item> item, File inputFile){
        //  Creates an instance of ListOfItems to use function addItemToList
        ListOfItems helper = new ListOfItems();

        //  Creates a file reader
        try(BufferedReader br = new BufferedReader(new FileReader(inputFile))){
            String add;
            int count = 0;
            //  While the line isn't empty
            while((add = br.readLine()) != null){
                //  Since the first line is a header, it will ignore it then add elements to the list
                if(count != 0){
                    //  Separates the serial number from the rest of the string
                    String serial = add.substring(0, add.indexOf("\t"));

                    //  Cuts off the serial number for the rest of the input
                    add = add.substring(add.indexOf("\t")+1);

                    //  Separates the name of the item from the rest of the string
                    String name = add.substring(0, add.indexOf("\t"));

                    //  Cuts off the name from the rest of the input
                    add = add.substring(add.indexOf("\t")+1);

                    //  The remainder of the string is price
                    //  Has to ignore the "$" at the beginning to have a valid input
                    //  It gets put back later on, this is just to check that the number is valid
                    String price = add.substring(1);

                    // Adds item to the list once getting all it's properties
                    String h = helper.addItemToList(item, name, price, serial);
                }
                //  Adds to the count whenever it runs through the inputs
                count++;
            }
        } catch(FileNotFoundException e) { // Exception handling
            System.out.println("File not found");
        } catch(IOException a) { // Exception handling
            System.out.println("An I/O Error occurred");
            a.printStackTrace();
        }
    }

    public void scanInputFileHTML(ObservableList<Item> item, File inputFile){
        //  Creates file reader based on the file type

        //  Creates an instance of ListOfItems to use function addItemToList
        ListOfItems helper = new ListOfItems();

        try(BufferedReader br = new BufferedReader(new FileReader(inputFile))){
            String add;
            int count = 0;
            while((add = br.readLine()) != null) {
                //  Scans the file and check for the certain headers of the HTML file
                if(add.contains("<th>")){
                    //  Checks so it doesn't add first row of the table since that is just words
                    count++;
                    //  Adds information accordingly to the based on which column/row is being scanned at the time
                    if(count > 3){
                        //  Gets the name without the html header
                        //  Then separates that string from the end of the corresponding html header
                        String nameFirst  = add.substring(add.indexOf("<th>")+4);
                        String nameActual = nameFirst.substring(0, nameFirst.indexOf("</th>"));

                        //  Reads the next line
                        add = br.readLine();

                        //  Gets the price without the html header
                        //  Then separates that string from the end of the corresponding html header as well
                        //  as the "$" to verify it is a number, will be added back later
                        String priceFirst = add.substring(add.indexOf("<th>")+4);
                        String priceActual = priceFirst.substring(1, priceFirst.indexOf("</th>"));

                        //  Reads the next line
                        add = br.readLine();

                        //  Gets the serial without the html header
                        //  Then separates that string from the end of the corresponding html header
                        String serialFirst = add.substring(add.indexOf("<th>")+4);
                        String serialActual = serialFirst.substring(0, serialFirst.indexOf("</th>"));

                        //  Adds the item to the list
                        String h = helper.addItemToList(item, nameActual, priceActual, serialActual);
                    }
                }

            }
        } catch(FileNotFoundException e){ // Exception handling
            System.out.println("File not found");
        } catch(IOException a){ // Exception handling
            System.out.println("An I/O Error occurred");
            a.printStackTrace();
        }
    }
}
