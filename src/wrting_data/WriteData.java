package wrting_data;

import item.Base;
import item.Expense;
import item.TypeExpense;
import item.TypeMoneyFlow;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class WriteData {

    // == constance variables ==
    private ArrayList<Base> items;

    // == constructor ==
    public WriteData(ArrayList<Base> items) {
        this.items = items;
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

                line = count + ". " + item.getDate() + " :: " + item.getNameItem() + " :: " +
                        item.getTypeMoneyFlow() + " :: " +
                        typeExpense + " :: " +
                        item.getAmount() + " :: " +
                        item.getDescription();

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

            if (item.getTypeMoneyFlow().isExpense()){
                Expense convert = (Expense)item;
                typeExpense = convert.getTypeExpense().toString();
            }

            String line = item.getDate()+ " :: " + item.getNameItem() + " :: " + item.getTypeMoneyFlow() + " :: " +
                    "TypeExpense"+ " :: " + item.getAmount() + " :: " + item.getDescription();
            out.println(line);
            out.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        } finally {
            System.out.println("Add new item has been Completed.");
        }
    }

    public  void clearItems() throws IOException{
        try {
            PrintWriter writer = new PrintWriter(new File("items.txt"));
            writer.print("");
            writer.close();
        }catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
}
