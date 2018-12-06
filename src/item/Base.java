package item;

import item.TypeExpense;
import item.TypeMoneyFlow;

public abstract class Base {

    // == constance variables ==

    private StringBuilder description;
    private StringBuilder date;
    private double amount;
    private StringBuilder nameItem;
    private TypeMoneyFlow typeMoneyFlow;
    private CategoryType categoryType;

    // == constructor ==
    public Base(TypeMoneyFlow typeMoneyFlow, String nameItem, double amount){
        this.typeMoneyFlow = typeMoneyFlow;
        this.nameItem = new StringBuilder(nameItem);
        this.amount = amount;
    }

    // == public methods ==

    public TypeMoneyFlow getTypeMoneyFlow() {
        return typeMoneyFlow;
    }

    public StringBuilder getDescription() {
        return description;
    }

    public StringBuilder getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public StringBuilder getNameItem() {
        return nameItem;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }
}
