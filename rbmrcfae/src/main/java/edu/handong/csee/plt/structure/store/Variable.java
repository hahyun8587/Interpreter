package edu.handong.csee.plt.structure.store;

import edu.handong.csee.plt.exception.FreeVariableException;

public class Variable {
    private String id;
    private int address;
    private Variable next;

    public Variable(String id, int address, Variable next) {
        this.id = id;
        this.address = address;
        this.next = next;
    }

    /**
     * Finds the address of the first encountering given id.
     * @param id id
     * @return address of the first encountering id if the id is in the linked list, otherwise -1
     * @throws FreeVariableException
     */
    public int find(String id) throws FreeVariableException {
        Variable curr = this;

        while (curr != null) {
            if (curr.id.equals(id)) {
                return curr.address;
            }
            curr = curr.next;
        }
        throw new FreeVariableException(id);
    }

    public String getASTCode() {
        return "(aSub " + id + " " 
               + String.valueOf(address) + " " 
               + (next == null ? "(mtSub))" : next.getASTCode());
    }
}
