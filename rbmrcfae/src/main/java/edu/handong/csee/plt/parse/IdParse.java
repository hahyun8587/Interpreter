package edu.handong.csee.plt.parse;

import java.util.ArrayList;

import edu.handong.csee.plt.Parser;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.Id;
import edu.handong.csee.plt.ast.Num;
import edu.handong.csee.plt.exception.TooFewArgumentException;
import edu.handong.csee.plt.exception.TooManyArgumentException;

public class IdParse extends Parse {
    private final int NAME = 0;
    
    @Override
    public AST parse(Parser parser, ArrayList<String> subExpressions) 
            throws TooFewArgumentException, TooManyArgumentException {
        parser.setMethod(new WithParse());
        
        if (subExpressions.size() == 1) {
            if (Parser.isAlphabetic(subExpressions.get(NAME))) {
                return new Id(subExpressions.get(NAME));
            } else {
                if (subExpressions.get(NAME).equals("#t")) {
                    return new Num("1");
                } else if (subExpressions.get(NAME).equals("#f")) {
                    return new Num("0");
                }
            }
        }
        return null;
    }
}
