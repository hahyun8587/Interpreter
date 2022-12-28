package edu.handong.csee.plt.structure.value;

import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.ValueWithLog;
import edu.handong.csee.plt.structure.store.Memory;

/**
 * Class that represents output value.
 */
public abstract class Value {

    /**
     * Stricts to the actual value of with the updated memory.
     * @param memory memory
     * @return the actual value with updated memory
     */
    public abstract ValueWithLog strict(Memory memory) 
            throws InterpreteException;

    public abstract String getASTCode() throws InterpreteException;
}
