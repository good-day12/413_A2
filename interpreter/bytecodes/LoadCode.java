package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * LOAD BYTE CODE:
 * Move values that are at offset from top of current frame to the top of the stack
 * cannot operate across frame boundaries
 * Can have one to two arguments
 * 1st argument is the offset to current frame for values to be copied
 * 2nd argument is the identifier the value belongs to (not necessary for functionality)
 *
 * DUMP:    "LOAD offset id" if id exists
 *          "LOAD offset" if no id exists
 */

public class LoadCode implements ByteCode{

    private int offset;
    private String id = "";

    public void init(ArrayList<String> stringArray){
        offset = Integer.parseInt(stringArray.get(0));
        if(stringArray.size() > 1) { //check if we have a second argument
            id = stringArray.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.load(offset);
    }

    @Override
    public void dump() {
        if (id.equals("")){
            System.out.println("LOAD " + offset);
        } else{
            System.out.println("LOAD " + offset + " " + id);
        }
    }
}
