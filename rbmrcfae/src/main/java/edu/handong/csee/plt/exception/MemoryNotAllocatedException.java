package edu.handong.csee.plt.exception;

public class MemoryNotAllocatedException extends InterpreteException {
    
    public MemoryNotAllocatedException(int address) {
        super(address);
    } 

    @Override 
    public String getMessage() {
        return "Memory error: trying to access not allocated memory " + address;
    }
}
