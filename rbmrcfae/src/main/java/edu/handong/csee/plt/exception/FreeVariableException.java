package edu.handong.csee.plt.exception;

public class FreeVariableException extends InterpreteException {

    public FreeVariableException(String id) {
        super(id);
    }

    @Override 
    public String getMessage() {
        return "memory error: free identifier " + ast.getASTCode();
    }
}
