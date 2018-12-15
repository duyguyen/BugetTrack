package factory;

import calculation.EndOfMonth;
import category.LifeStyleChoices;
import category.LongSaving;
import category.NecessityFund;
import category.SpecificFund;
import item.Item;
import item.CategoryType;
import item.Expense;
import item.Income;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import utilities.Utilities;
import utilities.WriteReadData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Factory {

    // == constants ==
    private Utilities utilities;
    private WriteReadData writeReadData;

    // == constructor ==
    public Factory(Utilities utilities, WriteReadData writeReadData) {
        this.utilities = utilities;
        this.writeReadData = writeReadData;
    }

    // == public methods ==
    public EndOfMonth loadStatement() throws IOException {
        ArrayList<Item> items = new ArrayList<>();
        String accountNumber = "";
        String fromTo = "";
        EndOfMonth endOfMonth = new EndOfMonth();

        try {
            PDDocument document = PDDocument.load(new File("BankMobile_11-15.pdf"));// here file1.pdf is the name of pdf file which we want to read....
            document.getClass();
            if (!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper Tstripper = new PDFTextStripper();
                String str = Tstripper.getText(document);

                Scanner scn;
                scn = new Scanner(str);
                String line;
                int count = 1;
                while (scn.hasNextLine()) {
                    line = scn.nextLine();

                    String[] splitLine = line.split(" ");

                    if (accountNumber == ""){
                        if (utilities.defineAccountNumberString(line)) {
                            accountNumber = buildAccountNumber(splitLine);
                        }
                    }

                    if (fromTo == ""){
                        if (utilities.defineFromTo(line)){
                            fromTo = line;
                        }
                    }

                    if (splitLine.length > 0) {
                        String referenceNumber = splitLine[0].trim();

                        if (utilities.defineReferenceNumberSpending(referenceNumber) || (utilities.defineReferenceNumberReward(referenceNumber))) {

                            String des = buildDescription(splitLine).toString();
                            double amount = 0.0;
                            if (utilities.defineAmount(splitLine[splitLine.length - 1])){
                                amount = utilities.convertStringToDouble(splitLine[splitLine.length - 1]);
                            }
                            Expense expense = new Expense(splitLine[0],des, splitLine[1], splitLine[2], amount);
                            items.add(expense);
                        }
                    }

                     endOfMonth.setAccountNumber(accountNumber);
                     endOfMonth.setFromTo(fromTo);
                     endOfMonth.setItems(items);

                }

                // calculate values
//                endOfMonth.calculateValues();
            }
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n***Bank statement has been loaded.***\n");
        }

        // write data to items.txt
//        writeReadData.printItem(endOfMonth);

        return endOfMonth;
    }

    public Item createExpense(String referenceNumber, String descriptionOrCredit, String transDate, String postDate, double amount) throws IOException {
        Expense expense = new Expense(referenceNumber, descriptionOrCredit, transDate, postDate, amount);
//        writeReadData.appendToItems(expense);
        return expense;
    }

    public Item createIncome(String referenceNumber, String descriptionOrCredit, String transDate, String postDate, double amount) throws IOException {
        Income income = new Income(referenceNumber, descriptionOrCredit, transDate, postDate, amount);
//        writeReadData.appendToItems(income);
        return income;
    }

    public SpecificFund createCategories(CategoryType categoryType) {
        if (categoryType == CategoryType.NECESSITY) {
            return new NecessityFund();
        } else if (categoryType == CategoryType.LONG_TERNS_SAVING) {
            return new LongSaving();
        } else if (categoryType == CategoryType.LIFESTYLE_CHOICE) {
            return new LifeStyleChoices();
        }

        return new NecessityFund();
    }

    // == private methods ==
    private String buildAccountNumber(String[] strings){
        StringBuilder accountNumber = new StringBuilder();
        for (String string:strings){
            if (utilities.defineAccountNumber(string)){
                accountNumber.append(string + " ");
            }
        }
        return accountNumber.toString();
    }


    private StringBuilder buildDescription(String[] strings) {
        StringBuilder des = new StringBuilder();
        for (int i = 3; i < strings.length - 1; i++) {
            des.append(strings[i] + " ");
        }

        return des;
    }

}
