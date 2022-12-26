package edu.handong.csee.plt.parse;

import java.util.ArrayList;

import edu.handong.csee.plt.Parser;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.SetVar;
import edu.handong.csee.plt.exception.ParseException;
import edu.handong.csee.plt.exception.handler.parse.AlphabeticTypeExceptionHandler;
import edu.handong.csee.plt.exception.handler.parse.ExactArgumentExceptionHandler;

public class SetVarParse extends Parse {
    private final int OPERATOR = 0;
    private final int ID = 1;
    private final int VALUE = 2;

    public SetVarParse() {
        argExceptionHandler = new ExactArgumentExceptionHandler();
        typeExceptionHandler = new AlphabeticTypeExceptionHandler();
    }

    @Override 
    public AST parse(Parser parser, ArrayList<String> subExpressions) 
            throws ParseException, Exception {
        parser.setMethod(new AppParse());

        if (subExpressions.get(OPERATOR).equals("setvar")) {
            argExceptionHandler.handleException(subExpressions.size() - 1, 
                                                SetVar.numChild, 
                                                "setvar");
            typeExceptionHandler.handleException(subExpressions.get(ID), 
                                                 "setvar");

            return new SetVar(subExpressions.get(ID), 
                              parser.parse(subExpressions.get(VALUE)));
        }
        return null;
    }
}
