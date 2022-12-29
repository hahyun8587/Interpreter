package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.ExpressionValue;

public abstract class ValAppInterprete extends AppInterprete {
     
    @Override 
    protected int getAddress(Memory memory, Variable variable, AST argument) {
        return memory == null ? 0 : memory.getMaxAddress() + 1;
    }
    
    @Override 
    protected Memory createMemory(int address, 
                                  AST expression, 
                                  Variable variable, Variable updated, 
                                  Memory memory) {
        return new Memory(createExpressionValue(expression, 
                                                variable, memory, 
                                                updated),
                          memory);
    }

    /**
     * Creates the appropriate <code>ExpressionValue</code> instance.
     * @param expression expression
     * @param variable variable
     * @param memory memory
     * @param updated updated variable
     * @return the appropriate <code>ExpressionValue</code> instance
     */
    protected abstract ExpressionValue createExpressionValue(AST expression, 
			Variable variable, Memory memory, Variable updated);
}
