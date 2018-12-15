package item;

public class Income extends Item {

    // == constructor ==
    public Income(String referenceNumber, String descriptionOrCredit, String transDate, String postDate, double amount) {
        super(referenceNumber, descriptionOrCredit, transDate, postDate, amount, TypeMoneyFlow.INCOME);
    }
}
