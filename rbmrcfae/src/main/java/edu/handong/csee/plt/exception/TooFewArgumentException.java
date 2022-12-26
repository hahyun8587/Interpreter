package edu.handong.csee.plt.exception;

/**
 * Thrown when the given experssion has too few arguments.
 */
public class TooFewArgumentException extends ParseException {
    
    public TooFewArgumentException(String location) {
        super(location);
    }

    @Override 
    public String getMessage() {
        return "syntax error: too few arguments in " + location + " expression.\n";
    }
}
