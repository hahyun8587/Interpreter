package edu.handong.csee.plt.exception.handler.interprete;

import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.CannotEvaluateException;
import edu.handong.csee.plt.structure.value.NumberValue;
import edu.handong.csee.plt.structure.value.Value;

/**
 * Class that checks if the given value is an instance of <code>NumberValue</code>.
 */
public class NumberValueTypeExceptionHandler extends ValueTypeExceptionHandler {

    @Override
    public void handleException(Value value, AST ast) 
            throws CannotEvaluateException {
        if (!(value instanceof NumberValue)) {
            throw new CannotEvaluateException(ast);
        }
    }
}
