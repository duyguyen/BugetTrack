package factory;

import category.Category;
import item.*;

import java.util.ArrayList;

public class Factory {

    // == public methods ==
    public Base createItem(TypeExpense typeExpense, String nameItem, double amount) {
        return new Expense(typeExpense, nameItem, amount);
    }

    public Base createItem(String nameItem, double amount) {
        return new Income(nameItem, amount);
    }

    public ArrayList<Category> createCategories(){
        ArrayList<Category> categories = new ArrayList<>();
        Category necessity = new Category(CategoryType.NECESSITY);
        Category longTernSaving = new Category(CategoryType.LONGTERN_SAVING);
        Category lifeStyleChoice = new Category(CategoryType.LIFESTYLE_CHOICE);

        categories.add(necessity);
        categories.add(longTernSaving);
        categories.add(lifeStyleChoice);

        return categories;
    }

    // == private methods ==

}
