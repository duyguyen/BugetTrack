import base.Base;
import calculation.Statistic;
import factory.Factory;
import generic.Generic;
import generic.GenericBase;
import generic.GenericExpense;
import generic.GenericIncome;
import item.Expense;
import item.Income;
import item.TypeExpense;
import item.TypeMoneyFlow;
import price.Amount;

import java.util.ArrayList;

public class Run {

    // == constance variables ==
    private ArrayList<Base> items;
    private Factory factory;
    private Statistic statistic;

    // == constructor ==
    public Run() {
        init();
    }

    // == init ==
    private void init() {
        factory = new Factory();
        items = new ArrayList<>();
        generateItem();
        statistic = new Statistic(items);


    }

    // == driver ==
    public static void main(String[] args) {
        Run run = new Run();
        run.print();

    }

    // == public methods ==
    public void generateItem() {
        Base homeMortgage = factory.createItem(TypeExpense.FIXED, "Home mortgage", Amount.HOME_MORTGAGE,
                TypeMoneyFlow.EXPENSE);
        Base carInsurance = factory.createItem(TypeExpense.FIXED, "Car insurance", Amount.CAR_INSURANCE,
                TypeMoneyFlow.EXPENSE);
        Base mobile = factory.createItem(TypeExpense.FIXED, "Mobile", Amount.MOBILE,
                TypeMoneyFlow.EXPENSE);
        Base lunch = factory.createItem(TypeExpense.NOT_FIXED, "Lunch", Amount.LUNCH,
                TypeMoneyFlow.EXPENSE);
        Base salary = factory.createItem(TypeExpense.NOT_FIXED, "salary", Amount.SALARY,
                TypeMoneyFlow.INCOME);

        items.add(homeMortgage);
        items.add(carInsurance);
        items.add(mobile);
        items.add(lunch);
        items.add(salary);

    }

    public void print() {
        System.out.println();
        System.out.println(statistic.getTotalExpense());











       /* ArrayList<Base> expenses = new ArrayList<>();
        ArrayList<Base> incomes = new ArrayList<>();

        for (Base item: items){
            if (item.getTypeMoneyFlow().isExpense()){
                expenses.add(item);
            }else {
                incomes.add(item);
            }
        }


        Generic g = new GenericExpense();
        Generic i = new GenericIncome();

        System.out.println(test(incomes, i));*/
    }
    public <T extends Base> double test(ArrayList<T> items, Generic<T> g){
        double total = 0;
        for (T item: items){
            total += g.total(item);
        }

        return total;
    }
}
