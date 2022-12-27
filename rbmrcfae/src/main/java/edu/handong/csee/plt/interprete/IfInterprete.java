package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.If;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.BooleanValue;
import edu.handong.csee.plt.structure.value.NumberValue;
import edu.handong.csee.plt.structure.value.Value;

public class IfInterprete extends Interprete {

    @Override
    public ValueWithLog interprete(Interpreter interpreter,
                                   AST ast, Variable variable, Memory memory)    
                                        throws InterpreteException {
        interpreter.setMethod(new NewBoxInterprete());
        
        if (ast instanceof If) {
            If node = (If) ast;
            ValueWithLog testVwl = 
                    interpreter.interprete(node.getTestExpression(), 
                                           variable, memory);
            Value testValue = testVwl.getValue().strict();
            
            if ((testValue instanceof BooleanValue 
                    && !((BooleanValue) testValue).getBool())
                            || (testValue instanceof NumberValue 
                                && ((NumberValue) testValue).getNumber() == 0)) {
                return interpreter.interprete(node.getElseExpression(), 
                                              variable, testVwl.getMemory());
            } else {
                return interpreter.interprete(node.getThenExpression(),
                                              variable, testVwl.getMemory());
            }
        }
        return null;
    }
}
