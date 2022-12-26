package edu.handong.csee.plt.structure.store;

import edu.handong.csee.plt.exception.InterpreteException;
import edu.handong.csee.plt.structure.value.Value;

public class Memory {
    private int address;
    private Value value;
    private Memory next;
    private int maxAddress;
    
    public Memory(int address, Value value, Memory next, int maxAddress) {
        this.address = address;
        this.value = value;
        this.next = next;
        this.maxAddress = maxAddress;
    }

    public int getMaxAddress() {
        return maxAddress;
    }

     /**
     * Finds the value of the first encountering given address.
     * @param address address
     * @return value of the first encountering given address if the address is in the linked list, otherwise <code>null</code>
     */
    public Value find(int address) {
        Memory curr = this;

        while (curr != null) {
            if (curr.address == address) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    public String getASTCode() throws InterpreteException {
        return "(aSto " + String.valueOf(address) + " " 
               + value.getASTCode() + " " 
               + (next == null ? "mtSto)" : next.getASTCode());
    }
}
