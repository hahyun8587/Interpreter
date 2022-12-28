package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.OpenBox;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.exception.handler.interprete.BoxValueTypeExceptionHandler;
import edu.handong.csee.plt.exception.handler.interprete.ValueTypeExceptionHandler;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.BoxValue;

public class OpenBoxInterprete extends Interprete {
    
    public OpenBoxInterprete() {
        handler = new BoxValueTypeExceptionHandler();
    }

    @Override 
    public ValueWithLog interprete(Interpreter interpreter, 
                                   AST ast, Variable variable, Memory memory)
                                        throws InterpreteException {
        interpreter.setMethod(new SeqnInterprete());

        if (ast instanceof OpenBox) {
            OpenBox node = (OpenBox) ast;
            ValueWithLog boxVwl = 
                    new Interpreter().interprete(node.getBox(), 
                                                 variable, memory);
            ValueWithLog boxStrictVwl = 
                    boxVwl.getValue().strict(boxVwl.getMemory());
            
            System.out.printf("boxValue without strict in OpenBoxInterprete: %s\n", boxStrictVwl.getValue().getASTCode());   
            System.out.printf("memory in OpenBoxInterprete: %s\n", boxStrictVwl.getMemory().getASTCode());                  
            System.out.println(boxStrictVwl.getValue().getASTCode());

            ((ValueTypeExceptionHandler)handler).handleException(boxStrictVwl.getValue(), 
                                                                node.getBox()); 
            
            return new ValueWithLog(
                boxStrictVwl.getMemory().find(
                        ((BoxValue) boxStrictVwl.getValue())
                                                .getAddress()), 
                boxStrictVwl.getMemory());  
        }
        return null;
    }
}
