package edu.handong.csee.plt.parse;

import java.util.ArrayList;

import edu.handong.csee.plt.Parser;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.ParseException;

public class OpenBoxParse extends UnaryParse {

    @Override
    public AST parse(Parser parser, ArrayList<String> subExpressions) 
            throws ParseException, Exception {
        parser.setMethod(new SeqnParse());
        
        return unaryParse(parser, subExpressions, "openbox", "OpenBox");
    }
}
