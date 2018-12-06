import calculation.Statistic;
import category.Category;
import factory.Factory;
import generic.AddItemToCategory;
import generic.Generic;
import item.Base;
import item.CategoryType;
import item.TypeExpense;
import price.Amount;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {

    // == constance variables ==
    private ArrayList<Base> items = new ArrayList<>();
    private Factory factory;
    private Statistic statistic;
    private ArrayList<Category> categories = new ArrayList<>();

    private boolean addItem = true;

    // == constructor ==
    public Run() {
        init();
    }

    // == init ==
    private void init() {
        factory = new Factory();
        generateItem();
        categories = factory.createCategories();
        statistic = new Statistic(items);

    }

    // == driver ==
    public static void main(String[] args) {
        Run run = new Run();
        run.print();

    }

    // == public methods ==
    public void generateItem() {
        Base homeMortgage = factory.createItem(TypeExpense.FIXED, "Home mortgage", Amount.HOME_MORTGAGE);

        Base carInsurance = factory.createItem(TypeExpense.FIXED, "Car insurance", Amount.CAR_INSURANCE);

        Base mobile = factory.createItem(TypeExpense.FIXED, "Mobile", Amount.MOBILE);

        Base lunch = factory.createItem(TypeExpense.NOT_FIXED, "Lunch", Amount.LUNCH);
        lunch.setCategoryType(CategoryType.NECESSITY);

        Base cloths = factory.createItem(TypeExpense.NOT_FIXED, "cloths", Amount.CLOTHS);
        cloths.setCategoryType(CategoryType.LIFESTYLE_CHOICE);

        Base salary = factory.createItem("salary", Amount.SALARY);

        items.add(homeMortgage);
        items.add(carInsurance);
        items.add(mobile);
        items.add(lunch);
        items.add(cloths);
        items.add(salary);

    }

    public void print() {
        Scanner scanner = new Scanner(System.in);


        while(addItem){
            System.out.println("Add item");
        }


    }

    // == private methods ==

    private Category sortCategory(CategoryType categoryType) {

        Category cat = new Category();

        for (Category category : categories) {
            if (categoryType == category.getCategoryType()) {
                cat = category;
            }
        }
        return cat;
    }

}
