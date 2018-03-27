package sample;

import java.util.ArrayList;

public class Item {

    private static int totalItems = 0; //Total Number Of Guests Attending

    //ID Number:
    private int number;

    //Information
    private String name;
    private int price;

    public Item() {
        //Set Up Current Guest Number
        number = totalItems;
        totalItems++;
    }

    public Item(String name, int price) {
        super();
        this.name = name;
        this.price = price;
    }

    public void setPrice(int price) {
        if (price > 0) this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }




    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
