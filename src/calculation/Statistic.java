package calculation;

import base.Base;

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


        print();
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

    private void print() {
        System.out.println("Total expense: " + totalExpense + " Total Income: " + totalIncome +
               " FixedExpense: " + totalFixedExpense +
                " NotFixedExpense: " + totalNotFixedExpense);
    }

    // == public methods ==
//    public double calculateGroceryFund(double percent){
//        double convertToPercent = percent/100.0;
//        return Math.round(convertToPercent*calculateMoneyLeft());
//    }

    public double calculateLunchEachDay(){
        double luchEachDay = 0;
        for (Base item: items){
            if (item.getNameItem().toString().equalsIgnoreCase("lunch")){
                luchEachDay = Math.round(item.getAmount() / 30.0);
            }
        }
        return luchEachDay;
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
                if (item.getTypeExpense().isFixed()) {
                    totalFixed += item.getAmount();
                } else if (item.getTypeExpense().isNotFixed()) {
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