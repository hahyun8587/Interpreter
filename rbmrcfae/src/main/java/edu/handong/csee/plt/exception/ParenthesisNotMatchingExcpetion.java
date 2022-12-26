package edu.handong.csee.plt.exception;

/**
 * Thrown when the parentheses of the given code is not matching.
 */
public class ParenthesisNotMatchingExcpetion extends ParseException {

    public ParenthesisNotMatchingExcpetion(String location) {
        super(location);
    }

    @Override 
    public String getMessage() {
        return "syntax error: parenthesis is not matching in " + location + ".\n";
    }
}
