package edu.handong.csee.plt.exception;

/**
 * Thrown when the type of the given expression's argument is not the expected type.
 */
public class TypeMismatchException extends ParseException {
    
    public TypeMismatchException(String location) {
        super(location);
    }

    @Override
    public String getMessage() {
        return "type error: type mismatch in " + location + " expression.\n";
    }
}
