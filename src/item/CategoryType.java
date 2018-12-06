package item;

public enum CategoryType {
    NECESSITY,
    LONGTERN_SAVING,
    LIFESTYLE_CHOICE;

    //== public methods ==

    public boolean isNecessity(){return this == NECESSITY;}
    public boolean isLongTermSaving(){return this == LONGTERN_SAVING;}
    public boolean isLifeStyleChoice(){return this == LIFESTYLE_CHOICE;}
}
