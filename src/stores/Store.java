package stores;

public class Store implements Comparable<Store> {

    // == constants ==
    private String name;
    private int density;
    private double totalSpending;
    private int sortValue;
    private boolean isPayingDebt;
    private boolean isHighSpending;
    private boolean isTheTopStore;

    // == constructor ==
    public Store(String name, int density, double totalSpending) {
        this.name = name;
        this.density = density;
        this.totalSpending = totalSpending;
        setSortValue(); // for sorting
        defineIsPayingDebt(totalSpending);
        defineIsHighSpending(totalSpending);
    }

    // == private methods ==
    private void setSortValue() {
        this.sortValue = (int) totalSpending;
    }

    private void defineIsHighSpending(double totalSpending) {
        if (totalSpending > 30.00) {
            isHighSpending = true;
        }
    }

    private void defineIsPayingDebt(double totalSpending) {
        if (totalSpending < 0.0) {
            this.isPayingDebt = true;
        }
    }

    // == public methods ==


    @Override
    public int compareTo(Store o) {
        return this.sortValue - o.sortValue;
    }

    public boolean isHighSpending() {
        return isHighSpending;
    }

    public String getName() {
        return name;
    }

    public int getDensity() {
        return density;
    }

    public double getTotalSpending() {
        return totalSpending;
    }

    public boolean isPayingDebt() {
        return isPayingDebt;
    }
}
