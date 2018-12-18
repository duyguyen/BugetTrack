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


        for (Store store : endOfMonth.getStores()) {
          /*  System.out.println(
                    store.getName() +
                            " : " + store.getDensity() +
                            " : " + store.getTotalSpending() +
                            " : " + store.isPayingDebt()
            );*/

           if (store.isHighSpending()){
//               System.out.println(store.getName() + " : " + store.getTotalSpending());
           }
        }

//        System.out.println(endOfMonth.getSumPayingDebt());
//        System.out.println(endOfMonth.getSumExpense());

    }

    // == private methods ==
    private void createItems() throws IOException {
        this.endOfMonth = factory.loadStatement(new File("items.txt"));
    }
}
