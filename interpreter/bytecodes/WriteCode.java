package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * WRITE BYTE CODE:
 * Writes the top of the stack to the console output
 * has no arguments
 *
 * DUMP: WRITE
 */

public class WriteCode implements ByteCode{
    @Override
    public void init(ArrayList<String> stringArray) {}

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peek());
    }

    @Override
    public void dump() {
        System.out.println("WRITE ");
    }
}
