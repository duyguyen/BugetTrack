package utilities;

import item.TypeExpense;
import item.TypeMoneyFlow;

public interface ScriptInteger<T> {
    TypeMoneyFlow buildTypeMoneyFlow(T object);
    TypeExpense buildTypeExpense(T object);
}
