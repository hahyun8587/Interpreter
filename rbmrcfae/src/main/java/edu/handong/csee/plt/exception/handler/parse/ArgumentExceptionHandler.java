package edu.handong.csee.plt.exception.handler.parse;

import edu.handong.csee.plt.exception.TooFewArgumentException;
import edu.handong.csee.plt.exception.TooManyArgumentException;

/**
 * Class that handles argument exceptions.
 */
public abstract class ArgumentExceptionHandler extends ParseExceptionHandler {
    
    /**
     * Handles argument exception according to the given number of expressions and the given value.
     * Exception will be thrown if the number of operands does not satisfy certain condition.
     * Otherwise, nothing happens. 
     * @param numOperand the number of operands
     * @param value value
     * @param node the name of AST node that error handling occurs
     * @throws TooFewArgumentException
     * @throws TooManyArgumetException
     */
    public abstract void handleException(int numOperand, int value, String node) 
            throws TooFewArgumentException, TooManyArgumentException;
}
