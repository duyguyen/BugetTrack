package category;

import item.Item;
import item.CategoryType;

import java.util.ArrayList;

public abstract class SpecificFund {

    // == constance variables ==
    private CategoryType categoryType;
    private double totalMoney;
    private ArrayList<Item> items = new ArrayList<>();

    // == constructor ==
    public SpecificFund(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    // == public methods ==
    public void addItem(Item item){
        items.add(item);
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }
}
