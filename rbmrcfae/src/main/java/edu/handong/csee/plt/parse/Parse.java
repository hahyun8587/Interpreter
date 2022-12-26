package edu.handong.csee.plt.parse;

import java.util.ArrayList;

import edu.handong.csee.plt.Parser;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.ParseException;
import edu.handong.csee.plt.exception.handler.parse.ArgumentExceptionHandler;
import edu.handong.csee.plt.exception.handler.parse.TypeExceptionHandler;

/**
 * Class that represents parsing methods.
 */
public abstract class Parse {
    protected ArgumentExceptionHandler argExceptionHandler;
    protected TypeExceptionHandler typeExceptionHandler;

    /**
     * Parses the given subexpressions to the appropriate AST node.
     * @param parser parser
     * @param subExpressions subexpressions 
     * @return AST node if the given subexpressions can be represented by AST node, otherwise null
     * @throws ParseException
     * @throws Exception
     */
    public abstract AST parse(Parser parser, ArrayList<String> subExpressions)
            throws ParseException, Exception;
}
