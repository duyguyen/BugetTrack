import calculation.EndOfMonth;
import factory.Factory;
import stores.Store;
import utilities.ReadPdfToText;

import java.io.File;
import java.io.IOException;

public class Run {

    // == constance variables ==
    private Factory factory;
    private ReadPdfToText readPdfToText;
    private EndOfMonth endOfMonth;


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
    }

    // == public methods ==
    public void print() {
//        printOut();

    }

    // == private methods ==
    private void printOut(){
        System.out.println("*Period: ".toUpperCase() + endOfMonth.getPeriod());
        System.out.println("*Account numbers: ".toUpperCase() + endOfMonth.getAccountNumber());
        System.out.println("---------------------------------------------\n");

        System.out.println("*Total internet payment: ".toUpperCase() + endOfMonth.getSumPayingDebt() + " $");
        System.out.println("*Total spending on things: ".toUpperCase() + endOfMonth.getSumExpense() + " $\n");


        for (Store store : endOfMonth.getStores()) {
            if (store.isTheTopStore()) {
                System.out.println("\n*The top store by density: ".toUpperCase() + store.getName().toLowerCase() + " : " + store.getTotalSpending() + " (" + store.getDensity() +")");

            }
            if (store.isHighSpending()) {
                System.out.println("*The high spending with once density: ".toUpperCase() + store.getName().toLowerCase() + " : " + store.getTotalSpending());
            }
        }
    }

    private void createItems() throws IOException {
        this.endOfMonth = factory.loadStatement(new File("items.txt"));
    }
}
