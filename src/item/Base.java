package item;

import utilities.Utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Base {

    // == constance variables ==
    private String referenceNumber;
    private String descriptionOrCredit;
    private String transDate;
    private String postDate;
    private double amount;
    private TypeMoneyFlow typeMoneyFlow;
    private CategoryType categoryType;

    // == constructor ==
    public Base(String referenceNumber, String descriptionOrCredit, String transDate, String postDate, double amount, TypeMoneyFlow typeMoneyFlow) {
        this.referenceNumber = referenceNumber;
        this.descriptionOrCredit = descriptionOrCredit;
        this.transDate = transDate;
        this.postDate = postDate;
        this.amount = amount;
        this.typeMoneyFlow = typeMoneyFlow;
    }

    // == public methods ==
    public String getReferenceNumber() {
        return referenceNumber;
    }

    public String getDescriptionOrCredit() {
        return descriptionOrCredit;
    }

    public String getTransDate() {
        return transDate;
    }

    public String getPostDate() {
        return postDate;
    }

    public double getAmount() {
        return amount;
    }

    public TypeMoneyFlow getTypeMoneyFlow() {
        return typeMoneyFlow;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }
}
