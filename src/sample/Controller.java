package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Controller {

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
    ChoiceBox itemSelect;

    @FXML
    TextArea itemNotes;

    @FXML
    TextField itemOwner;

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
    ChoiceBox<Guest> guestSelect;

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
    public void updateGuest() {
        lastName.setText("Last Name");
        phoneNumber.setText("Phone #");
        firstName.setText("First Name");
        email.setText("Email");
        tShirt.setText("Shirt");
        glasses.setText("glasses");
        guestDonation.setText("Donation");
        changeGiven.setText("Change");
        entryDonation.setText("Entry Donation");
        guestNotes.setText("Guest Notes");
        amountPaid.setText("Amount paid");
        orderComplete.setSelected(true);
        auctionPaidByCheck.setSelected(true);
        entryPaidByCheck.setSelected(true);
    }

    @FXML
    public void updateItem() {
        itemName.setText("Item Name");
        itemPrice.setText("Item Price");
        itemNotes.setText("Item Notes");
        itemOwner.setText("Item Owner");
    }



}
