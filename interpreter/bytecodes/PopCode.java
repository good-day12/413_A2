package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * The Pop ByteCode will be used to remove values from the run time stack. The Pop ByteCode
 * is not allowed to remove values across frame boundaries. It is the implementers responsibility
 * to ensure that Pop is only allowed to pop the appropriate number of values. Pop has one
 * argument, N , which is the number of values to be popped. You cannot make any assumptions
 * about the value of N other than it is a strictly positive number.
 *
 * Pop takes one argument which is the number of values to remove from the run time
 * stack.
 * Pop is not allowed operate across frame boundaries.
 * If dump is on, Pop is required to be dumped.
 * The Pop bytecode cannot detect when it should be dumped nor should it call dump
 * in the VirtualMachine.
 */

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
