package edu.handong.csee.plt.structure.store;

import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.exception.MemoryNotAllocatedException;
import edu.handong.csee.plt.structure.value.Value;
import edu.handong.csee.plt.structure.store.Memory;

public class Memory {
    private static int maxAddress = -1;
    private int address;
    private Value value;
    private Memory next;
    
    /**
     * Initiates this instance with the given address and value.
     * @param address address
     * @param value value
     * @param next next memory
     */
    public Memory(int address, Value value, Memory next) {
        this.address = address;
        this.value = value;
        this.next = next;
    }

    /**
     * Initiates this instance with the <code>maxAddress + 1</code> and the given value.
     * @param value value
     * @param next next memory
     */
    public Memory(Value value, Memory next) {
        address = ++maxAddress;
        this.value = value;
        this.next = next;
    }

    public int getMaxAddress() {
        return maxAddress;
    }

    public Memory getNext() {
        return next;
    }

    public void setNext(Memory next) {
        this.next = next;
    }

     /**
     * Finds the value of the first encountering given address.
     * Exception will be thrown if there is no corresponding value of the given address.
     * @param address address
     * @return value of the first encountering given address if the address is in the linked list
     * @throws MemoryNotAllocatedException
     */
    public Value find(int address) throws MemoryNotAllocatedException {
        Memory curr = this;

        while (curr != null) {
            if (curr.address == address) {
                return curr.value;
            }
            curr = curr.next;
        }
        throw new MemoryNotAllocatedException(address);
    }

    /**
     * Gets the number of <code>Memory</code> instance linked with this instance including itself.
     * @return the size of this instance.
     */
    public int size() {
        Memory curr = this;
        int count = 0;

        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    } 

    public String getASTCode() throws InterpreteException {
        return "(aSto " + String.valueOf(address) + " " 
               + value.getASTCode() + " " 
               + (next == null ? "mtSto)" : next.getASTCode());
    }
}
