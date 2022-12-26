package edu.handong.csee.plt.structure.value;

import edu.handong.csee.plt.exception.InterpreteException;

/**
 * Class that represents output value.
 */
public abstract class Value {

    /**
     * Stricts to the actual value of this instance.
     * @return the actual value
     */
    public abstract Value strict() throws InterpreteException;
    public abstract String getASTCode() throws InterpreteException;
}
