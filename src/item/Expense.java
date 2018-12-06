package item;

import base.Base;

public class Expense extends Base {

    // == constance variable ==

    // == constructor ==
    public Expense(TypeExpense typeExpense, String nameItem, double amount) {
        super(TypeMoneyFlow.EXPENSE, typeExpense, nameItem, amount);
    }
}
