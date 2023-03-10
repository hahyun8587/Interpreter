package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.CannotEvaluateException;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.Value;

public abstract class BinaryInterprete extends Interprete {

    /**
     * Interpretes binary AST node into the appropriate <code>ValueWithLog</code> instance.
     * @param interpreter interpreter
     * @param lhs left-hand-side of the binary AST node
     * @param rhs right-hand-side of the binary AST node
     * @param variable variable
     * @param memory memory
     * @return the appropriate <code>ValueWithLog</code> instance
     * @throws InterpreteException
     */
    public ValueWithLog binaryInterprete(AST lhs, AST rhs, 
                                         Variable variable, Memory memory) 
                                            	throws InterpreteException {
        ValueWithLog lhsVwl, rhsVwl;
        ValueWithLog lhsStrictVwl, rhsStrictVwl;

        lhsVwl = new Interpreter().interprete(lhs, variable, memory);
        lhsStrictVwl = lhsVwl.getValue().strict(lhsVwl.getMemory());

        checkLhs(lhsStrictVwl.getValue(), lhs);
        
        rhsVwl = new Interpreter().interprete(rhs, variable, lhsStrictVwl.getMemory());
        rhsStrictVwl = rhsVwl.getValue().strict(rhsVwl.getMemory());

        checkRhs(rhsStrictVwl.getValue(), rhs);

        return createInstance(lhsStrictVwl.getValue(), rhsStrictVwl.getValue(), 
                              rhsStrictVwl.getMemory());
    }

    /**
     * Checks whether the given left-hand-side value is a certain type or not.
     * @param value the left-hand-side value 
     * @param ast current AST node
     * @throws CannotEvaluateException
     */
    protected abstract void checkLhs(Value value, AST ast) 
            throws CannotEvaluateException;

    /**
     * Checks whether the given right-hand-side value is a certain type or not.
     * @param value the right-hand-side value 
     * @param ast current AST node
     * @throws CannotEvaluateException
     */
    protected abstract void checkRhs(Value value, AST ast) 
            throws CannotEvaluateException;

    /**
     * Creates the appropriate <code>ValueWithLog</code> instance and does required extra works.
     * @param lhsValue interpreted value of the left-hand-side of the AST node
     * @param rhsValue interpreted value of the right-hand-side of the AST node
     * @param latest latest memory
     * @return the appropriate <code>ValueWithLog</code> instance
     */
    protected abstract ValueWithLog createInstance(Value lhsValue, Value rhsValue, 
                                                   Memory latest);
}
