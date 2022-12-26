package edu.handong.csee.plt.structure.value;

import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.structure.store.Variable;

public class ValClosureValue extends ClosureValue {

    public ValClosureValue(String parameter, AST body, Variable variable) {
        super(parameter, body, variable);
    }

    @Override
    public String getASTCode() {
        return getClosureValueASTCode("closV");
    }
}