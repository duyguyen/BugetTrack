package funds;

public class LongTernSaving extends FundBase {

    public LongTernSaving(double totalBudget, BudgetType budgetType) {
        super(totalBudget, budgetType);
    }

    // == public methods ==
    @Override
    public void allocatePercentBudget() {
        double percent = (totalBudget * 20.0) / 100.0;
        this.percentBudget = Math.round(percent*100.0)/100.0;
    }
}
