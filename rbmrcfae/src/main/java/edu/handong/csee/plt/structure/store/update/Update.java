package edu.handong.csee.plt.structure.store.update;

import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.exception.handler.interprete.InterpreteExceptionHandler;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.ExpressionValue;

public abstract class Update {
    protected InterpreteExceptionHandler handler;

    public abstract Memory update(ExpressionValue value, AST expression, 
                                  Variable variable, Memory old, Memory lazy)
                                        throws InterpreteException;
}
