package edu.handong.csee.plt.parse;

import java.util.ArrayList;

import edu.handong.csee.plt.Parser;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.ParseException;
import edu.handong.csee.plt.exception.handler.parse.ExactArgumentExceptionHandler;

public abstract class BinaryParse extends Parse {
    private final int OPERATOR = 0;
    private final int LHS = 1;
    private final int RHS = 2; 

    public BinaryParse() {        
        argExceptionHandler = new ExactArgumentExceptionHandler();
    }

    /**
     * Parses the given binary sub expressions into the appropriate AST node.
     * @param parser parser 
     * @param subExpressions binary sub expressions
     * @param operator the operator in the given sub expressions 
     * @param node the name of the appropriate AST node to be parsed to.
     * @return the AST node  
     * @throws ParseException
     * @throws Exception
     */
    protected AST binaryParse(Parser parser, ArrayList<String> subExpressions,
                              String operator, String node) 
                                    throws ParseException, 
                                           Exception {
        if (subExpressions.get(OPERATOR).equals(operator)) {
            argExceptionHandler.handleException(
                    subExpressions.size() - 1, 
                    (int) Class.forName("edu.handong.csee.plt.ast." + node)
                                .getField("numChild")
                                .get(null), 
                    node.toLowerCase());
                    
            return (AST) Class.forName("edu.handong.csee.plt.ast." + node)
                              .getConstructor(AST.class, AST.class)
                              .newInstance(
                                    parser.parse(subExpressions.get(LHS)), 
                                    parser.parse(subExpressions.get(RHS))); 
        }
        return null;
    }
}
