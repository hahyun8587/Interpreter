package edu.handong.csee.plt.ast;

public class Num extends AST {
	public static int numChild = 1;
	private String num;

	public Num(String num){
		this.num = num;
	}

	public String getStrNum() {
		return num;
	}
	
	@Override
	public String getASTCode() {
		return "(num " + num + ")";
	}
}
