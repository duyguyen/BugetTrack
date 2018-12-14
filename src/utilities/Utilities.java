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
    public static StringBuilder convertStringToStringBuilder(String string) {
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

    public boolean defineReferenceNumberSpending(String str){
        return str.matches("\\d{7}.{10}");

//        [A-Z]\d{6}.{5}[F][R] for CREDIT ONE REWARD CREDIT LAS VEGA CREDIT
//         \\d{7}.{10} normal spending
    }

    public boolean defineReferenceNumberReward(String str){
        return str.matches("[A-Z]\\d{6}.{5}[F][R]");
    }

    public double convertStringToDouble(String str){
        return Double.parseDouble(str);
    }

    public boolean defineAmount(String str){
        return str.matches("\\d+[.]\\d+");
    }

    public boolean defineAccountNumberString(String string){
        return string.matches("[a-zA-Z]+\\s[a-zA-Z]+\\s[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}");
    }

    public boolean defineAccountNumber(String string){
        return string.matches("[0-9]{4}");
    }

    public boolean defineFromTo(String string){
        return string.matches("[a-zA-Z]+\\s\\d+[,]\\s\\d{4}\\s[a-zA-Z]+\\s[a-zA-Z]+\\s\\d+[,]\\s\\d{4}");
    }
}
