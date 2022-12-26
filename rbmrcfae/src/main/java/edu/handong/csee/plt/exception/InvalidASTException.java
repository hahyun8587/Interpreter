package edu.handong.csee.plt.exception;

import edu.handong.csee.plt.ast.AST;

/**
 *  Thrown when the given AST node is an invalid AST node. 
 */
public class InvalidASTException extends InterpreteException {
    
    public InvalidASTException(AST ast) {
        super(ast);
    }

    @Override 
    public String getMessage() {
        return "interprete error: invalid AST node.\n";
    }
}
