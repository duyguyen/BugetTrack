import calculation.Statistic;
import factory.Factory;
import item.Base;
import item.TypeExpense;
import item.TypeMoneyFlow;
import utilities.Utilities;
import utilities.script_files.DoubleGeneric;
import utilities.script_files.IntegerGeneric;
import wrting_data.WriteData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {

    // == constance variables ==
    private ArrayList<Base> items = new ArrayList<>();
    private Factory factory;
    private Statistic statistic;
    private WriteData writeData;
    private Utilities utilities;
    Scanner scanner = new Scanner(System.in);


    // == constructor ==
    public Run() throws IOException{
        init();
    }

    // == init ==
    private void init() throws IOException{
        utilities = new Utilities(new IntegerGeneric(), new DoubleGeneric());
        writeData = new WriteData(items);
        factory = new Factory(writeData);
        generateItem();


        statistic = new Statistic(items);


    }

    // == driver ==
    public static void main(String[] args) throws IOException{
        Run run = new Run();
        run.print();

    }

    // == public methods ==
    public void generateItem() throws IOException{

        // clear item.txt
//        writeData.clearItems();

//        System.out.println("=====CREATE NEW ITEM=====\n");
//
//        System.out.print("Name: ");
//        String nameItem = scanner.nextLine();
//
//        System.out.print("Type Money Flow: 1-EXPENSE : 2-INCOME ");
//        TypeMoneyFlow typeMoneyFlow = utilities.buildTypeMoneyFlow(scanner.nextInt());
//
//        System.out.print("Amount: ");
//        double amount = utilities.buildAmount(scanner.nextInt());
//
//        if (typeMoneyFlow == TypeMoneyFlow.EXPENSE){
//            System.out.print("Type Expense: 1-FIXED : 2-NONE_FIXED ");
//            TypeExpense typeExpense = utilities.buildTypeExpense(scanner.nextInt());
//            System.out.println(typeExpense.toString());
//
//            items.add(factory.createItem(typeExpense,nameItem, amount));
//        }
//
//        items.add(factory.createItem(nameItem, amount));


    }


    public void print() {
        int count = 1;


//        while(addItem){
//            System.out.println("Add item");
//        }

        for (Base item : items) {
            System.out.println(count + ". Name: " + item.getNameItem() + " ; Amount: " + item.getAmount());
            count++;
        }





    }

    // == private methods ==


}
