package edu.handong.csee.plt.ast;

public class Mul extends Binary {
    
    public Mul(AST lhs, AST rhs) {
        super(lhs, rhs);
    }

    @Override 
    public String getASTCode() {
        return getBinaryASTCode("mul");
    }
}
