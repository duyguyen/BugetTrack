package item;

public class Expense extends Base{

    // == constance variable ==
    private TypeExpense typeExpense;

    // == constructor ==
    public Expense(TypeExpense typeExpense, String nameItem, double amount) {
        super(TypeMoneyFlow.EXPENSE, nameItem, amount);
        this.typeExpense = typeExpense;
    }

    // == public methods ==
    public TypeExpense getTypeExpense() {
        return typeExpense;
    }
}


