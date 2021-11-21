/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
    public void writeToFile(String list, File outputFile){
        //  This method can be used for both HTML and TSV since you can print to a file for HTML
        //  Create a file writer and write to the output file
        //  With exception handling
        try(FileWriter fr = new FileWriter(outputFile)){
            // Writes to file outputFile with the String
            fr.write(list);
        } catch(FileNotFoundException e){ // Exception handling
            System.out.println("File not found");
        } catch(IOException a){ // Exception handling
            System.out.println("An I/O Error occurred");
            a.printStackTrace();
        }

    }
}
