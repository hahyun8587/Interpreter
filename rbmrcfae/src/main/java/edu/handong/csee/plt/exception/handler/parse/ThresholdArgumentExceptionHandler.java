package edu.handong.csee.plt.exception.handler.parse;

import edu.handong.csee.plt.exception.TooManyArgumentException;

/**
 * Class that checks the number of operand is greater than the threshold. 
 */
public class ThresholdArgumentExceptionHandler extends ArgumentExceptionHandler {
    
    @Override
    public void handleException(int numOperand, int value, String node) 
            throws TooManyArgumentException {
        if (numOperand > value) {
            throw new TooManyArgumentException(node);
        }
    }
}
