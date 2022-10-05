package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * 3.10 Return ByteCode
 * The Return ByteCode will be used to return from functions but also to put return values in the correct position on
 * the runtime stack. The interpreter project will use this convention for handling arguments and return values. Callers
 * of functions are required to setup argument for the functions they call. Functions themselves (callees) are required
 * to put return values in the correct spot just before returning from a function. Note that this is a convention we
 * will adhere to and is something that is not enforced programmatically. This means if you fail to follow this
 * convention, transient bugs can happen. The Return ByteCode has a lot of responsibility. The steps for completing a
 * return is important.
 *
 * 3.10.1 Requirements
 * • The Return ByteCode can take 0 to 1 arguments. The arguments have no effect on its functionality. But does effect
 *      the Dumping process.
 * • The Return ByteCode must store the return value at the top of the runtime stack.
 * • The Return ByteCode must empty the current frame of all values when the function
 * is complete.
 * • The Return ByteCode must pop the top value from the framePointer stack to remove the frame boundary.
 * • The return ByteCode must pop the top of the return address stack and save it into program counter.
 * • If dumping is on, the Return ByteCode is requried to be dumped.
 * • The Return bytecode cannot detect when it should be dumped nor should it call dump
 * in the VirtualMachine.
 *
 * 3.10.2 Dumping
 * The Return bytecode has the following dump syntax:
 *      Basic Syntax : RETURN <id>    EXIT <base-id>:<value>
 *      <id> is a function identifier
 *      <value> is the value being returned from the function
 *      <base-id> is the actual id of the function;
 *      e.g. for RETURN f<<2>>, the <base-id> is f
 *      Example      : RETURN f<<2>>  EXIT f : 4
 */

/**
 * TODO: implement logic
 */

public class ReturnCode implements ByteCode{

    @Override
    public void init(ArrayList<String> stringArray) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        int temp = vm.pop(); //temp int to hold return value
        vm.popFrame();
        vm.pushValue(temp);//put that value back into our stack to return that value
        vm.returnCode();
    }

    @Override
    public void dump() {
        System.out.println("RETURN"); //*********************NEEDS MORE IMPLEMENTATION
    }
}
