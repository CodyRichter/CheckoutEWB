package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


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
    MenuItem saveData;

    @FXML
    MenuItem loadData;

    @FXML
    MenuItem about;

    @FXML
    MenuItem documentation;

    @FXML
    Button addItem;

    @FXML
    TextField removeItemNum;

    @FXML
    TextField removeGuestNum;

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
    Label totalDue;

    @FXML
    TextField guestDonation;

    @FXML
    TextArea guestItemList;

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
    }

    @FXML
    public void newItem() {
        Item i = new Item();
        items.add(i);
        itemSelect.setItems(items);
    }

    @FXML
    public void removeGuest() {
        if (removeGuestNum.getText() == null || removeGuestNum.getText() == "") return;
        Guest g = null;
        try {
            int guestNumber = Integer.parseInt(removeGuestNum.getText());
            g = Guest.getGuestFromID(""+guestNumber);
        } catch (Exception ignored) {}
        if (g == null) return;
        removeGuestNum.clear();
        guests.remove(g);
        if (selectedGuest == g) selectedGuest = null;
            updateGuest();
            guestSelect.setItems(guests);

    }

    public void removeItem() {
        if (removeItemNum.getText() == null || removeItemNum.getText() == "") return;
        Item i = null;
        try {
            int itemNumber = Integer.parseInt(removeItemNum.getText());
            i = Item.getItemFromID(""+itemNumber);
        } catch (Exception ignored) {}
        if (i == null) return;
        items.remove(i);
        removeItemNum.clear();
        if (selectedItem == i) selectedItem = null;
        updateItem();
        itemSelect.setItems(items);
    }

    @FXML
    public void updateGuest() {
        if (selectedGuest == null) {clearGuestData(); return;}
        saveCurrentGuestData(selectedGuest);
        guestSelect.setItems(guests);
        updateGuestTextField(selectedGuest);
    }

    public void clearGuestData() {
        lastName.setText("");
        firstName.setText("");
        phoneNumber.setText("");
        email.setText("");
        tShirt.setText("");
        glasses.setText("");
        guestDonation.setText("");
        changeGiven.setText("");
        entryDonation.setText("");
        guestNotes.setText("");
        amountPaid.setText("");
        orderComplete.setSelected(false);
        auctionPaidByCheck.setSelected(false);
        entryPaidByCheck.setSelected(false);
        guestItemList.setText("");
        totalDue.setFont(Font.font("Verdana", FontWeight.BOLD,12));
        totalDue.setText("[X]");
    }

    public void clearItemData() {
        itemName.setText("");
        itemPrice.setText("");
        itemOwner.setText("");
        itemNotes.setText("");
    }

    @FXML
    public void updateItem() {
        if (selectedItem==null) {clearItemData(); return;}
        saveCurrentItemData(selectedItem);
        itemSelect.setItems(items);
        updateItemTextField(selectedItem);
    }

    @FXML
    public void saveCurrentItemData(Item i) {
        i.setName(itemName.getText());
        i.setNotes(itemNotes.getText());

        try {
            int ownerNumber = Integer.parseInt(itemOwner.getText());
            Guest g = Guest.getGuestFromID(""+ownerNumber);
            i.setOwner(g);
        } catch (Exception ignored) {}

        try {
            double d = Double.parseDouble(itemPrice.getText());
            i.setPrice(d);
        } catch (Exception ignored) {}
    }

    @FXML
    public void selectItemFromList() {
        Item i = itemSelect.getValue();
        selectedItem = i;
        updateItemTextField(i);
    }

    @FXML
    public void updateItemTextField(Item i) {
        if (i == null) {clearItemData(); return;}
        itemName.setText(i.getName());
        itemPrice.setText(""+i.getPrice());
        if (selectedItem.getOwner() != null) itemOwner.setText(""+i.getOwner().getNumber());
        else itemOwner.setText("");
        itemNotes.setText(i.getNotes());
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
        if (g == null) {clearGuestData(); return;}
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

        updateGuestItems(g);
        totalDue.setFont(Font.font("Verdana", FontWeight.BOLD,12));
        totalDue.setText(""+g.checkout());
    }

    private void updateGuestItems(Guest g) {
        String owned = "";
        g.getItems().clear();
        for (Item i : items) {
            if (i.getOwner() == g) {
            owned += "[$"+ i.getPrice()+"]  #["+ i.getNumber()+"]    "+i.getName() + "\n";
            g.getItems().add(i);
            }
        }
        guestItemList.setText(owned);
    }

}
