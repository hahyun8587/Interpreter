package edu.handong.csee.plt.structure.value;

import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.structure.store.Variable;

public abstract class ClosureValue extends Value {
    protected String parameter;
    protected AST body;
    protected Variable variable;

    public ClosureValue(String parameter, AST body, Variable variable) {
        this.parameter = parameter;
        this.body = body;
        this.variable = variable;
    }

    public String getParameter() {
        return parameter;
    }

    public AST getBody() {
        return body;
    }

    public Variable getVariable() {
        return variable;
    }

    @Override 
    public Value strict() {
        return this;
    }

    public String getClosureValueASTCode(String node) {
        return "(" + node + " '" + parameter + " " 
               + body.getASTCode() + " " 
               + (variable == null ? "(mtSub)" : variable.getASTCode()) + ")"; 
    }
}
