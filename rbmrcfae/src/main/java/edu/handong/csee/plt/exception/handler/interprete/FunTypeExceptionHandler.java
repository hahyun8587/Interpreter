package edu.handong.csee.plt.exception.handler.interprete;

import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.Fun;
import edu.handong.csee.plt.exception.CannotEvaluateException;

public class FunTypeExceptionHandler extends ASTTypeExceptionHandler {
    
    @Override
    public void handleException(AST node) throws CannotEvaluateException {
        if (!(node instanceof Fun)) {
            throw new CannotEvaluateException(node);
        }
    }
}
