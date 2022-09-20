package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;


/**
 * TODO: implement logic
 */
public class HaltCode extends ByteCode{
    @Override
    public void init(String s1, String s2) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.haltCode();
    }

    @Override
    public void dump() {

    }
}
