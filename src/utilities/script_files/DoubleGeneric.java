package utilities.script_files;

import utilities.ScriptDouble;

public class DoubleGeneric implements ScriptDouble<Double> {

    @Override
    public double amount(Double object) {
        return object;
    }
}
