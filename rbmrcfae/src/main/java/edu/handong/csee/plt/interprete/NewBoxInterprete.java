package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.NewBox;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.BoxValue;

public class NewBoxInterprete extends Interprete {
    
    @Override 
    public ValueWithLog interprete(Interpreter interpreter, 
                                   AST ast, Variable variable, Memory memory) 
                                            throws InterpreteException {
        interpreter.setMethod(new SetBoxInterprete());
        
        if (ast instanceof NewBox) {
            NewBox node = (NewBox) ast;
            ValueWithLog valueVwl = 
                    new Interpreter().interprete(node.getValue(), 
                                                 variable, memory);
            ValueWithLog valueStrictVwl = 
                    valueVwl.getValue().strict(valueVwl.getMemory());
            
            /** 
            int address = 
                    valueStrictVwl.getMemory() == null 
                        ? 0 : valueVwl.getMemory().getMaxAddress() + 1;
            **/

            Memory updated = new Memory(valueStrictVwl.getValue(), 
                                        valueStrictVwl.getMemory());

            return new ValueWithLog(new BoxValue(updated.getMaxAddress()), 
                                    updated);
        }
        return null;
    }
}
