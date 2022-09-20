package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * 3.9 Call ByteCode
 * The Call ByteCode is what the VirtualMachine uses to jump to locations in the program to execute sections of code we
 * call Functions. When encountered the Call ByteCode will jump to the corresponding label in the program. The ByteCde
 * is also responsible of keeping track of where control should return to when a function completes its execution.
 *
 * 3.9.1 Requriements
 * • Call ByteCode takes 1 argument, a label to jump to.
 * • Call Code must go through address resolution to figure out where it needs to jump to
 * in the Program before the program is ran.
 * • Call Code must store a return address onto the Return Address Stack.
 * • Call Code must Jump the address in the program that corresponds to a label code (this address is computed during
 *      address resolution).
 * • If dumping is on, the Call ByteCode is requried to be dumped.
 * • The Call bytecode cannot detect when it should be dumped nor should it call dump
 * in the VirtualMachine.
 *
 * 3.9.2 Dumping
 * The Call bytecode has the following dump syntax:
 *      Basic Syntax : CALL <id>   <base-id>(<args>)
 *      <id> is a function identifier
 *      <base-id> is the actual id of the function;
 *      e.g. for CALL f<<2>>, the <base-id> is f
 *      <args> are the function arguments.
 *      Example      :
 *      If we assume the RuntimeStack has the following values
 *          [0,1,2] [3,4,5]
 *      And we execute a CALL f<<3>>.
 *      Before the CALL code is executed, an ARGS 3 has been executed.
 *      Then the dumping of the call code looks as follows:
 *      CALL f<<3>>   f(3,4,5)
 */


/**
 * TODO: implement logic
 */
public class CallCode extends ByteCode{

    private String label;

    @Override
    public void init(ArrayList<String> stringArray) {
        label = stringArray.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    @Override
    public void dump() {

    }
}
