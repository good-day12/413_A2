package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * READ BYTE CODE:
 * This Byte Code's job is to read an input from the user and push it to the top of the RunTimeStack
 *
 * DUMP: "READ"
 */

public class ReadCode implements ByteCode{

    @Override
    public void init(ArrayList<String> stringArray) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        int value;
        Scanner s = new Scanner(System.in);
        //while loop for input validation
        while(true) {
            try {
                System.out.println("Please enter an integer : ");
                value = s.nextInt();
                break; //if we get a valid integer exit while loop
            } catch (InputMismatchException ex) {
                System.out.println("Invalid, please enter an integer : ");
                s.nextLine(); //if we catch an exception continue with while loop
            }
        }
        vm.pushValue(value);
    }

    @Override
    public void dump() {
        System.out.println("READ ");
    }
}
