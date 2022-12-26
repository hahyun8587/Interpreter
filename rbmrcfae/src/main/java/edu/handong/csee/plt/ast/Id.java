package edu.handong.csee.plt.ast;

public class Id extends AST {
    public static int numChild = 1;
    private String name;

    public Id(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getASTCode() {
        return "(id '" + name + ")";
    }
}
