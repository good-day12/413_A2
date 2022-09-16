package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

abstract class AbstractByteCode {

    /**
     * Method to execute the responsibilities of the ByteCode
     * @param vm virtual machine giving instructions
     */
    abstract void execute(VirtualMachine vm);

    /**
     * Method to dump the logs to the console output
     * @param vm
     */
    abstract void dump(VirtualMachine vm);

}
