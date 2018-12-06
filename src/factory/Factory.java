package factory;

import base.Base;
import item.Expense;
import item.Income;
import item.TypeExpense;
import item.TypeMoneyFlow;

public class Factory {

    // == public methods ==
    public Base createItem(TypeExpense typeExpense, String nameItem, double amount, TypeMoneyFlow typeMoneyFlow) {

//        if (typeMoneyFlow.isExpense()) {
//            return new Expense(typeExpense, nameItem, amount);
//        } else if (typeMoneyFlow.isIncome()) {
//            return new Income(typeExpense, nameItem, amount);
//        }

        return (typeMoneyFlow.isExpense()? new Expense(typeExpense, nameItem, amount):new Income(typeExpense, nameItem, amount));


    }

    // == private methods ==

}
