package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.exception.handler.interprete.InterpreteExceptionHandler;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;

/**
 * Class that represents interprete methods.
 */
public abstract class Interprete {
    protected InterpreteExceptionHandler handler;

    /**
     * Interpretes the given ast to appropriate <code>ValueWithLog</code> instance.
     * @param interpreter interpreter
     * @param ast AST node 
     * @param variable variable
     * @param memory memory
     * @return appropriate <code>ValueWithLog</code> instance
     * @throws InterpreteException
     */
    public abstract ValueWithLog interprete(Interpreter interpreter, AST ast, 
            Variable variable, Memory memory) throws InterpreteException;
}
