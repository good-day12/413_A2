package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;


/**
 * TODO: implement logic
 */
public class HaltCode extends ByteCode{
    @Override
    public void init(ArrayList<String> stringArray) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.haltCode();
    }

    @Override
    public void dump() {

    }
}
