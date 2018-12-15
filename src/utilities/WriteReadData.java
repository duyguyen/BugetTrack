package utilities;

import calculation.EndOfMonth;
import item.Item;
import item.Expense;

import java.io.*;

public class WriteReadData {

    // == constance variables ==


    // == constructor ==
    public WriteReadData() {
    }

    // == public methods ==
    public void printItem(EndOfMonth endOfMonths) throws IOException {
        try {
            PrintWriter writer = new PrintWriter("items.txt", "UTF-8");
            int count = 1;

            String itemDisplay;
            String fromTo;
            String accountNumbers;

//            for (EndOfMonth endOfMonth : endOfMonths) {
                fromTo = endOfMonths.getFromTo();
                accountNumbers = endOfMonths.getAccountNumber();

                writer.println(fromTo);
                writer.println(accountNumbers + "\n");
                for (Item item : endOfMonths.getItems()) {
                    itemDisplay = item.getReferenceNumber()
                            + " :: " + item.getTransDate()
                            + " :: " + item.getPostDate()
                            + " :: " + item.getTypeMoneyFlow()
                            + " :: " + item.getCategoryType()
                            + " :: " + item.getDescriptionOrCredit()
                            + " :: " + item.getAmount()
                            + "\n";
                    writer.println(itemDisplay);
                }
                System.out.println("\n");
//            }


            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            System.out.println("items.txt has been created.");
        }
    }

    public void appendToItems(Item item) throws IOException {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("items.txt", true)));

            String typeExpense = "NONE";

            if (item.getTypeMoneyFlow().isExpense()) {
                Expense convert = (Expense) item;
                typeExpense = convert.getTypeExpense().toString();
            }

            String line = "";
            out.println(line);
            out.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        } finally {
            System.out.println("Add new item has been Completed.");
        }
    }

    public void clearItems() throws IOException {
        try {
            PrintWriter writer = new PrintWriter(new File("items.txt"));
            writer.print("");
            writer.close();
            System.out.println("Data has been clear.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    // == private methods ==
}
