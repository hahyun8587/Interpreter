package edu.handong.csee.plt.structure;

import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.value.Value;

public class ValueWithLog {
    private Value value;
    private Memory memory;

    public ValueWithLog(Value value, Memory memory) {
        this.value = value;
        this.memory = memory;
    }

    public Value getValue() {
        return value;
    }

    public Memory getMemory() {
        return memory;
    }

    public String getASTCode() throws InterpreteException {
        return "(v*s " + value.getASTCode() + " " 
               + (memory == null ? "(mtSto)" : memory.getASTCode()) + ")";
    } 
}
