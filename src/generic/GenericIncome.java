package generic;

import item.Income;

public class GenericIncome extends GenericBase<Income> {

    @Override
    public double total(Income object) {
        return super.total(object) + 1000;
    }
}
