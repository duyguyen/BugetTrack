package funds;

public class LifeChoices extends FundBase {

    public LifeChoices(double totalBudget, BudgetType budgetType) {
        super(totalBudget, budgetType);
    }

    // == public methods ==
    @Override
    public void allocatePercentBudget() {
        double percent = (totalBudget * 30.0) / 100.0;
        this.percentBudget = Math.round(percent*100.0)/100.0;
    }
}
