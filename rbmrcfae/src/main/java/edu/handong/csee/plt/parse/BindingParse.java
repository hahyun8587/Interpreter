package edu.handong.csee.plt.parse;

import java.util.ArrayList;

import edu.handong.csee.plt.Parser;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.ParseException;
import edu.handong.csee.plt.exception.handler.parse.AlphabeticTypeExceptionHandler;
import edu.handong.csee.plt.exception.handler.parse.ExactArgumentExceptionHandler;

public abstract class BindingParse extends Parse {
    private static int OPERATOR = 0;
    private static int BINDING_EXPRESSION = 1;
    private static int EXPRESSION = 2;
    private static int ID = 0;
    private static int VALUE = 1;
    
    private int numChild = 2;

    public BindingParse() {
        argExceptionHandler = new ExactArgumentExceptionHandler();
        typeExceptionHandler = new AlphabeticTypeExceptionHandler();
    }

    public AST bindingParse(Parser parser, 
                            ArrayList<String> subExpressions, String operator) 
                                    throws ParseException, Exception {
        if (subExpressions.get(OPERATOR).equals(operator)) {
            argExceptionHandler.handleException(subExpressions.size() - 1, 
                                                numChild, 
                                                operator);
            
            ArrayList<String> firstSubExpressions = 
                    parser.splitExpressionAsSubExpressions(
                            subExpressions.get(BINDING_EXPRESSION));
            
            typeExceptionHandler.handleException(firstSubExpressions.get(ID), 
                                                 operator);
            argExceptionHandler.handleException(firstSubExpressions.size(), 
                                                numChild,
                                                operator);

            return createAST(firstSubExpressions.get(ID),
                            parser.parse(firstSubExpressions.get(VALUE)), 
                            parser.parse(subExpressions.get(EXPRESSION))); 
        } 
        return null;   
    }

    protected abstract AST createAST(String id, AST value, AST expression); 
}
