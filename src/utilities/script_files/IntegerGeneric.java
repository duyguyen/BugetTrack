package utilities.script_files;

import item.TypeExpense;
import item.TypeMoneyFlow;

public class IntegerGeneric implements utilities.ScriptInteger<Integer> {
    @Override
    public TypeMoneyFlow buildTypeMoneyFlow(Integer object) {
        return (object == 1) ? TypeMoneyFlow.EXPENSE : TypeMoneyFlow.INCOME;
    }

    @Override
    public TypeExpense buildTypeExpense(Integer object) {
        return (object == 1) ? TypeExpense.FIXED : TypeExpense.NOT_FIXED;
    }
}
