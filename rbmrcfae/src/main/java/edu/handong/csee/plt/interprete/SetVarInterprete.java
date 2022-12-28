package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.SetVar;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;

public class SetVarInterprete extends Interprete {
    
    @Override 
    public ValueWithLog interprete(Interpreter interpreter,
                                   AST ast, Variable variable, Memory memory) 
                                            throws InterpreteException {
        interpreter.setMethod(null);

        if (ast instanceof SetVar) {
            SetVar node = (SetVar) ast;
            ValueWithLog valueVwl = 
                    new Interpreter().interprete(node.getValue(), 
                                                 variable, memory);
            ValueWithLog valueStrictVwl = 
                    valueVwl.getValue().strict(valueVwl.getMemory());
    
            return new ValueWithLog(
                    valueStrictVwl.getValue(), 
                    new Memory(variable.find(node.getName()),
                               valueStrictVwl.getValue(),
                               valueStrictVwl.getMemory(),
                               valueStrictVwl.getMemory().getMaxAddress()));
        }
        return null;
    }
}
