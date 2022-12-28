package edu.handong.csee.plt.structure.value;

import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;

public class BooleanValue extends Value {
    private boolean bool;
    
    public BooleanValue(boolean bool) {
        this.bool = bool;
    }

    public boolean getBool() {
        return bool;
    }

    @Override 
    public ValueWithLog strict(Memory memory) {
        return new ValueWithLog(this, memory);    
    }

    @Override 
    public String getASTCode() {
        return "(boolV " + (bool ? "#t" : "#f") + ")";
    }

}
