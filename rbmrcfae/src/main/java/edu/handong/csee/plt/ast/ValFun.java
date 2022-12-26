package edu.handong.csee.plt.ast;

public class ValFun extends Fun {

    public ValFun(String parameter, AST body) {
        super(parameter, body);
    }
    
    @Override
    public String getASTCode() {
        return "(fun '" + parameter + " " + body.getASTCode() + ")"; 
    }
}
