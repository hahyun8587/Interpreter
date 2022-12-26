package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.SetVar;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.Value;

public class SetVarInterprete extends Interprete {
    
    @Override 
    public ValueWithLog interprete(Interpreter interpreter,
                                   AST ast, Variable variable, Memory memory) 
                                            throws InterpreteException {
        interpreter.setMethod(null);

        if (ast instanceof SetVar) {
            SetVar node = (SetVar) ast;
            ValueWithLog valueVwl = 
                    interpreter.interprete(node.getValue(), variable, memory);
            Value valueValue = valueVwl.getValue().strict();
    
            return new ValueWithLog(
                    valueValue, 
                    new Memory(variable.find(node.getName()),
                               valueValue,
                               valueVwl.getMemory(),
                               valueVwl.getMemory().getMaxAddress()));
        }
        return null;
    }
}
