package edu.handong.csee.plt.ast;

public class Add extends Binary{
	
	public Add(AST lhs, AST rhs) {
		super(lhs, rhs);
	}

	@Override
	public String getASTCode() {
		return getBinaryASTCode("add");
	}
}

