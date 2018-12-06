package category;

import item.Base;
import item.CategoryType;

import java.util.ArrayList;

public class Category {

    // == constance variables ==
    private CategoryType categoryType;
    private double totalMoney;
    private ArrayList<Base> items = new ArrayList<>();

    // == constructor ==
    public Category(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public Category() {
    }

    // == public methods ==
    public void addItem(Base item){
        items.add(item);
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }
}
