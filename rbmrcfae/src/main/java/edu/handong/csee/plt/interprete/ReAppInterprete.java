package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.App;
import edu.handong.csee.plt.ast.Id;
import edu.handong.csee.plt.exception.CannotEvaluateException;
import edu.handong.csee.plt.exception.FreeVariableException;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.exception.handler.interprete.ASTTypeExceptionHandler;
import edu.handong.csee.plt.exception.handler.interprete.IdTypeExceptionHandler;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.RefClosureValue;

public class ReAppInterprete extends AppInterprete {

    public ReAppInterprete() {
        handler = new IdTypeExceptionHandler();
    }
    
    @Override 
    public ValueWithLog interprete(Interpreter interpreter, 
                                   AST ast, Variable variable, Memory memory) 
                                        throws InterpreteException {
        interpreter.setMethod(new RecInterprete());

        if (ast instanceof App) {
            return appInterprete((App) ast, variable, memory);
        }
        return null;
    }

    @Override 
    protected boolean checkFunctionType(AST function, 
                                        Variable variable, Memory memory) 
                                                throws InterpreteException {
        System.out.println("value of functionStrictVwl :" + functionStrictVwl.getValue().getASTCode());
        return functionStrictVwl.getValue() instanceof RefClosureValue; 
    }

    @Override 
    protected void checkArgumentType(AST argument) 
            throws CannotEvaluateException {
        ((ASTTypeExceptionHandler) handler).handleException(argument);
    }

    @Override 
    protected int getAddress(Memory memory, Variable variable, AST argument) 
            throws FreeVariableException {
        if (variable == null) {
            throw new FreeVariableException(((Id) argument).getName());
        }
        return variable.find(((Id) argument).getName());
    }

    @Override 
    protected Memory createMemory(int address, AST expression, 
            Variable variable, Variable updated, Memory memory) {
        return memory;
    }
}
