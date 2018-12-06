package item;

public enum TypeMoneyFlow {

    EXPENSE,
    INCOME;

    // == public methods ==
    public boolean isExpense(){return this == EXPENSE;}
    public boolean isIncome(){return this == INCOME;}
}
