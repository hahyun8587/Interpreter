package edu.handong.csee.plt.ast;

public abstract class AST {
	public static int numChild;
	
	public abstract String getASTCode();

	/* 
	public String getASTCode() {
		String astCode="";
		if(this instanceof Add)
			astCode = ((Add)this).getASTCode();
		
		if(this instanceof Num)
			astCode = ((Num)this).getASTCode();

		return astCode;
	}
	*/
}

