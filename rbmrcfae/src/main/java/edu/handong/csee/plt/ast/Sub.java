package edu.handong.csee.plt.ast;

public class Sub extends Binary {

    public Sub(AST lhs, AST rhs) {
        super(lhs, rhs);
    }

    @Override
    public String getASTCode() {
        return getBinaryASTCode("sub");
    }
}
