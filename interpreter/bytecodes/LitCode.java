package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * LIT BYTE CODE:
 * takes one or two arguments, must push a value onto the runTimeStack
 * 1st argument is the value, 2nd is the identifier (2nd does not need to exist)
 *
 * DUMP:    "LIT id int value" if we have an identifier
 *          "LIT value" if no identifier
 */

public class LitCode implements ByteCode{

    private int value;
    private String id = "";

    public void init(ArrayList<String> stringArray){
        value = Integer.parseInt(stringArray.get(0));
        if (stringArray.size() > 1) {
            id = stringArray.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushValue(value);
    }

    @Override
    public void dump() {
        if (id.equals("")) {
            System.out.println("LIT " + value);
        } else {
            System.out.println("LIT " + id + " int " + value);
        }
    }
}
