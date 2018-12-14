import calculation.EndOfMonth;
import calculation.Statistic;
import factory.Factory;
import item.Base;
import utilities.Utilities;
import utilities.script_files.DoubleGeneric;
import utilities.script_files.IntegerGeneric;
import wrting_read_data.WriteReadData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {

    // == constance variables ==
    private ArrayList<EndOfMonth> endOfMonths = new ArrayList<>();
    private Factory factory;
    private Statistic statistic;
    private WriteReadData writeReadData;
    private Utilities utilities;
    Scanner scanner = new Scanner(System.in);
    private boolean continueToAdd = true;


    // == constructor ==
    public Run() throws IOException {
        init();
    }

    // == init ==
    private void init() throws IOException {
        utilities = new Utilities(new IntegerGeneric(), new DoubleGeneric());
        factory = new Factory(writeReadData, utilities);

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
            System.out.println(
                    count + ". "
                    + endOfMonth.getAccountNumber()
                    + " : " + endOfMonth.getFromTo()
                    + " : " + endOfMonth.getItems().size()

            );

            for (Base item:endOfMonth.getItems()){

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
            }
        }

    }

    // == private methods ==
    private void createItems() throws IOException {
        this.endOfMonths.add(factory.loadStatement());
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

    private void clearDataInItemTxt() throws IOException {
        writeReadData.clearItems();
    }

}
