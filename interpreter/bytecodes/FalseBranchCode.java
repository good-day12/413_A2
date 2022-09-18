package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

/**
 * 3.3 FalseBranch ByteCode
 * The FalseBranch ByteCode will be used to execute conditional jumps( think of executing control structures like
 * if-statements and loops). FalseBranch will have one argument. This argument is a Label that will mark a place
 * in the program to jump to. FalseBranch will remove the top value of the run time stack and check to see if the
 * value is 0. If the value is 0, jump the corresponding label. If the value is something else, move to the next
 * ByteCode in the program. FalseBranch will need to have its label address calculated before the program begins
 * executing. This requires finding where the destination of the jump is going to be numerically(address in the
 * program) in the program.
 *
 * 3.3.1 Requirements
 * • FalseBranch takes one argument, a label to jump to.
 * • FalseBranch’s label address will need to be resolved. This requires computing where FalseBranch will jump to
 * if the value popped from the stack is 0. Address resolution needs to be done before you began executing the
 * program. This will be discussed later in this document.
 *
 * • Remove the top value of the stack.
 * – if value is 0, jump to label.
 * – if value is not 0, move to next ByteCode. (do nothing)
 * • If dump is on, FalseBranch ByteCode is required to be dumped.
 * • The FalseBranch bytecode cannot detect when it should be dumped nor should it call
 * dump in the VirtualMachine.
 * 3.3.2 Dumping
 * The FalseBranch bytecode has the following dump syntax:
 *     FALSEBRANCH label
 * where label is the originallabel read from the .cod files.
 */

/**
 * TODO: implement logic
 */
public class FalseBranchCode extends ByteCode{
    @Override
    public void execute(VirtualMachine vm) {
        //if top of stack is 0 we will jump to label
        if (vm.popCode() == 0){
            //label will be our first argument

            //logic for going to address somehow?
            //do we create a function in VM to change our program counter???


        }
        else {
            //vm.popCode() should be an address right?
        }
    }

    @Override
    public void dump() {
        System.out.println("FALSEBRANCH ");
    }
}
