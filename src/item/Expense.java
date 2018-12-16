package item;

public class Expense extends Item {

    // == constance variable ==
    private TypeExpense typeExpense;

    // == constructor ==
    public Expense(String referenceNumber, String descriptionOrCredit, String transDate, String postDate, double amount) {
        super(referenceNumber, descriptionOrCredit, transDate, postDate, amount, TypeMoneyFlow.EXPENSE);
    }

    public Expense(String descriptionOrCredit, String transDate, String postDate, double amount) {
        super("NONE", descriptionOrCredit, transDate, postDate, amount, TypeMoneyFlow.EXPENSE);
    }

    // == public methods ==
    public TypeExpense getTypeExpense() {
        return typeExpense;
    }
}


