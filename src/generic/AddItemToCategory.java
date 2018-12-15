package generic;

import category.SpecificFund;
import item.Item;

public class AddItemToCategory implements Generic<SpecificFund> {

    @Override
    public void add(SpecificFund specificFund, Item item) {
        specificFund.addItem(item);
    }
}
