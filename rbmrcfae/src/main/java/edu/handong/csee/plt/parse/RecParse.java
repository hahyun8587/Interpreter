package edu.handong.csee.plt.parse;

import java.util.ArrayList;

import edu.handong.csee.plt.Parser;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.Rec;
import edu.handong.csee.plt.exception.ParseException;

public class RecParse extends BindingParse {

    @Override 
    public AST parse(Parser parser, ArrayList<String> subExpressions) 
            throws ParseException, Exception {
        parser.setMethod(new NewBoxParse());

        return bindingParse(parser, subExpressions, "rec");
    }

    @Override 
    protected AST createAST(String id, AST value, AST expression) {
        return new Rec(id, value, expression);
    }
}
