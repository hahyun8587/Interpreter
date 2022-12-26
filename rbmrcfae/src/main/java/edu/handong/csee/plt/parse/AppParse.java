package edu.handong.csee.plt.parse;

import java.util.ArrayList;

import edu.handong.csee.plt.Parser;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.App;
import edu.handong.csee.plt.exception.ParseException;

public class AppParse extends Parse {
    private final int FUNCTION = 0;
    private final int ARGUMENT = 1;  

    @Override
    public AST parse(Parser parser, ArrayList<String> subExpressions) 
        throws ParseException, Exception {
        parser.setMethod(null);

        if ((Parser.isAlphabetic(subExpressions.get(FUNCTION)) 
                || Parser.isExpression(subExpressions.get(FUNCTION))) 
                        && (subExpressions.size() == 2)) {
            return new App(parser.parse(subExpressions.get(FUNCTION)), 
                           parser.parse(subExpressions.get(ARGUMENT))); 
        }
        return null;
    }
}
