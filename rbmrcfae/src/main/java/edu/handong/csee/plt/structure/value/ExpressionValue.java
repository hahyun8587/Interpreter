package edu.handong.csee.plt.structure.value;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.util.Option;

public class ExpressionValue extends Value {
    private AST expression;
    private Variable variable;
    private Memory memory;
    private Value value;
    private Interpreter interpreter = new Interpreter();

    public ExpressionValue(AST expression, Variable variable, Memory memory, Value value) {
        this.expression = expression;
        this.variable = variable;
        this.memory = memory;
        this.value = value;
    }

    @Override
    public Value strict() throws InterpreteException {
        if (value != null) {
            return value;
        }
        return value = interpreter.interprete(expression, variable, memory)
                                  .getValue()
                                  .strict();
    }

    @Override 
    public String getASTCode() throws InterpreteException {
        if (Option.UnwrapExpressionValue) {
            return value == null 
                    ? interpreter.interprete(expression, variable, memory)
                                .getValue()
                                .getASTCode() 
                    : value.getASTCode();
        } else {
            return "(exprV " + expression.getASTCode() + " " 
                   + (variable == null ? "(mtSub)" : variable.getASTCode()) 
                   + ")";
        }
        
    }
}
