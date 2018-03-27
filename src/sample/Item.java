package sample;

public class Item {

    private static int totalItems = 0; //Total Number Of Guests Attending

    //ID Number:
    private int number;

    //Information
    private String name;
    private double price;
    private String notes;

    private Guest owner;


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

    public void setPrice(double price) {
        if (price > 0) this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Guest owner) {
        this.owner = owner;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Guest getOwner() {return owner;}

    public String getNotes() {return notes;}
}
