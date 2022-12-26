package edu.handong.csee.plt.exception.handler.parse;

import edu.handong.csee.plt.exception.ParenthesisNotMatchingExcpetion;

/**
 * Class that handles parenthesis exception. 
 */
public class ParenthesisExceptionHandler {
    
    /**
     * Handles parenthesis excpetion according to the given code.
     * Exception will be thrown if the parentheses of the given code are not matching.
     * Otherwise, nothing happens.
     * @param code code
     * @throws ParenthesisNotMatchingException
     */
    public void handleException(String code) throws ParenthesisNotMatchingExcpetion {
        if ((code.startsWith("{") && !code.endsWith("}"))
                || (!code.startsWith("{") && code.endsWith("}"))) {
            throw new ParenthesisNotMatchingExcpetion(code);
        }
    }
}
