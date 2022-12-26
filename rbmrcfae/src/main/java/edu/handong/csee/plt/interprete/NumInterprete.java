package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.Num;
import edu.handong.csee.plt.exception.CannotEvaluateException;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.NumberValue;

public class NumInterprete extends Interprete {
    
    @Override 
    public ValueWithLog interprete(Interpreter interpreter, 
                                   AST ast, Variable variable, Memory memory) 
                                        throws CannotEvaluateException {
        interpreter.setMethod(new AddInterprete());
        
        if (ast instanceof Num) {
            return new ValueWithLog(
                    new NumberValue(Integer.parseInt(((Num) ast).getStrNum())), 
                    memory);
        }
        return null;
    }
}
