package edu.handong.csee.plt.ast;

/**
 * Class that generalizes binary operation AST nodes.
 */
public abstract class Binary extends AST {
    public static int numChild = 2;
    private AST lhs;
    private AST rhs;

    public Binary(AST lhs, AST rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public AST getLhs() {
        return lhs;
    }

    public AST getRhs() {
        return rhs;
    }

    /**
     * Gets AST code of binary node
     * @param node the name of the binary node 
     * @return the AST code of the binary node
     */
    public String getBinaryASTCode(String node) {
        return "(" + node + " " + lhs.getASTCode() + " " + rhs.getASTCode() + ")";
    }
}
