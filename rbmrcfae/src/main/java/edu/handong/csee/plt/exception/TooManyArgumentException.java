package edu.handong.csee.plt.exception;

/**
 * Thrown when the given expression has too many arguments.
 */
public class TooManyArgumentException extends ParseException {
    
    public TooManyArgumentException(String location) {
        super(location);
    }

    @Override
    public String getMessage() {
        return "syntax error: too many arguments in " + location + " expression.\n";
    }
}
