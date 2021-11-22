/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Marc Palacio
 */

package baseline;

public class Item {
    //  Attributes of Item Class
    private String name;
    private String price;
    private String serial;

    public Item(String name, String price, String serial){
        //  Calls setters to create Item
        setName(name);
        setPrice(price);
        setSerial(serial);
    }

    public void setName(String name){
        //  Takes in the parameter to set the name
        this.name = name;
    }

    public void setPrice(String price){
        //  Takes in the parameter to set the price
        this.price = price;
    }

    public void setSerial(String serial){
        //  Takes in the parameter to set the serial
        this.serial = serial;
    }

    public String getName(){
        //  Returns name of the item
        return name;
    }

    public String getPrice(){
        //  Returns price of the item
        return price;
    }

    public String getSerial(){
        //  Returns serial of the item
        return serial;
    }
}
