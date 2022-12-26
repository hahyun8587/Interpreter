package edu.handong.csee.plt;

import edu.handong.csee.plt.ast.AST;
import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.exception.InvalidASTException;
import edu.handong.csee.plt.interprete.Interprete;
import edu.handong.csee.plt.interprete.NumInterprete;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;
import edu.handong.csee.plt.structure.store.Variable;

public class Interpreter {
	private Interprete method;

	public ValueWithLog interprete(AST ast, Variable variable, Memory memory) 
			throws InterpreteException {
		method = new NumInterprete();

		while (method != null) {
			ValueWithLog vwl = method.interprete(this, ast, variable, memory);

			if (vwl != null) {
				return vwl;
			}
		}
		throw new InvalidASTException(ast);
	}

	public void setMethod(Interprete method) {
		this.method = method;
	}
}
