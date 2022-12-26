package edu.handong.csee.plt.ast;

public class Or extends Binary {
    
    public Or(AST lhs, AST rhs) {
        super(lhs, rhs);
    }

    @Override 
    public String getASTCode() {
        return getBinaryASTCode("or");
    }
}
