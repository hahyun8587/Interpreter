package edu.handong.csee.plt.exception.handler.interprete;

import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.CannotEvaluateException;

public abstract class ASTTypeExceptionHandler 
        extends InterpreteExceptionHandler {
    
    /**
     * Checks if the given AST node is a certain type.
     * Exception will be thrown if the given AST node is not a certain type.
     * Otherwise, nothing happens.
     * @param node AST node
     * @throws CannotEvaluateException
     */
    public abstract void handleException(AST node)
            throws CannotEvaluateException;
}
