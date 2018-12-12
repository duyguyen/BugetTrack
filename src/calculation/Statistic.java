package calculation;

import item.Base;
import item.Expense;

import java.util.ArrayList;

public class Statistic {

    // == constance variables ==
    private ArrayList<Base> items;
    private double totalExpense;
    private double totalIncome;
    private double totalFixedExpense;
    private double totalNotFixedExpense;
    private double monerLeft;
    private Delivery delivery;


    public Statistic(ArrayList<Base> items) {
        this.items = items;
        init();
    }

    // == init ==
    private void init(){
        calculateTotalExpenseAndTotalIncome();
        calculateFixedAndNotFixed();
        calculateMoneyLeft();
        delivery = new Delivery();
    }

//    private void setDelivery(){
//        delivery.setGroceryFund();
//    }

    // == public methods ==
//    public double calculateGroceryFund(double percent){
//        double convertToPercent = percent/100.0;
//        return Math.round(convertToPercent*calculateMoneyLeft());
//    }

    public double calculateLunchEachDay(){
        double lunchEachDay = 0;
        for (Base item: items){
            if (item.getNameItem().toString().equalsIgnoreCase("lunch")){
                lunchEachDay = Math.round(item.getAmount() / 30.0);
            }
        }
        return lunchEachDay;
    }

    public double calculateAfterFixedExpense(){
        return Math.round(totalIncome - totalFixedExpense);
    }

    public void calculateMoneyLeft() {
        this.monerLeft = Math.round(totalIncome - totalExpense);
    }

    public void calculateFixedAndNotFixed() {
        double totalFixed = 0;
        double totalNotFixed = 0;

        for (Base item : items) {
            if (item.getTypeMoneyFlow().isExpense()) {
                Expense expense = (Expense) item;

                if ((expense.getTypeExpense().isFixed())){
                    totalFixed += item.getAmount();
                } else if (expense.getTypeExpense().isNotFixed()) {
                    totalNotFixed += item.getAmount();
                }
            }
        }

        this.totalFixedExpense = totalFixed;
        this.totalNotFixedExpense = totalNotFixed;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public double getTotalIncome() {
        return totalIncome;
    }


    // == private methods ==
    private void calculateTotalExpenseAndTotalIncome() {
        double totalExpense = 0;
        double totalIncome = 0;
        for (Base item : items) {
            if (item.getTypeMoneyFlow().isExpense()) {
                totalExpense += item.getAmount();
            } else {
                totalIncome += item.getAmount();
            }
        }

        this.totalExpense = totalExpense;
        this.totalIncome = totalIncome;
    }

}
