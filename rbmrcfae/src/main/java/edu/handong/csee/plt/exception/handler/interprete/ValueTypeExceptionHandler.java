package edu.handong.csee.plt.exception.handler.interprete;

import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.CannotEvaluateException;
import edu.handong.csee.plt.structure.value.Value;

/**
 * Class that checks the type of the value.
 */
public abstract class ValueTypeExceptionHandler extends InterpreteExceptionHandler {

    /**
     * Checks if the given value is a certain type.
     * Exception will be thrown if the given value is not a certain type.
     * Otherwise, nothing happens.
     * @param value the value 
     * @param ast the AST node that exception handling occurs
     * @throws CannotEvaluateException
     */
    public abstract void handleException(Value value, AST ast)
            throws CannotEvaluateException;
}
