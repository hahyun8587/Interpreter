package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.OpenBox;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.exception.handler.interprete.BoxValueTypeExceptionHandler;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.BoxValue;
import edu.handong.csee.plt.structure.value.Value;

public class OpenBoxInterprete extends Interprete {
    
    public OpenBoxInterprete() {
        valueTypeExceptionHandler = new BoxValueTypeExceptionHandler();
    }

    @Override 
    public ValueWithLog interprete(Interpreter interpreter, 
                                   AST ast, Variable variable, Memory memory)
                                        throws InterpreteException {
        interpreter.setMethod(new SeqnInterprete());

        if (ast instanceof OpenBox) {
            OpenBox node = (OpenBox) ast;
            ValueWithLog boxVwl = 
                    interpreter.interprete(node.getBox(), 
                                           variable, memory);
            Value boxValue = boxVwl.getValue().strict();                  

            valueTypeExceptionHandler.handleException(boxValue, 
                                                      node.getBox()); 
            
            return new ValueWithLog(
                boxVwl.getMemory().find(((BoxValue) boxValue).getAddress()), 
                boxVwl.getMemory());  
        }
        return null;
    }
}
