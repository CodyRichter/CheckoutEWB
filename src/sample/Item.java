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

    public Item(boolean fromFile) {
        if(true)return;
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

    public void setNumber(int number) {
        for (Item i : Controller.items) {
            if (i.getNumber()==number) return;
        }
        this.number = number;
    }

    public String getName() {
        if (name == null) return "";
        return name;
    }

    public static Item getItemFromID(String ID) {
        for(Item i:Controller.items) {
            if((""+i.getNumber()).equals(ID)) {
                return i;
            }
        }
        return null;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {return number;}

    public Guest getOwner() {return owner;}

    public String getNotes() {
        if (notes==null) return "";
        return notes;}

    public String toString() {
        if (name == null || name.equals("")) return ""+number;
       return ""+number+" "+name;
    }
}
