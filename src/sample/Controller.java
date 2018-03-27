package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Controller {

    public static ObservableList<Guest> guests = FXCollections.observableArrayList();
    public static ObservableList<Item> items = FXCollections.observableArrayList();

    public Guest selectedGuest;
    public Item selectedItem;

    public Controller() {
    }



    //
    // Menu Bar
    //

    @FXML
    Button saveData;

    @FXML
    Button loadData;

    @FXML
    Button addItem;

    @FXML
    Button addGuest;

    @FXML
    Button removeGuest;

    @FXML
    Button removeItem;


    //
    // Items
    //

    @FXML
    TextField itemName;

    @FXML
    TextField itemPrice;

    @FXML
    ComboBox<Item> itemSelect;

    @FXML
    TextArea itemNotes;

    @FXML
    TextField itemOwner;

    @FXML
    ComboBox<Guest> ownerSelect;

    //
    // Guests
    //

    @FXML
    TextField lastName;

    @FXML
    TextField phoneNumber;

    @FXML
    TextField firstName;

    @FXML
    TextField email;

    @FXML
    TextField tShirt;

    @FXML
    TextField glasses;

    @FXML
    TextField guestDonation;

    @FXML
    ComboBox<Guest> guestSelect;

    @FXML
    TextField changeGiven;

    @FXML
    TextField entryDonation;

    @FXML
    TextArea guestNotes;

    @FXML
    TextField amountPaid;

    @FXML
    CheckBox orderComplete;

    @FXML
    RadioButton auctionPaidByCheck;

    @FXML
    RadioButton entryPaidByCheck;

    @FXML
    public void saveData() {
        // TODO
    }

    @FXML
    public void loadData() {
        // TODO
    }

    @FXML
    public void newGuest() {
        Guest g = new Guest();
        guests.add(g);
        guestSelect.setItems(guests);
        ownerSelect.setItems(guests);
    }

    @FXML
    public void newItem() {
        // TODO
    }

    @FXML
    public void removeGuest() {
        // TODO
    }

    public void removeItem() {
        // TODO
    }

    @FXML
    public void updateGuest() {
        saveCurrentGuestData(selectedGuest);
        guestSelect.setItems(guests);
        ownerSelect.setItems(guests);
        updateGuestTextField(selectedGuest);
    }

    @FXML
    public void updateItem() {
        selectedItem.setOwner(guestSelect.getValue());
        selectedItem.setName(itemName.getText());
        selectedItem.setNotes(itemNotes.getText());

        try {
            double d = Double.parseDouble(guestDonation.getText());
            selectedItem.setPrice(d);
        } catch (Exception ignored) {}
    }


    @FXML
    public void selectGuestFromList() {
        Guest g = guestSelect.getValue();
        selectedGuest = g;
        updateGuestTextField(g);
    }

    @FXML
    private void saveCurrentGuestData(Guest g) {
        //Direct String Inputs
        g.setLastName(lastName.getText());
        g.setFirstName(firstName.getText());
        g.setPhoneNumber(phoneNumber.getText());
        g.setEmail(email.getText());
        g.setNotes(guestNotes.getText());

        //Numerial Inputs
        try {
            int i = Integer.parseInt(tShirt.getText());
            g.setNumberShirts(i);
        } catch (Exception ignored) {}

        try {
            int i = Integer.parseInt(glasses.getText());
            g.setNumberCups(i);
        } catch (Exception ignored) {}

        try {
            double d = Double.parseDouble(guestDonation.getText());
            g.setDonation(d);
        } catch (Exception ignored) {}

        try {
            double d = Double.parseDouble(changeGiven.getText());
            g.setChangeGiven(d);
        } catch (Exception ignored) {}

        try {
            double d = Double.parseDouble(entryDonation.getText());
            g.setEntryDonation(d);
        } catch (Exception ignored) {}

        try {
            double d = Double.parseDouble(amountPaid.getText());
            g.setAmountPaid(d);
        } catch (Exception ignored) {}


        //Boolean Inputs
        g.setOrderComplete(orderComplete.isSelected());
        g.setPaidAuctionItemsCash(!auctionPaidByCheck.isSelected());
        g.setPaidEntryDonationCash(!entryPaidByCheck.isSelected());
    }

    @FXML
    private void updateGuestTextField(Guest g) {
        if (g == null) return;
        lastName.setText(g.getLastName());
        firstName.setText(g.getFirstName());
        phoneNumber.setText(g.getPhoneNumber());
        email.setText(g.getEmail());
        tShirt.setText(""+g.getNumberShirts());
        glasses.setText(""+g.getNumberCups());
        guestDonation.setText(""+g.getDonation());
        changeGiven.setText(""+g.getChangeGiven());
        entryDonation.setText(""+g.getEntryDonation());
        guestNotes.setText(g.getNotes());
        amountPaid.setText(""+g.getAmountPaid());
        orderComplete.setSelected(g.getOrderComplete());
        auctionPaidByCheck.setSelected(!g.isPaidAuctionItemsCash());
        entryPaidByCheck.setSelected(!g.isPaidEntryDonationCash());
    }

}
