import calculation.EndOfMonth;
import factory.Factory;
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

        endOfMonth.measureVaData();

    /*    System.out.println(
                endOfMonth.getAccountNumber()
                        + " : " + endOfMonth.getFromTo().toUpperCase()
                        + " : " + endOfMonth.getItems().size() + "\n"
        );

        System.out.println(
                "Top store: ".toUpperCase() + endOfMonth.theTopStore() + "\n"+
                "Sum all spending: ".toUpperCase() + endOfMonth.sumExpense() + "\n"

//                "Stores density: " + endOfMonth.storeDensity() + "\n"

        );*/


//        System.out.println("Total each top: ".toUpperCase());
//        endOfMonth.totalEachTop();


    }

    // == private methods ==
    private void createItems() throws IOException {
        this.endOfMonth = factory.loadStatement(new File("items.txt"));
    }
}
