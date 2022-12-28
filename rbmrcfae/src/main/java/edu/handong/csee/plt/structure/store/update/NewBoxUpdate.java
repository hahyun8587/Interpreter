package edu.handong.csee.plt.structure.store.update;

import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.NewBox;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.exception.MemoryNotAllocatedException;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.BoxValue;
import edu.handong.csee.plt.structure.value.ExpressionValue;

public class NewBoxUpdate extends Update {
    
    @Override 
    public Memory update(ExpressionValue value, AST expression, 
                         Variable variable, Memory old, Memory lazy) 
                                throws MemoryNotAllocatedException, InterpreteException {
        value.setMethod(new SetBoxUpdate());

        if (expression instanceof NewBox) {
            int address = ((BoxValue) value.getValue()).getAddress();
            
            ((BoxValue) value.getValue()).setAddress(old.getMaxAddress() + 1);
            
            return new Memory(old.getMaxAddress() + 1, 
                              lazy.find(address), 
                              old, 
                              old.getMaxAddress() + 1);
        }
        return null;
    }
}
