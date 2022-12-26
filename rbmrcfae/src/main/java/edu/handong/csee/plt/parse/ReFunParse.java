package edu.handong.csee.plt.parse;

import java.util.ArrayList;

import edu.handong.csee.plt.Parser;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.ReFun;
import edu.handong.csee.plt.exception.ParseException;

public class ReFunParse extends FunParse {
    
    @Override
    public AST parse(Parser parser, ArrayList<String> subExpressions) 
            throws ParseException, Exception {
        parser.setMethod(new IfParse());
        
        return funParse(parser, subExpressions, "refun");
    }    

    @Override 
    protected AST createAST(String parameter, AST body) {
        return new ReFun(parameter, body);
    }
}
