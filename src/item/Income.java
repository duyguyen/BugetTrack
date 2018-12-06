package item;

public class Income extends Base {

    // == constance variables ==

    // == constructor ==
    public Income(String nameItem, double amount) {
        super(TypeMoneyFlow.INCOME, nameItem, amount);
    }
}
