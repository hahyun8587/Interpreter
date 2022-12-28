package edu.handong.csee.plt.structure.value;

import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;

public class BoxValue extends Value {
    private int address;

    public BoxValue(int address) {
        this.address = address;
    }

    @Override
    public ValueWithLog strict(Memory memory) {
        return new ValueWithLog(this, memory);
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    @Override 
    public String getASTCode() {
        return "(boxV " + String.valueOf(address) + ")";
    }
}
