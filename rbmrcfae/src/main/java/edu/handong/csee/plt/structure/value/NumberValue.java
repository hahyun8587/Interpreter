package edu.handong.csee.plt.structure.value;

public class NumberValue extends Value {
    private int number;

    public NumberValue(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public Value strict() {
        return this;
    }

    @Override 
    public String getASTCode() {
        return "(numV " + String.valueOf(number) + ")";
    }
}
