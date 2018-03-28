package sample;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataManager {
    private static String filePath = "src\\sample\\data.csv";


    public static void loadData() throws FileNotFoundException{
        String csvFile = filePath;
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            boolean firstThrough = false;
            int iter = 1;
            while ((line = br.readLine()) != null) {
                if (!firstThrough) {firstThrough = true; continue;}
                String[] lineArray = line.split(cvsSplitBy);
                if (lineArray.length == 0 || lineArray.length == 1) break;
                Guest g = new Guest(true);
                try {
                    g.setNumber(Integer.parseInt(lineArray[0]));
                } catch (Exception ignored) {}
                g.setLastName(lineArray[1]);
                g.setFirstName(lineArray[2]);
                g.setPhoneNumber(lineArray[3]);
                g.setEmail(lineArray[4]);
                g.setNotes(lineArray[5]);
                try {
                    g.setEntryDonation(Double.parseDouble(lineArray[6]));
                } catch (Exception ignored) {}

                try {
                    g.setPaidEntryDonationCash(Boolean.parseBoolean(lineArray[7].toLowerCase()));
                } catch (Exception ignored) {}

                try {
                    g.setNumberShirts(Integer.parseInt(lineArray[8]));
                } catch (Exception ignored) {}

                try {
                    g.setNumberCups(Integer.parseInt(lineArray[9]));
                } catch (Exception ignored) {}

                try {
                    g.setDonation(Double.parseDouble(lineArray[10]));
                } catch (Exception ignored) {}

                try {
                    g.setPaidAuctionItemsCash(Boolean.parseBoolean(lineArray[11].toLowerCase()));
                } catch (Exception ignored) {}

                try {
                    g.setAmountPaid(Double.parseDouble(lineArray[12]));
                } catch (Exception ignored) {}

                try {
                    g.setChangeGiven(Double.parseDouble(lineArray[13]));
                } catch (Exception ignored) {}

                try {
                    g.setOrderComplete(Boolean.parseBoolean(lineArray[14].toLowerCase()));
                } catch (Exception ignored) {}

                Controller.guests.add(g);

                if (lineArray[15].equals("-")) continue;

                Item i = new Item(true);

                try {
                    i.setNumber(Integer.parseInt(lineArray[15]));
                } catch (Exception ignored) {}

                i.setName(lineArray[16]);
                try {
                    i.setPrice(Double.parseDouble(lineArray[17]));
                } catch (Exception ignored) {}
                i.setNotes(lineArray[18]);

                int num = -1;
                try {
                    num = Integer.parseInt(lineArray[19]);
                } catch (Exception ignored) {}

                Controller.ownerToAdd.add(num);
                Controller.itemToAddOwnerTo.add(i);

                Controller.items.add(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveData() {
        File f = getFile();
        String fileContents = writeHeader();
        //Gets Largest Size Of Total Collections for number of rows in table
        int maxSize = Controller.guests.size() > Controller.items.size() ? Controller.guests.size() : Controller.items.size();
        String[][] row = new String[maxSize][20]; //Each Row Will Have 20 Columns For Each object
        for (int i = 0; i < Controller.guests.size(); i++) {
            Guest g = Controller.guests.get(i);
            row[i][0] = g.getGuestID();
            row[i][1] = g.getLastName();
            row[i][2] = g.getFirstName();
            row[i][3] = g.getPhoneNumber();
            row[i][4] = g.getEmail();
            row[i][5] = g.getNotes();
            row[i][6] = ""+g.getEntryDonation();
            row[i][7] = ""+g.isPaidEntryDonationCash();
            row[i][8] = ""+g.getNumberShirts();
            row[i][9] = ""+g.getNumberCups();
            row[i][10] = ""+g.getDonation();
            row[i][11] = ""+g.isPaidAuctionItemsCash();
            row[i][12] = ""+g.getAmountPaid();
            row[i][13] = ""+g.getChangeGiven();
            row[i][14] = ""+g.getOrderComplete();
        }
        for (int i = 0; i < Controller.items.size(); i++) {
            Item item = Controller.items.get(i);
            row[i][15] = ""+item.getNumber();
            row[i][16] = ""+item.getName();
            row[i][17] = ""+item.getPrice();
            row[i][18] = ""+item.getNotes();
            row[i][19] = ""+item.getOwner().getNumber();
        }

        StringBuilder b = new StringBuilder(fileContents);
        for (int i = 0; i < maxSize; i++) {
            for (int k = 0; k < 20; k++) {
                if (row[i][k]==null) b.append("-");
                else b.append(row[i][k]);
                if (k != 19) b.append(",");
            }
            b.append("\n");
        }
        //System.out.println(b.toString());

        List<String> lines = Arrays.asList(b.toString());
        Path file = Paths.get(filePath);
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (Exception ignored){}

    }

    private static String writeHeader() {
        StringBuilder b = new StringBuilder();
        b.append("number");
        b.append(",");
        b.append("lastName");
        b.append(",");
        b.append("firstName");
        b.append(",");
        b.append("phoneNumber");
        b.append(",");
        b.append("email");
        b.append(",");
        b.append("notes");
        b.append(",");
        b.append("entryDonation");
        b.append(",");
        b.append("paidEntryDonationCash");
        b.append(",");
        b.append("numberShirts");
        b.append(",");
        b.append("numberCups");
        b.append(",");
        b.append("donation");
        b.append(",");
        b.append("paidAuctionItemsCash");
        b.append(",");
        b.append("amountPaid");
        b.append(",");
        b.append("changeGiven");
        b.append(",");
        b.append("orderComplete");
        b.append(",");
        b.append("itemNumber");
        b.append(",");
        b.append("itemName");
        b.append(",");
        b.append("itemPrice");
        b.append(",");
        b.append("itemNotes");
        b.append(",");
        b.append("itemOwnerNumber");
        b.append("\n");

        return b.toString();
    }

    private static File getFile() {
        File f = new File(filePath);
        return f;
    }

}
