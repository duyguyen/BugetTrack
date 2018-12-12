package generic;

import category.SpecificFund;
import item.Base;

public class AddItemToCategory implements Generic<SpecificFund> {

    @Override
    public void add(SpecificFund specificFund, Base item) {
        specificFund.addItem(item);
    }
}
