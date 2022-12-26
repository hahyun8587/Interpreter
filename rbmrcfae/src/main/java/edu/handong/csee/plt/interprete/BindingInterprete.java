package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.App;
import edu.handong.csee.plt.ast.Id;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.exception.handler.interprete.ClosureValueTypeExceptionHandler;
import edu.handong.csee.plt.exception.handler.interprete.IdTypeExceptionHandler;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.ClosureValue;
import edu.handong.csee.plt.structure.value.ExpressionValue;
import edu.handong.csee.plt.structure.value.RefClosureValue;
import edu.handong.csee.plt.structure.value.ValClosureValue;
import edu.handong.csee.plt.structure.value.Value;

public abstract class BindingInterprete extends Interprete {
    
    public BindingInterprete() {
        valueTypeExceptionHandler = new ClosureValueTypeExceptionHandler();
    }

    public ValueWithLog bindingInterprete(Interpreter interpreter, 
			App node, Variable variable, Memory memory) 
            		throws InterpreteException {
        ValueWithLog functionVwl = 
                interpreter.interprete(node.getFunction(), 
                                       variable, memory);
		
		//System.out.println("functionVwl in bindingInterprete: " + functionVwl.getASTCode());

        Value functionValue = functionVwl.getValue().strict(); 

		//System.out.println("function strict value in bindingInterprete: " + functionValue.getASTCode());

        valueTypeExceptionHandler.handleException(functionValue, 
                                                  node.getFunction()); 
        
        if (functionValue instanceof RefClosureValue) {
            new IdTypeExceptionHandler().handleException(
                    node.getArgument());
        }

        int address = 0; 
		int maxAddress = 0;

		if (functionVwl.getMemory() == null) {
			address = 0;
			maxAddress = 0;
		} else {
			if (functionValue instanceof ValClosureValue) {
				maxAddress = address = 
						functionVwl.getMemory().getMaxAddress() + 1;
			}
			else {
				address = variable.find(((Id) node.getArgument())
							  				  	  .getName());
			    maxAddress = functionVwl.getMemory().getMaxAddress();
			}
		}
		 
		//System.out.printf("new address in bindingInterprete: %d\n", address);

        Variable updated = 
                new Variable(((ClosureValue) functionValue).getParameter(),
                             address,
                             ((ClosureValue) functionValue).getVariable());
		/** 
		System.out.printf("updated variable in bindingInterprete: %s\n", updated.getASTCode());
        
		Memory updatedm = new Memory(address, 
									createExpressionValue(node.getArgument(),
														variable, 
														functionVwl.getMemory(), 
														updated), 
									functionVwl.getMemory(),
									maxAddress);
		
		System.out.printf("udpated memory in bindingInterprte: %s\n", updatedm.getASTCode());
        **/
        ValueWithLog retVwl = 
                interpreter.interprete(
                        ((ClosureValue) functionValue).getBody(), 
                        updated,
                        new Memory(address, 
                                   createExpressionValue(node.getArgument(),
                                                         variable, 
                                                         functionVwl.getMemory(), 
                                                         updated), 
                                   functionVwl.getMemory(),
                                   maxAddress));
	

        return new ValueWithLog(retVwl.getValue().strict(), 
                                retVwl.getMemory());  
    }

    /**
     * Creates the appropriate <code>ExpressionValue</code> instance.
     */
    protected abstract ExpressionValue createExpressionValue(AST expression, 
			Variable variable, Memory memory, Variable updated);

}
