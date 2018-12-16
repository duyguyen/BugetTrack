package calculation;

import item.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class EndOfMonth {

    // == constants ==
    private String accountNumber;
    private String fromTo;
    private Statistic statistic = new Statistic();
    private ArrayList<Item> items;

    // == constructor ==
    public EndOfMonth(ArrayList<Item> items, String fromTo, String accountNumber) {
        this.fromTo = fromTo;
        this.items = items;
        this.accountNumber = accountNumber;

    }

    public EndOfMonth() {
        this(null, null, null);
    }
    // == private methods ==


    // == public methods ==
    public void measureVaData(){
        statistic.calculate(items);
    }

    public void totalEachTop(){
        statistic.totalOfTopStore(items, theTopStore());
    }

    public double sumExpense(){
        return statistic.sumExpense(items);
    }

    public StringBuilder theTopStore() { // the top stores that visiting
        return statistic.theTopStore(statistic.desDensity(items));
    }

    public StringBuilder storeDensity() {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<String, Integer> stores = statistic.desDensity(items);
        for (String name : stores.keySet()) {
            stringBuilder.append(name + " : " + stores.get(name) + "\n");
        }

        return stringBuilder;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getFromTo() {
        return fromTo;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

}
