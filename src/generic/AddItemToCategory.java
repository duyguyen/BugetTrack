package generic;

import category.Category;
import item.Base;

public class AddItemToCategory implements Generic<Category> {

    @Override
    public void add(Category category, Base item) {
        category.addItem(item);
    }
}
