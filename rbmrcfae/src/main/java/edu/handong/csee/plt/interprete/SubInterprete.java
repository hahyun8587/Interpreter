package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.Sub;
import edu.handong.csee.plt.exception.CannotEvaluateException;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.exception.handler.interprete.NumberValueTypeExceptionHandler;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.NumberValue;
import edu.handong.csee.plt.structure.value.Value;

public class SubInterprete extends BinaryInterprete {

    public SubInterprete() {
        valueTypeExceptionHandler = new NumberValueTypeExceptionHandler();
    }

    @Override 
    public ValueWithLog interprete(Interpreter interpreter,
                                   AST ast, Variable variable, Memory memory) 
                                        throws InterpreteException {
        interpreter.setMethod(new MulInterprete());

        if (ast instanceof Sub) {
            return binaryInterprete(interpreter, 
                                    ((Sub) ast).getLhs(), ((Sub) ast).getRhs(), 
                                    variable, memory);         
        }
        return null; 
    }

    @Override 
    protected void checkLhs(Value value, AST ast) 
            throws CannotEvaluateException {
        valueTypeExceptionHandler.handleException(value, ast);
    }

    @Override 
    protected void checkRhs(Value value, AST ast) 
            throws CannotEvaluateException {
        valueTypeExceptionHandler.handleException(value, ast);
    }

    @Override 
    protected ValueWithLog createInstance(Value lhsValue, Value rhsValue, 
                                          Memory latest) {
        return new ValueWithLog(
                new NumberValue(((NumberValue) lhsValue).getNumber() 
                                - ((NumberValue) rhsValue).getNumber()),
                latest);
    }
}