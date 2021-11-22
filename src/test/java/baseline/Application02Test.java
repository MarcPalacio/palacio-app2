package baseline;

import static org.junit.jupiter.api.Assertions.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import java.io.File;

class Application02Test {
    @Test
    void testAddItemNameInvalid(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and attempts to add an element to the list
        ObservableList<Item> list = FXCollections.observableArrayList();

        //  Gets a string while adding an element, if the string matches the error, then the item wasn't added to the list
        //  The error should correspond with the name being less than 2 characters
        String actual = helper.addItemToList(list, "a", "10", "A-123-123-123");
        String expected = "The name is invalid. Please ensure that the length is between 2-256 characters. ";

        assertEquals(expected, actual);
    }

    @Test
    void testAddItemMoneyInvalidLetters(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and attempts to add an element to the list
        ObservableList<Item> list = FXCollections.observableArrayList();

        //  Gets a string while adding an element, if the string matches the error, then the item wasn't added to the list
        //  The error should correspond with the money being in the wrong format
        String actual = helper.addItemToList(list, "Potato", "abc", "A-123-123-123");
        String expected = "Invalid format for money. Please ensure that there is only digits and decimals when necessary. ";

        assertEquals(expected, actual);
    }

    @Test
    void testAddItemMoneyInvalidNumber(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and attempts to add an element to the list
        ObservableList<Item> list = FXCollections.observableArrayList();

        //  Gets a string while adding an element, if the string matches the error, then the item wasn't added to the list
        //  The error should correspond with the money being less than 0
        String actual = helper.addItemToList(list, "Potato", "-1", "A-123-123-123");
        String expected = "Invalid price for money. Please ensure that the price is above 0. ";

        assertEquals(expected, actual);
    }

    @Test
    void testAddItemSerialInvalidFormat(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and attempts to add an element to the list
        ObservableList<Item> list = FXCollections.observableArrayList();

        //  Gets a string while adding an element, if the string matches the error, then the item wasn't added to the list
        //  The error should correspond with the serial being in the wrong format
        String actual = helper.addItemToList(list, "Potato", "2.50", "A");
        String expected =
                "The serial number is invalid. Please ensure that the format is A-XXX-XXX-XXX. Where A is a " +
                "capital letter and X is a digit or capital letter. ";

        assertEquals(expected, actual);
    }

    @Test
    void testAddItemSerialInvalidDupe(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and attempts to add an element to the list
        ObservableList<Item> list = FXCollections.observableArrayList();

        //  Gets a string while adding an element, if the string matches the error, then the item wasn't added to the list
        //  The error should correspond with the serial already existing
        helper.addItemToList(list, "Potato", "2.50", "A-123-123-123");
        String actual = helper.addItemToList(list, "Potato", "2.50", "A-123-123-123");
        String expected = "This item already exists in the inventory. Please enter a new serial number. ";

        assertEquals(expected, actual);
    }

    @Test
    void testAddItemSuccess(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and attempts to add an element to the list
        ObservableList<Item> list = FXCollections.observableArrayList();

        //  Gets a string while adding an element, if the string matches the error, then the item wasn't added to the list
        //  No error should be displayed here
        String actual = helper.addItemToList(list, "Potato", "2.50", "P-123-123-123");
        String expected = "";

        assertEquals(expected, actual);
    }

    @Test
    void testRemoveItem(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and attempts to add an element to the list
        ObservableList<Item> list = FXCollections.observableArrayList();
        helper.addItemToList(list, "Potato", "2.50", "P-123-123-123");

        //  Then removes that element so that the list is empty, showing that the item was successfully deleted
        helper.deleteItemInList(list, 0);

        //  Checks if the list is empty
        boolean isListEmpty = false;
        if(list.isEmpty()){
            isListEmpty = true;
        }

        assertTrue(isListEmpty);
    }

    @Test
    void testDeleteList(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and attempts to add elements to the list
        ObservableList<Item> list = FXCollections.observableArrayList();
        helper.addItemToList(list, "Potato", "2.50", "P-123-123-123");
        helper.addItemToList(list, "Carrot", "2.50", "C-123-123-123");
        helper.addItemToList(list, "Rice", "3.50", "R-123-123-123");

        //  Then removes that element so that the list is empty, showing that the item was successfully deleted
        helper.deleteAllItems(list);

        //  Checks if the list is empty
        boolean isListEmpty = false;
        if(list.isEmpty()){
            isListEmpty = true;
        }

        assertTrue(isListEmpty);
    }

    @Test
    void testEditNameFail(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and attempts to add an element to the list
        ObservableList<Item> list = FXCollections.observableArrayList();
        helper.addItemToList(list, "Potat", "2.50", "P-123-123-123");

        //  Attempts to edit the name of the item
        //  actual should equal a string to show that there was an error
        String actual = helper.editItemInList(list.get(0), "", "2.50", "P-123-123-123");
        String expected = "The name is invalid. Please ensure that the length is between 2-256 characters. ";

        assertEquals(expected, actual);
    }

    @Test
    void testEditNameSuccess(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and attempts to add an element to the list
        ObservableList<Item> list = FXCollections.observableArrayList();
        helper.addItemToList(list, "Potat", "2.50", "P-123-123-123");

        //  Attempts to edit the name of the item
        //  actual should equal a string to show that there was an error
        String actual = helper.editItemInList(list.get(0), "Potato", "2.50", "P-123-123-123");
        String expected = "";

        assertEquals(expected, actual);
    }

    @Test
    void testEditSerialFail(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and attempts to add an element to the list
        ObservableList<Item> list = FXCollections.observableArrayList();
        helper.addItemToList(list, "Potato", "2.50", "P-123-123-123");

        //  Attempts to edit the serial number of the item
        //  actual should equal a string to show that there was an error
        String actual = helper.editItemInList(list.get(0), "Potato", "2.50", "P-123-123");
        String expected =
                "The serial number is invalid. Please ensure that the format is A-XXX-XXX-XXX. Where A is a " +
                "capital letter and X is a digit or capital letter. ";;

        assertEquals(expected, actual);
    }

    @Test
    void testEditPriceFail(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and attempts to add an element to the list
        ObservableList<Item> list = FXCollections.observableArrayList();
        helper.addItemToList(list, "Potato", "2.50", "P-123-123-123");

        //  Attempts to edit the name of the item
        //  actual should equal a string to show that there was an error
        String actual = helper.editItemInList(list.get(0), "Potato", "abc", "P-123-123-123");
        String expected = "Invalid format for money. Please ensure that there is only digits and decimals when necessary. ";

        assertEquals(expected, actual);
    }

    @Test
    void testEditPriceSuccess(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and attempts to add an element to the list
        ObservableList<Item> list = FXCollections.observableArrayList();
        helper.addItemToList(list, "Potato", "2.50", "P-123-123-123");

        //  Attempts to edit the name of the item
        //  actual should equal a string to show that there was an error
        String actual = helper.editItemInList(list.get(0), "Potato", "2.75", "P-123-123-123");
        String expected = "";

        assertEquals(expected, actual);
    }

    @Test
    void testSearchSerial(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds elements to that list
        ObservableList<Item> list = FXCollections.observableArrayList();
        helper.addItemToList(list, "Potato", "2.50", "P-123-123-123");
        helper.addItemToList(list, "Carrot", "2.50", "C-123-123-123");
        helper.addItemToList(list, "Rice", "3.50", "R-123-123-123");

        //  Uses searchString and adds elements to the new list
        //  Since serial numbers are unique, there should only be one element in the list, which is the searched
        //  item
        String searchString = "P-123-123-123";
        ObservableList<Item> search = helper.searchItems(list, searchString);

        //  Checks if the two strings are equal
        boolean isEqual = false;
        if(searchString.equals(search.get(0).getSerial())){
            isEqual = true;
        }

        assertTrue(isEqual);
    }

    @Test
    void testSearchName(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds elements to that list
        ObservableList<Item> list = FXCollections.observableArrayList();
        helper.addItemToList(list, "Potato", "2.50", "P-123-123-123");
        helper.addItemToList(list, "Carrot", "2.50", "C-123-123-123");
        helper.addItemToList(list, "Parrot", "100.00", "R-123-123-123");

        //  Uses searchString and adds elements to the new list
        //  Gets all the elements that contain that specific string within it
        String searchString = "arrot";
        ObservableList<Item> search = helper.searchItems(list, searchString);

        //  Checks if the item has the searched string within it
        //  It is done this way so that the first instance that doesn't match would automatically fail this case
        boolean isEqual = true;
        for(int i = 0; i < search.size(); i++){
            if(!(search.get(i).getName().contains(searchString))){
                isEqual = false;
            }
        }

        assertTrue(isEqual);
    }

    @Test
    void testSaveFileTSV(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds elements to that list
        ObservableList<Item> list = FXCollections.observableArrayList();
        helper.addItemToList(list, "RTX 3060", "500.00", "R-000-A30-A60");
        helper.addItemToList(list, "RTX 3080", "800.00", "R-000-A30-A80");
        helper.addItemToList(list, "RTX 3090", "1500.00", "R-000-A30-A90");
        helper.addItemToList(list, "Kidneys", "5000.00", "K-IDN-EYS-POG");

        //  Creates string in the format of TSV that will be written to the file
        String actual = helper.writeSaveFileTSV(list);
        String expected =
                "Serial Number\tName\tValue\n" +
                "R-000-A30-A60\tRTX 3060\t$500.00\n" +
                "R-000-A30-A80\tRTX 3080\t$800.00\n" +
                "R-000-A30-A90\tRTX 3090\t$1500.00\n" +
                "K-IDN-EYS-POG\tKidneys\t$5000.00";

        assertEquals(expected, actual);
    }

    @Test
    void testSaveFileHTML(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list and adds elements to that list
        ObservableList<Item> list = FXCollections.observableArrayList();
        helper.addItemToList(list, "RTX 3060", "500.00", "R-000-A30-A60");
        helper.addItemToList(list, "RTX 3080", "800.00", "R-000-A30-A80");
        helper.addItemToList(list, "RTX 3090", "1500.00", "R-000-A30-A90");
        helper.addItemToList(list, "Kidneys", "5000.00", "K-IDN-EYS-POG");

        //  Creates string in the format of HTML that will be written to the file
        String actual = helper.writeSaveFileHTML(list);
        String expected =
                "<html>\n" +
                "\t<table>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th>Name</th>\n" +
                "\t\t\t<th>Price</th>\n" +
                "\t\t\t<th>Serial Number</th>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th>RTX 3060</th>\n" +
                "\t\t\t<th>$500.00</th>\n" +
                "\t\t\t<th>R-000-A30-A60</th>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th>RTX 3080</th>\n" +
                "\t\t\t<th>$800.00</th>\n" +
                "\t\t\t<th>R-000-A30-A80</th>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th>RTX 3090</th>\n" +
                "\t\t\t<th>$1500.00</th>\n" +
                "\t\t\t<th>R-000-A30-A90</th>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th>Kidneys</th>\n" +
                "\t\t\t<th>$5000.00</th>\n" +
                "\t\t\t<th>K-IDN-EYS-POG</th>\n" +
                "\t\t</tr>\n" +
                "\t</table>\n" +
                "</html>";

        assertEquals(expected, actual);
    }

    @Test
    void testLoadFileTSV(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list from the input file
        ObservableList<Item> actual = FXCollections.observableArrayList();
        File inputFile = new File("docs\\TestLoadTXTFile.txt");
        //  Note, since we are specifically testing for a TSV (which should be a .txt)
        //  I will manually put in the type, the program will do this automatically
        helper.loadSaveFile(actual, inputFile, "txt");


        //  Creates a new list and adds elements to that list
        ObservableList<Item> expected = FXCollections.observableArrayList();
        helper.addItemToList(expected, "Potatos", "2.50", "P-123-123-123");
        helper.addItemToList(expected, "Carrots", "2.50", "C-123-123-123");
        helper.addItemToList(expected, "Rice", "4.50", "R-123-123-123");

        //  Compares both values of the list
        boolean isListSame = true;
        for(int i = 0; i < expected.size(); i++){
            if (!(actual.get(i).getName().equals(expected.get(i).getName()) ||
                    actual.get(i).getSerial().equals(expected.get(i).getSerial()) ||
                    actual.get(i).getPrice().equals(expected.get(i).getPrice()))) {
                isListSame = false;
                break;
            }
        }

        assertTrue(isListSame);
    }

    @Test
    void testLoadFileHTML(){
        ListOfItems helper = new ListOfItems();

        //  Creates a new list from the input file
        ObservableList<Item> actual = FXCollections.observableArrayList();
        File inputFile = new File("docs\\TestLoadHTMLFile.html");
        //  Note, since we are specifically testing for a HTML
        //  I will manually put in the type, the program will do this automatically
        helper.loadSaveFile(actual, inputFile, "html");


        //  Creates a new list and adds elements to that list
        ObservableList<Item> expected = FXCollections.observableArrayList();
        helper.addItemToList(expected, "Potatos", "2.50", "P-123-123-123");
        helper.addItemToList(expected, "Carrots", "2.50", "C-123-123-123");
        helper.addItemToList(expected, "Rice", "4.50", "R-123-123-123");

        //  Compares both values of the list
        boolean isListSame = true;
        for(int i = 0; i < expected.size(); i++){
            if (!(actual.get(i).getName().equals(expected.get(i).getName()) ||
                    actual.get(i).getSerial().equals(expected.get(i).getSerial()) ||
                    actual.get(i).getPrice().equals(expected.get(i).getPrice()))) {
                isListSame = false;
                break;
            }
        }

        assertTrue(isListSame);
    }
}