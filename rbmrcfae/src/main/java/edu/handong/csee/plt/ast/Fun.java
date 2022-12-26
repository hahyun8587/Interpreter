package edu.handong.csee.plt.ast;

public abstract class Fun extends AST {
    public static int numChild = 2;
    protected String parameter;
    protected AST body;

    public Fun(String parameter, AST body) {
        this.parameter = parameter;
        this.body = body;
    }

    public String getParameter() {
        return parameter;
    }

    public AST getBody() {
        return body;
    }

    public abstract String getASTCode();
}
