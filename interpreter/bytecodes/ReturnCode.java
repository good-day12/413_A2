package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * RETURN BYTE CODE:
 * Used to return from functions and to put return values from function in the top of the stack.
 * Has one optional argument, a label
 * Must store return vale, empty current frame, pop value from framePointer stack, pop value from
 * return address stack and set programCounter to that return value
 *
 * DUMP: "RETURN label EXIT base-label : returnValue"
 */

public class ReturnCode implements ByteCode{
    private int returnValue;
    private String label ="";

    @Override
    public void init(ArrayList<String> stringArray) {
        if (stringArray.size() > 0) {
            label = stringArray.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        returnValue = vm.pop(); //temp int to hold return value
        vm.popFrame(); //get rid of current frame
        vm.pushValue(returnValue);//put that value back into our stack to return that value
        vm.returnCode(); //return the code back to original address before jump
    }

    @Override
    public void dump() {
        if (!label.equals("")) {
            System.out.println("RETURN " + label + " EXIT " + label.substring(0, label.indexOf('<'))
                    + " : " + returnValue);
        }
        else {
            System.out.println("RETURN " + returnValue);
        }
    }
}
