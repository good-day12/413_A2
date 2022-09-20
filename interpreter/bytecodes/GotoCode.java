package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * 3.4 Goto ByteCode
 * The Goto ByteCode is used to jump to Labels in our programs. Goto is considered an unconditional jump. This means
 * regardless of the state of the program, we take the jump. Goto has one argument, the label it needs to jump to. Like
 * FalseBranch, Goto’s label needs to go through address resolution as well.
 *
 * 3.4.1 Requirement
 * • Goto has one argument, a label to jump to.
 * • Goto’s Label must have its address resolved before the program begins executing. More
 * on this later.
 * • If dump is on, Goto is required to be dumped. Examples are given in this document.
 * • The Goto bytecode cannot detect when it should be dumped nor should it call dump in the VirtualMachine.
 * 3.4.2 Dumping
 * The Goto bytecode has the following dump syntax:
 * GOTO label
 * where label is the originallabel read from the .cod files.
 */


/**
 * TODO: implement logic
 */
public class GotoCode extends ByteCode{

    private String label;

    @Override
    public void init(ArrayList<String> stringArray) {
        label = stringArray.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pop(); // should be our label?

        //do we create a function in VM to change our program counter???
    }

    @Override
    public void dump() {
        System.out.println("GOTO ");
    }
}
