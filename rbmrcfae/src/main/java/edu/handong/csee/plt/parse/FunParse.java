package edu.handong.csee.plt.parse;

import java.util.ArrayList;

import edu.handong.csee.plt.Parser;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.Fun;
import edu.handong.csee.plt.exception.ParseException;
import edu.handong.csee.plt.exception.handler.parse.AlphabeticTypeExceptionHandler;
import edu.handong.csee.plt.exception.handler.parse.ExactArgumentExceptionHandler;

public abstract class FunParse extends Parse {
    private final int OPERATOR = 0;
    private final int PARAMETER = 1;
    private final int BODY = 2;

    private final int ID = 0;

    public FunParse() {
        argExceptionHandler = new ExactArgumentExceptionHandler();
        typeExceptionHandler = new AlphabeticTypeExceptionHandler();
    } 

    /**
     * Parses fun exrpession into appropriate AST node.
     * @param parser parser
     * @param subExpressions sub expresssions
     * @param operator fun operator
     * @return the approprate AST node
     */
    public AST funParse(Parser parser, 
                        ArrayList<String> subExpressions, String operator)
                                throws ParseException, Exception {
        if (subExpressions.get(OPERATOR).equals(operator)) {
            argExceptionHandler.handleException(subExpressions.size() - 1, 
                                                Fun.numChild, 
                                                operator);

            ArrayList<String> firstSubExpressions = 
                    parser.splitExpressionAsSubExpressions(
                            subExpressions.get(PARAMETER));
            
            typeExceptionHandler.handleException(firstSubExpressions.get(ID), 
                                                 operator);
            argExceptionHandler.handleException(firstSubExpressions.size(), 
                                                1, 
                                                operator);

            return createAST(firstSubExpressions.get(ID), 
                             parser.parse(subExpressions.get(BODY)));
        }
        return null;
    }

    /**
     * Creates function AST node with the given parameter and body.
     * @param parameter parameter
     * @param body body
     * @return the function AST node
     */
    protected abstract AST createAST(String parameter, AST body);
}
