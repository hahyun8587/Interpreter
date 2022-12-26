package edu.handong.csee.plt.exception.handler.parse;

import edu.handong.csee.plt.exception.TooFewArgumentException;
import edu.handong.csee.plt.exception.TooManyArgumentException;

/**
 * Class that checks the number of operand is equals to the number of children of the node.
 */
public class ExactArgumentExceptionHandler extends ArgumentExceptionHandler {
    
    @Override
    public void handleException(int numOperand, int value, String node) 
            throws TooFewArgumentException, TooManyArgumentException {
        if (numOperand < value) {
            throw new TooFewArgumentException(node);
        } else if (numOperand > value) {
            throw new TooManyArgumentException(node);
        }
    }
}
