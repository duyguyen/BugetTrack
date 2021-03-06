package calculation;

import funds.FundBase;
import item.Item;
import stores.Store;

import java.util.ArrayList;
import java.util.Collections;

public class EndOfMonth {

    // == constants ==
    private String accountNumber;
    private String period;
    private ArrayList<Store> stores;
    private Statistic statistic = new Statistic();
    private ArrayList<Item> items;
    private ArrayList<FundBase> funds = new ArrayList<>();

    private double sumPayingDebt;
    private double sumExpense;

    // == constructor ==
    public EndOfMonth(ArrayList<Item> items, String period, String accountNumber) {
        this.period = period;
        this.items = items;
        this.accountNumber = accountNumber;
        createStores(); // create stores after having items
        Collections.sort(stores);
        sumTotalSpending(); // sum total spending of paying debt or spending
        measureVaData();

    }

    // == private methods ==
    public void sumTotalSpending() {
        for (Store store : stores) {
            if (store.isPayingDebt()) {
                sumPayingDebt += store.getTotalSpending();
            } else {
                sumExpense += store.getTotalSpending();
            }
        }
    }

    // == public methods ==
    public void measureVaData() {
        statistic.theTopStore(stores); // figure out the mose spending store
        statistic.percentStoreOnAllStores(stores, sumExpense); // calculate the percent spending of each store on total spending
        this.funds = statistic.buildFunds(sumPayingDebt); // create funds for each month
    }

    public void createStores() {
        this.stores = statistic.createStores(items);
    }

    public ArrayList<FundBase> getFunds() {
        return funds;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPeriod() {
        return period;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Store> getStores() {
        return stores;
    }

    public double getSumExpense() {
        return Math.round(sumExpense * 100.0) / 100.0;
    }

    public double getSumPayingDebt() {
        return Math.round(sumPayingDebt * 100.0) / 100.0;
    }
}
