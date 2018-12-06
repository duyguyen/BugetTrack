package item;

import base.Base;

public class Income extends Base {

    // == constance variables ==

    // == constructor ==
    public Income(TypeExpense typeExpense, String nameItem, double amount) {
        super(TypeMoneyFlow.INCOME, typeExpense, nameItem, amount);
    }
}
