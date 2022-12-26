package edu.handong.csee.plt.exception.handler.interprete;

import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.CannotEvaluateException;
import edu.handong.csee.plt.structure.value.ClosureValue;
import edu.handong.csee.plt.structure.value.Value;

public class ClosureValueTypeExceptionHandler 
        extends ValueTypeExceptionHandler {
    
    @Override
    public void handleException(Value value, AST ast) 
            throws CannotEvaluateException {
        if (!(value instanceof ClosureValue)) {
            throw new CannotEvaluateException(ast);
        }
    }
}
