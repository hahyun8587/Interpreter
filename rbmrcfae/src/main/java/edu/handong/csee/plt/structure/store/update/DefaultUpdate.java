package edu.handong.csee.plt.structure.store.update;

import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.NewBox;
import edu.handong.csee.plt.ast.SetBox;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.ExpressionValue;

public class DefaultUpdate extends Update {

    @Override
    public Memory update(ExpressionValue value, AST expression, 
                         Variable variable, Memory old, Memory lazy) {
        value.setMethod(null);

        if (!(expression instanceof NewBox) && !(expression instanceof SetBox)) {
            return old;        
        }
        return null;
    }
}
