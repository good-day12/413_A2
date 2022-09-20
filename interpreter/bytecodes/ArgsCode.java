package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

/**
 * 3.8 Args ByteCode
 * The Args ByteCode is going to be used to setup how many arguments a function has. The Args ByteCode will always be
 * executed just before a Call ByteCode. The Args ByteCode has one argument, the number of values that are arguments for
 * the next function call. This value N, will be used to determine how many values starting from the top of the runtime
 * stack will be a part of a newly created activation frame for the next function call. Args will need to figure out
 * where in the runtime stack this new frame begins at and push this index into the FramePointer stack.
 *
 * 3.8.1 Requirements
 * • The Args byteCode has one argument, the number of values that will be a part of the new activation frame.
 * • The Args ByteCode will need to push the starting index of the new frame to the framePointer stack.
 * • If dump is on, the Args ByteCode is requried to be dumped.
 * • The Args bytecode cannot detect when it should be dumped nor should it call dump
 * in the VirtualMachine.
 * 3.8.2 Dumping
 * The Args bytecode has the following dump syntax:
 * ARGS n
 * where n is the number of args of the new call frame.
 */

/**
 * TODO: implement logic
 */

public class ArgsCode extends ByteCode{

    private int argsNum;

    @Override
    public void init(String s1, String s2) {
        argsNum = Integer.parseInt(s1);
    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    @Override
    public void dump() {

    }
}
