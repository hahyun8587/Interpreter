package edu.handong.csee.plt.ast;

public class App extends AST {
    public static int numChild = 2;
    private AST function;
    private AST argument;

    public App(AST function, AST argument) {
        this.function = function;
        this.argument = argument;
    }

    public AST getFunction() {
        return function;
    }

    public AST getArgument() {
        return argument;
    }

    @Override
    public String getASTCode() {
        return "(app " + function.getASTCode() + " " + argument.getASTCode() + ")";
    }
}
