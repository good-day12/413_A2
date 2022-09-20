package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

/**
 * 3.13 Write ByteCode
 * The Write ByteCode is used to display information to the console. The only thing Write is allowed to display is the
 * top value of the runtime stack. No other information is allowed to be shown.
 *
 * 3.13.1 Requirements
 * • Prints the top of the runtime stack to the console.
 * • NO OTHER information can be printed by the Write ByteCode when printing the
 * value.
 * • If dumping is on, bytecode is requried to be dumped.
 * • The Write bytecode cannot detect when it should be dumped nor should it call dump in the VirtualMachine.
 * 3.13.2 Dumping
 * The Write bytecode has the following dump synatx:
 * WRITE
 */

/**
 * TODO: implement logic
 */

public class WriteCode extends ByteCode{
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peek());
    }

    @Override
    public void dump() {

    }
}
