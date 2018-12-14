package item;

public class Expense extends Base{

    // == constance variable ==
    private TypeExpense typeExpense;

    // == constructor ==
    public Expense(String referenceNumber, String descriptionOrCredit, String transDate, String postDate, double amount) {
        super(referenceNumber, descriptionOrCredit, transDate, postDate, amount, TypeMoneyFlow.EXPENSE);
    }

    // == public methods ==
    public TypeExpense getTypeExpense() {
        return typeExpense;
    }
}


