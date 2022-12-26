package edu.handong.csee.plt.ast;

public class If extends AST {
    public static int numChild = 3;
    private AST testExpression;
    private AST thenExpression;
    private AST elseExpression;

    public If(AST testExpression, AST thenExpression, AST elseExpression) {
        this.testExpression = testExpression;
        this.thenExpression = thenExpression;
        this.elseExpression = elseExpression;
    }

    public AST getTestExpression() {
        return testExpression;
    }

    public AST getThenExpression() {
        return thenExpression;
    }

    public AST getElseExpression() {
        return elseExpression;
    }

    @Override 
    public String getASTCode() {
        return "(if " + testExpression.getASTCode() + " " 
               + thenExpression.getASTCode() + " " 
               + elseExpression.getASTCode() + ")";
    }
}
