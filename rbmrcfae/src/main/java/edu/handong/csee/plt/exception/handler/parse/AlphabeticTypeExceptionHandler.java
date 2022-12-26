package edu.handong.csee.plt.exception.handler.parse;

import edu.handong.csee.plt.Parser;
import edu.handong.csee.plt.exception.TypeMismatchException;

public class AlphabeticTypeExceptionHandler extends TypeExceptionHandler {

    @Override 
    public void handleException(String expression, String node) 
            throws TypeMismatchException {
        if (!Parser.isAlphabetic(expression)) {
            throw new TypeMismatchException(node);
        }
    }
}
