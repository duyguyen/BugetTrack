package wrting_read_data;

import item.Base;
import item.Expense;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import utilities.Utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteReadData {

    // == constance variables ==
    private ArrayList<Base> items;
    private Utilities utilities;

    // == constructor ==
    public WriteReadData(ArrayList<Base> items, Utilities utilities) {
        this.items = items;
        this.utilities = utilities;
    }

    // == public methods ==


    public void printItem() throws IOException {
        try {
            PrintWriter writer = new PrintWriter("items.txt", "UTF-8");
            int count = 1;

            String line;
            String typeExpense = "NONE";

            for (Base item : items) {

                if (item.getTypeMoneyFlow().isExpense()) {
                    Expense convert = (Expense) item;
                    typeExpense = convert.getTypeExpense().toString();
                }

                line = count + ". " ;

                writer.println(line);
                count++;
                typeExpense = "NONE";
            }


            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            System.out.println("items.txt has been created.");
        }
    }

    public void appendToItems(Base item) throws IOException {
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
