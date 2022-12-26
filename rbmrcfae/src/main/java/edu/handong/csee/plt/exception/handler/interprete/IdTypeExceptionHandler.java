package edu.handong.csee.plt.exception.handler.interprete;

import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.Id;
import edu.handong.csee.plt.exception.CannotEvaluateException;

public class IdTypeExceptionHandler extends ASTTypeExceptionHandler {

    @Override 
    public void handleException(AST node) 
            throws CannotEvaluateException {
        if (!(node instanceof Id)) {
            throw new CannotEvaluateException(node);
        }
    }
}
