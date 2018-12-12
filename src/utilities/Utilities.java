package utilities;

import item.TypeExpense;
import item.TypeMoneyFlow;
import utilities.script_files.DoubleGeneric;
import utilities.script_files.IntegerGeneric;

public class Utilities{

    // == constants ==
    private IntegerGeneric scriptInteger;
    private DoubleGeneric doubleGeneric;

    // == constructor ==
    public Utilities(IntegerGeneric scriptInteger, DoubleGeneric doubleGeneric){
        this.scriptInteger = scriptInteger;
        this.doubleGeneric = doubleGeneric;
    }

    // == public methods ==
    public StringBuilder convertStringToStringBuilder(String string) {
        return new StringBuilder(string);
    }

    public TypeMoneyFlow buildTypeMoneyFlow(int i) {
        return scriptInteger.buildTypeMoneyFlow(i);
    }

    public TypeExpense buildTypeExpense(int i) {
        return scriptInteger.buildTypeExpense(i);
    }

    public double buildAmount(double amount){
        return doubleGeneric.amount(amount);
    }
}
