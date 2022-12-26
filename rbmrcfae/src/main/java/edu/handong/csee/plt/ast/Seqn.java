package edu.handong.csee.plt.ast;

public class Seqn extends Binary {

    public Seqn(AST firstExpression, AST secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public String getASTCode() {
        return getBinaryASTCode("seqn");
    } 
}
