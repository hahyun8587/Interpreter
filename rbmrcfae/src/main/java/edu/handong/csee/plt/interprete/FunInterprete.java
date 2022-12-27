package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.ReFun;
import edu.handong.csee.plt.ast.ValFun;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.RefClosureValue;
import edu.handong.csee.plt.structure.value.ValClosureValue;

public class FunInterprete extends Interprete {
    
    @Override
    public ValueWithLog interprete(Interpreter interpreter, 
                                   AST ast, Variable variable, Memory memory) {
        interpreter.setMethod(new DefaultAppInterprete());

        if (ast instanceof ValFun) {
            return new ValueWithLog(
                    new ValClosureValue(((ValFun) ast).getParameter(),
                                        ((ValFun) ast).getBody(), 
                                        variable), 
                    memory);
        } else if (ast instanceof ReFun) {
            return new ValueWithLog(
                    new RefClosureValue(((ReFun) ast).getParameter(),
                                        ((ReFun) ast).getBody(), 
                                        variable), 
                    memory);
        }
        return null;
    }
}
