package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * STORE BYTE CODE:
 * Move values from top of runTimeStack to offset in current frame, cannot operate across frame boundaries
 * Can have 1 to 2 arguments
 * 1st argument - offset in current frame where value popped is to be stored
 * 2nd argument - identifier of value (not necessary for function)
 *
 * DUMP: "STORE offset id id=value-popped
 */

public class StoreCode implements ByteCode {

    int offsetFromFrame;
    String identifier = "";
    private int valuePopped;

    @Override
    public void init(ArrayList<String> stringArray) {
        offsetFromFrame = Integer.parseInt(stringArray.get(0));
        if (stringArray.size() > 1) { identifier = stringArray.get(1); }
    }

    @Override
    public void execute(VirtualMachine vm) {
        valuePopped = vm.store(offsetFromFrame);
    }

    @Override
    public void dump() {
        System.out.println("STORE " + offsetFromFrame + " " + identifier + " " + identifier + "=" + valuePopped );
    }
}
