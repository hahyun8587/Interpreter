package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.Id;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;

public class IdInterprete extends Interprete {

    @Override 
    public ValueWithLog interprete(Interpreter interpreter, 
                                   AST ast, Variable variable, Memory memory) {
        
        interpreter.setMethod(new FunInterprete());

        if (ast instanceof Id) {
            return new ValueWithLog(
                    memory.find(variable.find(((Id) ast).getName())), 
                    memory);
        }
        return null;
    }
}
