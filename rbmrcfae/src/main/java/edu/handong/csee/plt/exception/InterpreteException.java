package edu.handong.csee.plt.exception;

import edu.handong.csee.plt.ast.AST;

/**
 * Class that represents exceptions caused by interpreting.
 */
public abstract class InterpreteException extends Exception {
    protected AST ast;
    protected String id;
    protected int address;

    public InterpreteException(AST ast) {
        this.ast = ast;
    }

    public InterpreteException(String id) {
        this.id = id;
    }

    public InterpreteException(int address) {
        this.address = address;
    }

    @Override
    public abstract String getMessage();
}
