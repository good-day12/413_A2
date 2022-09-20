package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

/**
 * 3.14 Label ByteCode
 * The Label bytecode is a bytecode that has no functionality. Its sole purpose is to mark locations in the program
 * where other bytecodes can jump to. Label bytecodes will be used in address resolution so other ByteCodes know where
 * they are supposed to jump to.
 *
 * 3.14.1 Requirements
 * • Label takes one argument, a label which is used to denote a location in the program. • If dumping is on, dumping
 * the Label bytecode is optional.
 * 3.14.2 Dumping
 * If you deicde to dump the Label bytecode, it should have the following dump format:
 * LABEL label
 * where label is the string value that is the label of where to jump to.
 */


/**
 * TODO: implement logic
 * Should I put the label into the Bytecode list in the program?
 * Or should I do it in the Stack<Integer> returnAddress;
 */
public class LabelCode extends ByteCode{
    @Override
    /**
     * Let's get the address (where the program counter is currently at)
     * Store that address into stack for future use
     */
    public void execute(VirtualMachine vm) {
        vm.setAddress();
    }

    @Override
    public void dump() {

    }
}
