package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.SetBox;
import edu.handong.csee.plt.exception.CannotEvaluateException;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.exception.handler.interprete.BoxValueTypeExceptionHandler;
import edu.handong.csee.plt.exception.handler.interprete.ValueTypeExceptionHandler;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.BoxValue;
import edu.handong.csee.plt.structure.value.Value;

public class SetBoxInterprete extends BinaryInterprete {
    
    public SetBoxInterprete() {
        handler = new BoxValueTypeExceptionHandler();
    }

    @Override 
    public ValueWithLog interprete(Interpreter interpreter, 
                                   AST ast, Variable variable, Memory memory) 
                                   throws InterpreteException {
        interpreter.setMethod(new OpenBoxInterprete());
        
        if (ast instanceof SetBox) {
            return binaryInterprete(((SetBox) ast).getLhs(), 
                                    ((SetBox) ast).getRhs(), 
                                    variable, memory);
        }
        return null;
    }

    @Override 
    protected void checkLhs(Value value, AST ast) 
            throws CannotEvaluateException { 
        ((ValueTypeExceptionHandler) handler).handleException(value, ast);
    }

    @Override 
    protected void checkRhs(Value value, AST ast) {}
   
    @Override
    protected ValueWithLog createInstance(Value lhsValue, Value rhsValue, 
                                          Memory latest) {
        return new ValueWithLog(rhsValue, 
                                new Memory(((BoxValue) lhsValue).getAddress(),
                                           rhsValue, 
                                           latest,
                                           latest.getMaxAddress()));
    }

}
