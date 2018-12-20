package funds;

public class Necessities extends FundBase {


    public Necessities(double totalBudget, BudgetType budgetType) {
        super(totalBudget, budgetType);
    }

    @Override
    public void allocatePercentBudget() {
        double percent = (totalBudget * 50.0) / 100.0;
        this.percentBudget = Math.round(percent*100.0)/100.0;
    }
}
