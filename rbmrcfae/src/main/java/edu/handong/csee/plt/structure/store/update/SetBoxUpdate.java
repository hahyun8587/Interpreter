package edu.handong.csee.plt.structure.store.update;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.SetBox;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.exception.handler.interprete.BoxValueTypeExceptionHandler;
import edu.handong.csee.plt.exception.handler.interprete.ValueTypeExceptionHandler;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.BoxValue;
import edu.handong.csee.plt.structure.value.ExpressionValue;

public class SetBoxUpdate extends Update {
    
    public SetBoxUpdate(){
        handler = new BoxValueTypeExceptionHandler();
    }

    @Override
    public Memory update(ExpressionValue value, AST expression,
                         Variable variable, Memory old, Memory lazy) 
                                throws InterpreteException {
        value.setMethod(new DefaultUpdate());

        if (expression instanceof SetBox) {
            ValueWithLog boxVwl = 
                    new Interpreter().interprete(((SetBox) expression).getLhs(), 
                                                 variable, value.getMemory());
            ValueWithLog strictVwl = 
                    boxVwl.getValue().strict(lazy);

            ((ValueTypeExceptionHandler) handler).handleException(strictVwl.getValue(), 
                                                                  expression);

            int address = ((BoxValue) strictVwl.getValue()).getAddress();

            return new Memory(address, lazy.find(address), 
                              old, old.getMaxAddress() + 1);
        }
        return null;
    }
}
