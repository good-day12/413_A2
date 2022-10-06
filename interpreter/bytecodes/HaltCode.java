package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;


/**
 * HALT BYTE CODE:
 * Will stop the program immediately
 *
 * DUMP: n/a
 */
public class HaltCode implements ByteCode {
    @Override
    public void init(ArrayList<String> stringArray) { /*No arguments required*/ }

    @Override
    public void execute(VirtualMachine vm) {
        vm.haltCode();
    }

    @Override
    public void dump() { /*No dump required*/ }
}
