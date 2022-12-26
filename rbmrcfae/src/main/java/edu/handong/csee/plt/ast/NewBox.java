package edu.handong.csee.plt.ast;

public class NewBox extends AST {
    public static int numChild = 1;
    private AST value;

    public NewBox(AST value) {
        this.value = value;
    }

    public AST getValue() {
        return value;
    }

    @Override 
    public String getASTCode() {
        return "(newbox " + value.getASTCode() + ")";
    }
}
