package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.Seqn;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.Value;

public class SeqnInterprete extends BinaryInterprete {
    
    @Override
    public ValueWithLog interprete(Interpreter interpreter, 
                                   AST ast, Variable variable, Memory memory) 
                                        throws InterpreteException {
        interpreter.setMethod(new SetVarInterprete());

        if (ast instanceof Seqn) {
            return binaryInterprete(interpreter, 
                                    ((Seqn) ast).getLhs(), 
                                    ((Seqn) ast).getRhs(), 
                                    variable, memory);
        }
        return null;
    }

    @Override 
    protected void checkLhs(Value value, AST ast) {}

    @Override
    protected void checkRhs(Value value, AST ast) {}

    @Override
    protected ValueWithLog createInstance(Value lhsValue, Value rhsValue, 
                                          Memory latest) {
        return new ValueWithLog(rhsValue, latest);
    }
}
