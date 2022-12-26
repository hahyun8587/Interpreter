package edu.handong.csee.plt.ast;

public class SetBox extends Binary {
   
    public SetBox(AST box, AST value) {
        super(box, value);
    }

    @Override
    public String getASTCode() {
        return getBinaryASTCode("setbox");
    } 
}
