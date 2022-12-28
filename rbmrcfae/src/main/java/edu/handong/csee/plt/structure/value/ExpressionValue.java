package edu.handong.csee.plt.structure.value;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.store.update.NewBoxUpdate;
import edu.handong.csee.plt.structure.store.update.Update;
import edu.handong.csee.plt.util.Option;

public class ExpressionValue extends Value {
    private AST expression;
    private Variable variable;
    private Memory memory;
    private Value value;
    private Update method = new NewBoxUpdate();

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

        ValueWithLog expressionVwl 
                = new Interpreter().interprete(expression, variable, memory);
          
      

        /** 
        ValueWithLog strictVwl = 
                expressionVwl.getValue().strict(global);
        **/
        value = expressionVwl.getValue();
        
        Memory updated = null;

        while (method != null) {
            updated = 
                    method.update(this, expression, 
                                  variable, 
                                  global, expressionVwl.getMemory());

            if (updated != null) {
                break;
            }
        }
        return new ValueWithLog(value, updated);
    }

    public void setMethod(Update method) {
        this.method = method; 
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
