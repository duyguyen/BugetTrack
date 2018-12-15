package utilities;

import item.TypeExpense;
import item.TypeMoneyFlow;
import utilities.script_files.DoubleGeneric;
import utilities.script_files.IntegerGeneric;

public class Utilities{

    // == constants ==


    // == constructor ==
    public Utilities(){
    }


    // == public methods ==
    public static StringBuilder convertStringToStringBuilder(String string) {
        return new StringBuilder(string);
    }

    public static boolean defineReferenceNumberSpending(String str){
        return str.matches("\\d{7}.{10}");
    }

    public static boolean defineReferenceNumberReward(String str){
        return str.matches("[A-Z]\\d{6}.{5}[F][R]");
    }

    public static double convertStringToDouble(String str){
        return Double.parseDouble(str);
    }

    public static boolean defineAmount(String str){
        return str.matches("\\d+[.]\\d+");
    }

    public static boolean defineAccountNumberString(String string){
        return string.matches("[a-zA-Z]+\\s[a-zA-Z]+\\s[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}");
    }

    public static boolean defineAnItemLine(String string){
        return string.matches("(?s).*\\b[A-Z]\\d{6}.{5}[F][R]\\b.+||(?s).*\\b\\d{7}.{10}\\b.+||[A-Z]\\d{6}.{5}[F][R]");
    }

    public  static boolean defineAccountNumber(String string){
        return string.matches("[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}");
    }

    public static boolean definePeriod(String string){
        return string.matches("[a-zA-Z]+\\s\\d+[,]\\s\\d{4}\\s[a-zA-Z]+\\s[a-zA-Z]+\\s\\d+[,]\\s\\d{4}");
    }
}
