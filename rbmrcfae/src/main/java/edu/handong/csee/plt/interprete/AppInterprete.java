package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.App;
import edu.handong.csee.plt.exception.CannotEvaluateException;
import edu.handong.csee.plt.exception.FreeVariableException;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.ClosureValue;

public abstract class AppInterprete extends Interprete {
	protected static ValueWithLog functionVwl;
	protected static ValueWithLog functionStrictVwl;

    /**
     * Interpretes the given <code>App</code> AST node into the appropriate <code>ValueWithLog</code> instance.
	 * Threre are three cases using this method: 
	 * 1.<code>App</code> node from Rec node
	 * 2.<code>App</code> node that has <code>ReFun</code> node in its <code>function</code>  
	 * 3.<code>App</code> node that has <code>ValFun</code> node in its <code>function</code>
     * @param interpreter interpreter
     * @param node the <code>App</code> AST node
     * @param variable variable
     * @param memory memory
     * @return the appropriate <code>ValueWithLog</code> instance
	 * @throws InterpreteException
     */
    public ValueWithLog appInterprete(App node, 
									  Variable variable, Memory memory) 
            								throws InterpreteException { 
		if (!checkFunctionType(node.getFunction(), variable, memory)) {
			return null;
		}
        checkArgumentType(node.getArgument());

        int address = getAddress(functionStrictVwl.getMemory(), 
                                 variable, node.getArgument());
		Variable updated = 
                new Variable(((ClosureValue) functionStrictVwl.getValue()).getParameter(), 
                			 address,
                			 ((ClosureValue) functionStrictVwl.getValue()).getVariable());
        ValueWithLog retVwl =  
                new Interpreter().interprete(
                        ((ClosureValue) functionStrictVwl.getValue()).getBody(),
                        updated, 
                        createMemory(address, 
									 node.getArgument(), variable, updated, 
									 functionStrictVwl.getMemory()));
		ValueWithLog retStrictVwl = 
				retVwl.getValue().strict(retVwl.getMemory());

        return new ValueWithLog(retStrictVwl.getValue(), 
                                retStrictVwl.getMemory());  
    }

	/**
	 * Checks whether the type of the given function is appropriate or not.
	 * @param interpreter interpreter
	 * @param variable variable
	 * @param memory memory
	 * @param function function
	 * @return true if the type of the given function is approrpriate, otherwise false
	 * @throws InterpreteException
	 */
	protected abstract boolean checkFunctionType(
			AST function, Variable variable, Memory memory) 
					throws InterpreteException;

    /**
     * Checks whether the type of the given argument is appropriate or not.
	 * Exception will be thrown if the given argument is not an appropriate type.
     * @param argument the argument
     * @throws CannotEvalutateException
     */
    protected abstract void checkArgumentType(AST argument) 
            throws CannotEvaluateException;

    /**
     * Gets the appropriate address for argument.
     * @param memory memory
     * @param variable variable
     * @param argument argument
     * @return the appropriate address
	 * @throws FreeVariableException
     */
    protected abstract int getAddress(Memory memory, 
            Variable variable, AST argument) throws FreeVariableException;
    
    /**
     * Creates the appropriate memory.
	 * @param address address
	 * @param expression expression
	 * @param variable variable
	 * @param updated updated variable
	 * @param memory memory
     * @return the appropriate memory
     */
    protected abstract Memory createMemory(int address, AST expression, 
			Variable variable, Variable updated, Memory memory);
}
