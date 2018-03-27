package sample;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataLoader {
    static ArrayList<String> contents = new ArrayList<String>();

    public static void loadData() throws FileNotFoundException{
        String csvFile = "C:\\Users\\Vorte\\IdeaProjects\\CheckoutEWB\\src\\sample\\data.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            boolean firstThrough = false;

            while ((line = br.readLine()) != null) {
                if (!firstThrough) {firstThrough = true; continue;}
                String[] lineArray = line.split(cvsSplitBy);
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
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
