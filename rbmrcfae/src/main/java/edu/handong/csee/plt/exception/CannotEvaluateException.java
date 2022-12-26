package edu.handong.csee.plt.exception;

import edu.handong.csee.plt.ast.AST;

/**
 * Thrown when the given AST node can't be evaluated.
 */
public class CannotEvaluateException extends InterpreteException {
    
    public CannotEvaluateException(AST ast) {
        super(ast);
    }

    @Override
    public String getMessage() {
        return "interprete error: cannot calculate in " 
               + ast.getASTCode() + ".\n";
    }
}
