package interpreter.bytecodes;

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
public class PopCode {
    private int popNum;
}
