package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * POP BYTE CODE:
 * Used to remove value from the runTimeStack
 * cannot operate across frame boundaries
 * has one arugment, the number of values to be popped
 * If we have too many values to be popped, we will pop as many as we can within our current frame
 * then do nothing and allow the program to continue uninterrupted
 *
 * DUMP: "POP popNum" where popNum is the number of pops to perform
 */

public class PopCode implements ByteCode{
    private int popNum;

    @Override
    public void init(ArrayList<String> stringArray) {
        popNum = Integer.parseInt(stringArray.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        for (int i = 0; i < popNum; i++){
            vm.pop();
        }
    }

    @Override
    public void dump() {
        System.out.println("POP " + popNum);
    }
}
