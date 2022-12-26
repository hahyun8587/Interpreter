package edu.handong.csee.plt.exception;

import edu.handong.csee.plt.ast.AST;

/**
 * Class that represents exceptions caused by interpreting.
 */
public abstract class InterpreteException extends Exception {
    protected AST ast;

    public InterpreteException(AST ast) {
        this.ast = ast;
    }

    @Override
    public abstract String getMessage();
}
