package edu.handong.csee.plt.exception.handler.parse;

import edu.handong.csee.plt.exception.TypeMismatchException;

/**
 * Class that handles type exception.
 */
public abstract class TypeExceptionHandler extends ParseExceptionHandler {
    
    /**
     * Handles type excepton according to the given expression.
     * Exception will be thrown if the type of the given expression is not match to the appropriate type.
     * Otherwise, nothing happens.
     * @param expression expression
     * @param node the name of the AST node that exception handling occurs
     * @throws TypeMisMatchException
     */
    public abstract void handleException(String expression, String node) 
            throws TypeMismatchException; 
}
