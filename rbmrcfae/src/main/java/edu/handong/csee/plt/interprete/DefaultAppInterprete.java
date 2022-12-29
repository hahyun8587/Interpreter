package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.App;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.ClosureValue;
import edu.handong.csee.plt.structure.value.ExpressionValue;
import edu.handong.csee.plt.structure.value.ValClosureValue;

public class DefaultAppInterprete extends ValAppInterprete {

    @Override 
    public ValueWithLog interprete(Interpreter interpreter, 
                                   AST ast, Variable variable, Memory memory) 
                                        throws InterpreteException {
        interpreter.setMethod(new ReAppInterprete());

        if (ast instanceof App) { 
            ValueWithLog tempVwl = 
                    new Interpreter().interprete(((App) ast).getFunction(), 
                                                 variable, memory);
            ValueWithLog tempStrictVwl = 
                    tempVwl.getValue().strict(tempVwl.getMemory());

            if (tempStrictVwl.getValue() instanceof ClosureValue) {
                functionStrictVwl = tempStrictVwl;

                if (functionStrictVwl.getValue() instanceof ValClosureValue) {
                    return appInterprete((App) ast, variable);
                }
            }
        }
        return null;
    }

    @Override 
    protected void checkArgumentType(AST argument) {}

    @Override
    protected ExpressionValue createExpressionValue(AST expression, 
			Variable variable, Memory memory, Variable updated) {
        return new ExpressionValue(expression, variable, memory, null);
    }
}
