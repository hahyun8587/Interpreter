package edu.handong.csee.plt.structure.value;

import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;

public class NumberValue extends Value {
    private int number;

    public NumberValue(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public ValueWithLog strict(Memory memory) {
        return new ValueWithLog(this, memory);
    }

    @Override 
    public String getASTCode() {
        return "(numV " + String.valueOf(number) + ")";
    }
}
