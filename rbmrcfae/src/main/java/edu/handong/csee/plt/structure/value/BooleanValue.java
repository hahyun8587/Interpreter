package edu.handong.csee.plt.structure.value;

public class BooleanValue extends Value {
    private boolean bool;
    
    public BooleanValue(boolean bool) {
        this.bool = bool;
    }

    public boolean getBool() {
        return bool;
    }

    @Override 
    public Value strict() {
        return this;    
    }

    @Override 
    public String getASTCode() {
        return "(boolV " + (bool ? "#t" : "#f") + ")";
    }

}
