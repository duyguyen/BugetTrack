package funds;

public enum BudgetType {

    NECESSITIES,
    LIFE_CHOICES,
    LONG_TERNS_SAVING;

    // == public methods ==
    public boolean isNecessities(){return this == NECESSITIES;}
    public boolean isLifeChoices(){return this == LIFE_CHOICES;}
    public boolean isLongTernSaving(){return this == LONG_TERNS_SAVING;}
}
