package edu.handong.csee.plt.ast;

public class Rec extends AST {
    public static int numChild = 3;
    private String functionName;
    private AST function;
    private AST expression; 

    public Rec(String functionName, AST function, AST expression) {
        this.functionName = functionName;
        this.function = function;
        this.expression = expression;
    }

    public String getFunctionName() {
        return functionName;
    }

    public AST getFunction() {
        return function;
    }

    public AST getExpression() {
        return expression;
    }

    @Override
    public String getASTCode() {
        return "(rec '" + functionName + " " 
               + function.getASTCode() + " " 
               + expression.getASTCode() + ")";
    }
}
