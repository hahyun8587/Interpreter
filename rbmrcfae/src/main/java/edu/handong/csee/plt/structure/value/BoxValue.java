package edu.handong.csee.plt.structure.value;

public class BoxValue extends Value {
    private int address;

    public BoxValue(int address) {
        this.address = address;
    }

    public int getAddress() {
        return address;
    }

    @Override
    public Value strict() {
        return this;
    }

    @Override 
    public String getASTCode() {
        return "(boxV " + String.valueOf(address) + ")";
    }
}
