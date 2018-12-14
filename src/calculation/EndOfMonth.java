package calculation;

import item.Base;
import utilities.Utilities;

import java.util.ArrayList;

public class EndOfMonth {

    // == constants ==
    private String accountNumber;
    private String fromTo;
    private ArrayList<Base> items;

    // == constructor ==
    public EndOfMonth(ArrayList<Base> items, String fromTo, String accountNumber) {
        this.fromTo = fromTo;
        this.items = items;
        this.accountNumber = accountNumber;

    }

    public EndOfMonth() {
        this(null, null, null);
    }

    // == public methods ==

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    public void setItems(ArrayList<Base> items) {
        this.items = items;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getFromTo() {
        return fromTo;
    }

    public ArrayList<Base> getItems() {
        return items;
    }

    // == private methods ==

}
