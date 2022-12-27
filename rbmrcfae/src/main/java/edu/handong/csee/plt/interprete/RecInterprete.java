package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.App;
import edu.handong.csee.plt.ast.Rec;
import edu.handong.csee.plt.ast.ValFun;
import edu.handong.csee.plt.exception.CannotEvaluateException;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.exception.handler.interprete.ASTTypeExceptionHandler;
import edu.handong.csee.plt.exception.handler.interprete.FunTypeExceptionHandler;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.ExpressionValue;

public class RecInterprete extends ValAppInterprete {

    public RecInterprete() {
        handler = new FunTypeExceptionHandler();
    }

    @Override 
    public ValueWithLog interprete(Interpreter interpreter,
                                   AST ast, Variable variable, Memory memory) 
                                   throws InterpreteException {
        interpreter.setMethod(new IfInterprete());

        if (ast instanceof Rec) {
            Rec node = (Rec) ast;

            return appInterprete(interpreter, 
                                 new App(new ValFun(node.getFunctionName(), 
                                                    node.getExpression()), 
                                         node.getFunction()), 
                                 variable, memory); 
        }
        return null;
    }

    @Override 
    protected boolean checkFunctionType(AST function, 
                                        Variable variable, Memory memory) 
                                                throws InterpreteException {
        functionVwl = new Interpreter().interprete(function, variable, memory);
        functionValue = functionVwl.getValue().strict();

        return true;
    }

    @Override 
    protected void checkArgumentType(AST argument) 
            throws CannotEvaluateException {
        ((ASTTypeExceptionHandler) handler).handleException(argument);
    }

    @Override 
    protected ExpressionValue createExpressionValue(AST expression, 
            Variable variable, Memory memory, Variable updated) {
        return new ExpressionValue(expression, updated, memory, null);
    }
}


