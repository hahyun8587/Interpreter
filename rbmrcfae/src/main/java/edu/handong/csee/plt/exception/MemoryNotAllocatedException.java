package edu.handong.csee.plt.exception;

/**
 * Thrown when threre is an access on unallocated memory.
 */
public class MemoryNotAllocatedException extends InterpreteException {
    
    public MemoryNotAllocatedException(int address) {
        super(address);
    } 

    @Override 
    public String getMessage() {
        return "Memory error: trying to access not allocated memory " + address;
    }
}
