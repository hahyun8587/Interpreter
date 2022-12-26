package edu.handong.csee.plt.ast;

public class ReFun extends Fun {

    public ReFun(String parameter, AST body) {
        super(parameter, body);
    }

    @Override
    public String getASTCode() {
        return "(refun '" + parameter + " " + body.getASTCode() + ")";
    }
}
