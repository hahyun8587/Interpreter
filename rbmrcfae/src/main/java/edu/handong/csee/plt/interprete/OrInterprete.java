package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.Or;
import edu.handong.csee.plt.exception.CannotEvaluateException;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.BooleanValue;
import edu.handong.csee.plt.structure.value.NumberValue;
import edu.handong.csee.plt.structure.value.Value;

public class OrInterprete extends BinaryInterprete {

    @Override 
    public ValueWithLog interprete(Interpreter interpreter, 
                                   AST ast, Variable variable, Memory memory) 
                                        throws InterpreteException {
        interpreter.setMethod(new IdInterprete());

        if (ast instanceof Or) {
            return binaryInterprete(((Or) ast).getLhs(), ((Or) ast).getRhs(), 
                                    variable, memory);
        }
        return null;          
    }

    @Override 
    protected void checkLhs(Value value, AST ast) 
            throws CannotEvaluateException {}

    @Override 
    protected void checkRhs(Value value, AST ast) 
            throws CannotEvaluateException {}

    @Override 
    protected ValueWithLog createInstance(Value lhsValue, Value rhsValue, 
                                          Memory latest) {
        if (((lhsValue instanceof BooleanValue 
            && ((BooleanValue) lhsValue).getBool() == false) 
                    || (lhsValue instanceof NumberValue 
                       && ((NumberValue) lhsValue).getNumber() == 0)) 
                                && ((rhsValue instanceof BooleanValue 
                                   && ((BooleanValue) rhsValue).getBool() == false) 
                                            || (rhsValue instanceof NumberValue 
                                               && ((NumberValue) rhsValue).getNumber() == 0))) {
            return new ValueWithLog(new BooleanValue(false), latest);
        } else {
            return new ValueWithLog(new BooleanValue(true), latest);
        }                       
    }
}

