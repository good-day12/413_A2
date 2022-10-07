package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * LABEL BYTE CODE:
 * Has no functionality, it's purpose is to mark locations in the program for where
 * JumpByteCodes could potentially jump to
 *
 * DUMP: "LABEL label"
 * where label is the current label
 */
public class LabelCode implements JumpByteCode {

    private String label;

    @Override
    public void init(ArrayList<String> stringArray) {
        label = stringArray.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {/*Has nothing to execute*/}

    @Override
    public void dump() {
        System.out.println("LABEL " + label);
    }

    public void setLabel(String l) { label = l; }

    public String getLabel (){ return label; }

    @Override
    public void setAddress(int address) {}
}
