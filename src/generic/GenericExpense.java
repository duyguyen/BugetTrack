package generic;

import item.Expense;

public class GenericExpense extends GenericBase<Expense> {

    @Override
    public double total(Expense object) {
        return super.total(object);
    }
}
