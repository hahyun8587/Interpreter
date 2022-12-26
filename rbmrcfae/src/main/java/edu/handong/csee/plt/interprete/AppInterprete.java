package edu.handong.csee.plt.interprete;

import edu.handong.csee.plt.Interpreter;
import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.ast.App;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;
import edu.handong.csee.plt.structure.value.ExpressionValue;

public class AppInterprete extends BindingInterprete {

    @Override 
    public ValueWithLog interprete(Interpreter interpreter, 
								   AST ast, Variable variable, Memory memory) 
            							throws InterpreteException {
		interpreter.setMethod(new IfInterprete());

		if (ast instanceof App) {
			return bindingInterprete(interpreter, (App) ast, variable, memory);
		}			
		return null;
    }

	@Override
	protected ExpressionValue createExpressionValue(AST expression, 
			Variable variable, Memory memory, Variable updated) {
		return new ExpressionValue(expression, variable, memory, null);
	}
}
