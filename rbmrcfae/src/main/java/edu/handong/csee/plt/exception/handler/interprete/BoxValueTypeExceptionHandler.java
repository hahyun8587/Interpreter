package edu.handong.csee.plt.exception.handler.interprete;

import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.CannotEvaluateException;
import edu.handong.csee.plt.structure.value.BoxValue;
import edu.handong.csee.plt.structure.value.Value;

public class BoxValueTypeExceptionHandler extends ValueTypeExceptionHandler {
   
    @Override 
    public void handleException(Value value, AST ast)
            throws CannotEvaluateException {
        if (!(value instanceof BoxValue)) {
            throw new CannotEvaluateException(ast);
        }
    }
}
