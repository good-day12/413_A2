package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * ARGS BYTE CODE:
 * Has one argument, the number of arguments (argsNum) to be part of the new activation frame
 * Responsible for pushing argsNum number of arguments to the activation frame and storing
 * the new activation frame in the framePointer stack
 *
 * DUMP: should dump "ARGS n" wher n is the number of Args for new call frame
 */

public class ArgsCode implements ByteCode{

    private int argsNum;

    @Override
    public void init(ArrayList<String> stringArray) {
        argsNum = Integer.parseInt(stringArray.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrame(argsNum); //use helper function to create new frames
    }

    @Override
    public void dump() {
        System.out.println("ARGS " + argsNum);
    }
}
