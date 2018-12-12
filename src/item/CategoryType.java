package item;

public enum CategoryType {
    NECESSITY,
    LONG_TERNS_SAVING,
    LIFESTYLE_CHOICE;

    //== public methods ==
    public boolean isNecessity(){return this == NECESSITY;}
    public boolean isLongTermSaving(){return this == LONG_TERNS_SAVING;}
    public boolean isLifeStyleChoice(){return this == LIFESTYLE_CHOICE;}
}
