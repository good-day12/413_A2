package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * FALSE BRANCH CODE
 * Used to executed conditional jumps, has a label that will control where the code jumps,
 * address will be given in resolveAddress function from program
 * We must pop the top of the stack and if that value is 0 we will jump to the label, if it is
 * anything else we will not perform the jump
 *
 * DUMP: "FALSEBRANCH label"
 * label is the label we might jump to
 */
public class FalseBranchCode implements JumpByteCode {
    private String label;
    private int resolvedAddress;

    @Override
    public void init(ArrayList<String> stringArray) {
        label = stringArray.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        //if top of stack is 0 we will jump to label
        if (vm.pop() == 0){
            vm.setProgramCounter(resolvedAddress);
        }

    }

    @Override
    public void dump() {
        System.out.println("FALSEBRANCH " + label);
    }

    public void setAddress(int address){ this.resolvedAddress = address; }

    @Override
    public void setLabel(String label) { this.label = label; }

    @Override
    public String getLabel(){ return this.label; }


}
