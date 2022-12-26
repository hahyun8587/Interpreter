package edu.handong.csee.plt.ast;

public class SetVar extends AST {
    public static int numChild = 2;
    private String name;
    private AST value;
    
    public SetVar(String name, AST value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public AST getValue() {
        return value;
    }

    @Override
    public String getASTCode() {
        return "(setvar '" + name + " " + value.getASTCode() + ")";
    }
    
}
