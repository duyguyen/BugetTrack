package factory;

import category.LifeStyleChoices;
import category.LongSaving;
import category.NecessityFund;
import category.SpecificFund;
import item.*;
import wrting_data.WriteData;

import java.io.IOException;

public class Factory {

    // == constants ==
    private WriteData writeData;

    // == constructor ==
    public Factory(WriteData writeData){
        this.writeData = writeData;
    }

    // == public methods ==
    public Base createItem(TypeExpense typeExpense, String nameItem, double amount) throws IOException {
        Base item = new Expense(typeExpense, nameItem, amount);
        // write new item to items file
        writeData.appendToItems(item.getDate(), item.getNameItem(), item.getTypeMoneyFlow(), ((Expense) item).getTypeExpense(), item.getAmount(), item.getDescription());
        return item;
    }

    public Base createItem(String nameItem, double amount) throws IOException{
        Base item = new Income(nameItem, amount);
        // write new item to items file
        writeData.appendToItems(item.getDate(), item.getNameItem(), item.getTypeMoneyFlow(), item.getAmount(), item.getDescription());
        return item;
    }

    public SpecificFund createCategories(CategoryType categoryType) {
        if (categoryType == CategoryType.NECESSITY) {
            return new NecessityFund();
        } else if (categoryType == CategoryType.LONG_TERNS_SAVING) {
            return new LongSaving();
        } else if (categoryType == CategoryType.LIFESTYLE_CHOICE) {
            return new LifeStyleChoices();
        }

        return new NecessityFund();
    }



    // == private methods ==

}
