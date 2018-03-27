package sample;

import java.util.ArrayList;

public class Guest {
    private static int totalGuests = 0; //Total Number Of Guests Attending

    //ID Number:
    private int number;

    //Personal Information
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String email;
    private String notes;

    //Entry Donation Info
    private double entryDonation;
    private boolean paidEntryDonationCash;

    //Add-On Item Info
    private int numberShirts;
    private int numberCups;
    private double donation;

    //Auction Items
    private ArrayList<Item> items;
    private boolean paidAuctionItemsCash;
    private double amountPaid;
    private double changeGiven; //Amount of change given back to guest

    private boolean orderComplete; //Whether everything with this guest has been completed


    public Guest() {
        //Set Up Current Guest Number
        number = totalGuests;
        totalGuests++;
    }

    public Guest(String lastName, String firstName, String phoneNumber, String email, String notes) {
        number = totalGuests;
        totalGuests++;

        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.notes = notes;

    }

    //
    //-------------
    //  Setters
    //-------------
    //

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDonation(double donation) {
        this.donation = donation;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets number of shirts guest will purchase
     *
     * @param numberShirts amount being purchased
     */
    public void setNumberShirts(int numberShirts) {
        if (numberShirts < 0) this.numberShirts = 0;
        this.numberShirts = numberShirts;
    }

    /**
     * Sets number of cups guest will purchase
     *
     * @param numberCups amount being purchased
     */
    public void setNumberCups(int numberCups) {
        if (numberCups < 0) this.numberCups = 0;
        this.numberCups = numberCups;
    }

    /**
     * Sets amount of money guest has paid to enter event
     *
     * @param amount Amount paid
     */
    public void setEntryDonation(double amount) {
        if (amount < 0) entryDonation = 0;
        entryDonation = amount;
    }

    /**
     * Sets whether guest has paid for entry donation with cash or with check.
     *
     * @param paidCash Whether Guest has paid cash for entry
     */
    public void setPaidEntryDonationCash(boolean paidCash) {
        paidEntryDonationCash = paidCash;
    }

    /**
     * Sets whether guest has paid for auction items with cash or with check.
     *
     * @param paidCash Whether Guest has paid cash for auction items
     */
    public void setPaidAuctionItemsCash(boolean paidCash) {
        paidAuctionItemsCash = paidCash;
    }

    /**
     * Adds an item to the list of items owned by guest
     *
     * @param item
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Sets amount of money guest has paid for auction items
     * @param amountPaid Amount guest has paid
     */
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }


    /**
     * Sets notes about specific guest
     *
     * @param notes Additional notes to make
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Sets how much change is given back to this guest
     * @param changeGiven Amount
     */
    public void setChangeGiven(double changeGiven) {
        this.changeGiven = changeGiven;
    }

    /**
     * Sets whether everything with this guest's order is complete
     * @param orderComplete Order completed
     */
    public void setOrderComplete(boolean orderComplete) {
        this.orderComplete = orderComplete;
    }

    //
    //-------------
    //  Getters
    //-------------
    //

    public int getNumber() {
        return number;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public double getDonation() {
        return donation;
    }

    public double getEntryDonation() {
        return entryDonation;
    }

    public boolean isPaidEntryDonationCash() {
        return paidEntryDonationCash;
    }

    public int getNumberShirts() {
        return numberShirts;
    }

    public int getNumberCups() {
        return numberCups;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean isPaidAuctionItemsCash() {
        return paidAuctionItemsCash;
    }

    public double getChangeGiven() {
        return changeGiven;
    }

    public String getNotes() {
        return notes;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public boolean getOrderComplete() {
        return orderComplete;
    }

    /**
     * Sums up all items in inventory
     *
     * @return Sum To Pay
     */
    public double checkout() {
        double sum = 0;
        for (int i = 0; i < numberShirts; i++) {
            sum += 10;
        }
        for (int i = 0; i < numberShirts; i++) {
            if (numberShirts - i % 2 == 0) {
                sum += 12; //Price Of Two For 1 Cups
                i++;
            } else {
                sum += 7; //Price of Single Cup
            }
        }
        for (Item i : items) {
            sum += i.getPrice();
        }

        return sum;
    }

    public String getGuestID() {
        return ""+number;
    }

    public static Guest getGuestFromID(String ID) {
        for(Guest g:Controller.guests) {
            if(g.getGuestID().equals(ID)) {
                return g;
            }
        }
        return null;
    }

    public String toString() {
        if (lastName == null) return ""+number;
        return ""+number+" "+lastName;
    }

}
