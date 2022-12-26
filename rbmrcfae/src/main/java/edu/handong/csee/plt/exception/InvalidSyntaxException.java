package edu.handong.csee.plt.exception;

/**
 * Thrown when the given expression is has an invalid syntax.
 */
public class InvalidSyntaxException extends ParseException {
    
    public InvalidSyntaxException(String location) {
        super(location);
    }

    @Override
    public String getMessage() {
        return "syntax error: invalid syntax in " + location + ".\n";
    }
}
