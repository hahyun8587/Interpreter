package edu.handong.csee.plt.parse;

import java.util.ArrayList;

import edu.handong.csee.plt.Parser;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.App;
import edu.handong.csee.plt.ast.ValFun;
import edu.handong.csee.plt.exception.ParseException;

public class WithParse extends BindingParse {

    @Override
    public AST parse(Parser parser, ArrayList<String> subExpressions) 
            throws ParseException, Exception {
        parser.setMethod(new ValFunParse());
        
        return bindingParse(parser, subExpressions, "with");
    }

    @Override
    protected AST createAST(String id, AST value, AST expression) {
        return new App(new ValFun(id, expression), value);
    }
}
