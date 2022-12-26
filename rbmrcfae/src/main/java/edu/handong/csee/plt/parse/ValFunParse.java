package edu.handong.csee.plt.parse;

import java.util.ArrayList;

import edu.handong.csee.plt.Parser;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.ValFun;
import edu.handong.csee.plt.exception.ParseException;

public class ValFunParse extends FunParse {
    
    @Override
    public AST parse(Parser parser, ArrayList<String> subExrpessions) 
            throws ParseException, Exception {
        parser.setMethod(new ReFunParse());

        return funParse(parser, subExrpessions, "fun");
    }

    @Override 
    protected AST createAST(String parameter, AST body) {
        return new ValFun(parameter, body);
    }
}
