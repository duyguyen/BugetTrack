package base;

import item.TypeExpense;
import item.TypeMoneyFlow;

public abstract class Base {

    // == constance variables ==
    private TypeExpense typeExpense;
    private StringBuilder description;
    private StringBuilder date;
    private double amount;
    private StringBuilder nameItem;
    private TypeMoneyFlow typeMoneyFlow;

    // == constructor ==
    public Base(TypeMoneyFlow typeMoneyFlow, TypeExpense typeExpense, String nameItem, double amount){
        this.typeMoneyFlow = typeMoneyFlow;
        this.typeExpense = typeExpense;
        this.nameItem = new StringBuilder(nameItem);
        this.amount = amount;
    }

    // == public methods ==

    public TypeMoneyFlow getTypeMoneyFlow() {
        return typeMoneyFlow;
    }

    public TypeExpense getTypeExpense() {
        return typeExpense;
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
}
