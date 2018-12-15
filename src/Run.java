import calculation.EndOfMonth;
import factory.Factory;
import utilities.ReadPdfToText;
import utilities.Utilities;
import utilities.WriteReadData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {

    // == constance variables ==
    private ArrayList<EndOfMonth> endOfMonths = new ArrayList<>();
    private Factory factory;
    private Utilities utilities;
    private WriteReadData writeReadData;
    Scanner scanner = new Scanner(System.in);
    private boolean continueToAdd = true;

    private ReadPdfToText readPdfToText;


    // == constructor ==
    public Run() throws IOException {
        init();
    }

    // == init ==
    private void init() throws IOException {
        factory = new Factory();

        // if has a new statement
//        readPdfToText = new ReadPdfToText(new File("BankMobile_10-15.pdf"));

        createItems();
    }

    // == driver ==
    public static void main(String[] args) throws IOException {
        Run run = new Run();
        run.print();
//        run.clearDataInItemTxt();
//        run.generateItem();

        run.test();


    }

    public void test() throws IOException {
        String str = "12738";
        String str1 = "October 16, 2018 to November 15, 2018";

        boolean a = str1.matches("[a-zA-Z]+\\s\\d+[,]\\s\\d{4}\\s[a-zA-Z]+\\s[a-zA-Z]+\\s\\d+[,]\\s\\d{4}");
//        System.out.println(a);
    }


    // == public methods ==
    public void generateItem() throws IOException {

        int userContinueToAdd;

        while (continueToAdd) {
            addProcess();
            System.out.print("1-Continue to add : 0-Adding complete ");
            userContinueToAdd = scanner.nextInt();
            setContinueToAdd(userContinueToAdd(userContinueToAdd));
        }

    }


    public void print() {
        int count = 1;
        int countItem = 1;
        for (EndOfMonth endOfMonth: endOfMonths){

//            System.out.println(endOfMonth.theTopStore());
//            System.out.println("Sum expense: " + endOfMonth.sumExpense());
//            endOfMonth.totalEachTop();
//            System.out.println(endOfMonth.storeDensity());

//            System.out.println(
//                    "Sum expense: " +endOfMonth.getSumExpense()
//            );
//
//            for (String name:endOfMonth.getDensityPlaces().keySet()){
//                System.out.println(name + " : " + endOfMonth.getDensityPlaces().get(name));
//            }




         /*   System.out.println(
                    count + ". "
                    + endOfMonth.getAccountNumber()
                    + " : " + endOfMonth.getFromTo()
                    + " : " + endOfMonth.getItems().size()

            );

            for (Item item:endOfMonth.getItems()){

                System.out.println(
                        "   " +
                        countItem + ". "
                        + item.getReferenceNumber()
                        + " : " + item.getTransDate()
                        + " : " + item.getPostDate()
                        + " : " + item.getTypeMoneyFlow()
                        + " : " + item.getCategoryType()
                        + " : " + item.getDescriptionOrCredit()
                        + " : " + item.getAmount()
                );
                countItem++;
            }*/
        }

    }

    // == private methods ==
    private void createItems() throws IOException {
//        this.endOfMonths.add(factory.loadStatement());
        factory.loadStatement(new File("items.txt"));
    }

    private void addProcess() throws IOException {
       /* System.out.println("=====CREATE NEW ITEM=====\n");

        System.out.print("Name: ");
        String nameItem = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Type Money Flow: 1-EXPENSE : 2-INCOME ");
        TypeMoneyFlow typeMoneyFlow = utilities.buildTypeMoneyFlow(scanner.nextInt());

        System.out.print("Amount: ");
        double amount = utilities.buildAmount(scanner.nextInt());


        if (typeMoneyFlow == TypeMoneyFlow.EXPENSE) {
            System.out.print("Type Expense: 1-FIXED : 2-NONE_FIXED ");
            TypeExpense typeExpense = utilities.buildTypeExpense(scanner.nextInt());
            System.out.println(typeExpense.toString());


            items.add(factory.createItem(typeExpense, nameItem, amount, description));
        } else {
            items.add(factory.createItem(nameItem, amount, description));
        }*/
    }

    private boolean userContinueToAdd(int i) {
        return (i == 1) ? true : false;
    }

    private void setContinueToAdd(boolean continueToAdd) {
        this.continueToAdd = continueToAdd;
    }

}
