package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * GO TO BYTECODE:
 * Will jump to the label
 * Has one argument, a label we need to jump to
 * address will be given in resolveAddress function from program
 *
 * DUMP: "GOTO label"
 * where label is the label we will jump to
 */
public class GotoCode implements JumpByteCode {
    private String label;
    private int address;

    @Override
    public void init(ArrayList<String> stringArray) {
        label = stringArray.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setProgramCounter(address);
    }

    @Override
    public void dump() {
        System.out.println("GOTO " + label);
    }

    @Override
    public void setLabel(String label) { this.label = label; }

    @Override
    public String getLabel(){ return label; }

    @Override
    public void setAddress(int address){ this.address = address; }
}
