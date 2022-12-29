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
	protected static ValueWithLog functionStrictVwl;

    /**
     * <p>Interpretes the given <code>App</code> AST node into the appropriate <code>ValueWithLog</code> instance.</p>
	 * <p>Threre are three cases using this method:</p> 
	 * <p>Case 1: <code>App</code> node from <code>Rec</code> node</p>
	 * <p>Case 2: <code>App</code> node that has <code>ValFun</code> node in its <code>function</code></p>  
	 * <p>Case 3: <code>App</code> node that has <code>ReFun</code> node in its <code>function</code></p>
     * @param interpreter interpreter
     * @param node the <code>App</code> AST node
     * @param variable variable
     * @param memory memory
     * @return the appropriate <code>ValueWithLog</code> instance
	 * @throws InterpreteException
     */
    public ValueWithLog appInterprete(App node, Variable variable) 
            								throws InterpreteException {
        checkArgumentType(node.getArgument()); 

		int address = getAddress(functionStrictVwl.getMemory(), 
								 variable, node.getArgument());
		Variable updated = 
                new Variable(
						((ClosureValue) functionStrictVwl.getValue()).getParameter(), 
                		address,
                		((ClosureValue) functionStrictVwl.getValue()).getVariable());
        ValueWithLog retVwl =  
                new Interpreter().interprete(
                        ((ClosureValue) functionStrictVwl.getValue()).getBody(),
                        updated, 
                        createMemory(address, 
									 node.getArgument(), variable, updated, 
									 functionStrictVwl.getMemory()));

		return retVwl.getValue().strict(retVwl.getMemory());
    }
        
    /**
     * Checks whether the type of the given argument is appropriate or not.
	 * Exception will be thrown if the given argument is not an appropriate type.
     * @param argument the argument
     * @throws CannotEvalutateException
     */
    protected abstract void checkArgumentType(AST argument) 
            throws CannotEvaluateException;

    /**
     * <p>Gets the appropriate address for argument.</p>
	 * <p>Case 1: <code>App</code> node from <code>Rec</code> node uses <code>memory</code> to get the max address.</p>
	 * <p>Case 2: <code>App</code> node that has <code>ValFun</code> node uses <code>memory</code> to get the max address.</p>
	 * <p>Case 3: <code>App</code> node that has <code>ReFun</code> node uses <code>variable</code> and <code>argument</code> to get the same address as <code>argument</code>.</p> 
	 * @param memory memory
     * @param variable variable
     * @param argument argument
     * @return the appropriate address
	 * @throws FreeVariableException
     */
    protected abstract int getAddress(Memory memory, Variable variable, AST argument) 
			throws FreeVariableException;
    
    /**
     * <p>Creates the appropriate memory.</p>
	 * <p><code>address</code> and <code>memory</code> are for creating new <code>memory</code> instance.</p>
	 * <p><code>expression</code>, <code>variable</code>, and <code>updated</code> is for creating new <code>ExpressionValue</code> inside the new <code>memory</code> instance.</p>
	 * <p>Case 1: <code>App</code> node from <code>Rec</code> node uses <code>updated</code> for infinite function access.</p>
	 * <p>Case 2: <code>App</code> node that has <code>ValFun</code> node uses <code>variable</code> for later expression interpretation.</p>
	 * <p>Case 3: <code>App</code> node that has <code>ReFun</code> node simply returns <code>memory</code> since the address of the parameter is same as the address of the passing argument.</p>
	 * @param address address
	 * @param expression expression 
	 * @param variable variable
	 * @param updated updated variable that has bounded parameter with its address
	 * @param memory memory
     * @return the appropriate memory
     */
    protected abstract Memory createMemory(int address, AST expression, 
			Variable variable, Variable updated, Memory memory);
}
