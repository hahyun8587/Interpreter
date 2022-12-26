package edu.handong.csee.plt.parse;

import java.util.ArrayList;

import edu.handong.csee.plt.Parser;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.Num;
import edu.handong.csee.plt.exception.TooFewArgumentException;
import edu.handong.csee.plt.exception.TooManyArgumentException;
import edu.handong.csee.plt.exception.handler.parse.ExactArgumentExceptionHandler;

public class NumParse extends Parse {
    private final int NUMBER = 0;

    public NumParse() {
        argExceptionHandler = new ExactArgumentExceptionHandler();
    }

    @Override 
    public AST parse(Parser parser, ArrayList<String> subExpressions) 
            throws TooFewArgumentException, TooManyArgumentException {
        parser.setMethod(new AddParse());

        if (Parser.isNumeric(subExpressions.get(NUMBER))) {
            argExceptionHandler.handleException(subExpressions.size(), 
                                                Num.numChild, 
                                                "num");

            return new Num(subExpressions.get(NUMBER));
        }
        return null;
    }
}
