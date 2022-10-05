package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * Will be parent class of all ByteCodes, all ByteCodes must inherit the init()
 * and execute() function
 */
public interface ByteCode {

    /**
     * Function will initialize the ByteCode and load the proper arguments into
     * the ByteCode's data fields
     * @param stringArray (where we get our arguments from)
     */
    void init(ArrayList<String> stringArray);

    /**
     * Function will execute the purpose of the ByteCode, definition varies for
     * each ByteCode's intended purpose
     * @param vm
     */
    void execute(VirtualMachine vm);

    /**
     * Print out information about ByteCode's data field and execution
     */
    void dump();


}

