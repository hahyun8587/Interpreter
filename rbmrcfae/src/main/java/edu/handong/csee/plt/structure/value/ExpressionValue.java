package edu.handong.csee.plt.structure.value;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.util.Option;

public class ExpressionValue extends Value {
    private AST expression;
    private Variable variable;
    private Memory memory;
    private Value value;

    public ExpressionValue(AST expression, Variable variable, Memory memory, Value value) {
        this.expression = expression;
        this.variable = variable;
        this.memory = memory;
        this.value = value;
    }

    @Override
    public ValueWithLog strict(Memory global) throws InterpreteException {
        if (value != null) {
            return new ValueWithLog(value, global);
        }
        
        ValueWithLog expressionVwl, strictVwl;
        int numAdded;
        int memorySize, updatedSize; 
        Memory updated;
 
        expressionVwl 
                = new Interpreter().interprete(expression, variable, memory);
        memorySize = memory == null ? 0 : memory.size();
        updatedSize = 
                expressionVwl.getMemory() == null 
                        ? 0 : expressionVwl.getMemory().size();
        numAdded = updatedSize - memorySize;
        
        if (numAdded == 0) {
            updated = global;
        } else {
            Memory last;

            updated = expressionVwl.getMemory();
            last = updated;

            for (int i = 1; i <= numAdded - 1; i++) {
                last = last.getNext();
            }
            last.setNext(global);
        }
        strictVwl = expressionVwl.getValue().strict(updated);  
        value = strictVwl.getValue();

        return new ValueWithLog(strictVwl.getValue(), strictVwl.getMemory());
    }

    public Memory getMemory() {
        return memory;
    }

    public Value getValue() {
        return value;
    }
    
    @Override 
    public String getASTCode() throws InterpreteException {
        if (Option.UnwrapExpressionValue) {
            return value == null 
                    ? new Interpreter().interprete(expression, variable, memory)
                                       .getValue()
                                       .getASTCode() 
                    : value.getASTCode();
        } else {
            return "(exprV " + expression.getASTCode() + " " 
                   + (variable == null ? "(mtSub)" : variable.getASTCode()) 
                   + ")";
        }
        
    }
}
