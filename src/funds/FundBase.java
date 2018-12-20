package funds;

public abstract class FundBase {

    // == constants ==
    protected double totalBudget;
    protected double percentBudget;
    protected BudgetType budgetType;

    // == constructor ==
    public FundBase(double totalBudget, BudgetType budgetType) {
        this.totalBudget = -totalBudget; // convert from negative to positive
        this.budgetType = budgetType;
        allocatePercentBudget();
    }

    // == public methods ==
    public abstract void allocatePercentBudget();

    public double getPercentBudget() {
        return percentBudget;
    }

    public BudgetType getBudgetType() {
        return budgetType;
    }
}
