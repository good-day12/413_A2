package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

/**
 * 3.15 Dump ByteCode
 * The Dump ByteCode is used to turn dumping ON and OFF. Dumping in the interpreter project is only done when dumping is
 * ON.
 *
 * 3.15.1 Requirements
 * • The Dump ByteCode has 1 argument. Either ”ON” or ”OFF”
 * • The Dump ByteCode must request the VirtualMachine to turn dumping either ”ON”
 * or ”OFF”.
 * • The Dump ByteCode is NOT TO BE DUMPED.
 */

/**
 * TODO: implement logic
 */

public class DumpCode extends ByteCode{
    @Override
    public void execute(VirtualMachine vm) {

    }

    @Override
    public void dump() {

    }
}
