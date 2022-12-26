package edu.handong.csee.plt.ast;

public class OpenBox extends AST {
    public static int numChild = 1;
    private AST box;
    
    public OpenBox(AST box) {
        this.box = box;
    }

    public AST getBox() {
        return box;
    }

    @Override
    public String getASTCode() {
        return "(openbox " + box.getASTCode() + ")";
    } 
}
