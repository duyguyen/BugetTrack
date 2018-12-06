package item;

public enum TypeExpense {

    FIXED,
    NOT_FIXED;

    // == public methods ==
    public boolean isFixed(){return this == FIXED;}
    public boolean isNotFixed(){return this == NOT_FIXED;}
}
