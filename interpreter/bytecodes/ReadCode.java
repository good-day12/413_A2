package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 3.12 Read ByteCode
 * The Read ByteCode is used to read user input from the keyboard. Only integers should be accepted from users. You may
 * use Scanners or BufferedReaders to read input from the user.
 *
 * 3.12.1 Requirements
 * • When asking for user input, use the following prompt: ”Please enter an integer : ”
 * • The Read ByteCode needs to verify that the value given is actually a number. If an invalid number is given, state
 * that the input is invalid and ask for another value. Continue to do so until a valid value is given.
 *
 * • Push the validated integer to the VirtualMachine’s RunTimeStack.
 * • If dumping is on, the Read bytecode is requried to be dumped.
 * • The Read bytecode cannot detect when it should be dumped nor should it call dump in the VirtualMachine.
 *
 * 3.12.2 Dumping
 * The Read bytecode has the following dump synatx:
 * READ
 */

/**
 * TODO: implement logic
 */

public class ReadCode extends ByteCode{

    @Override
    public void init(String s1, String s2) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        int value;
        Scanner s = new Scanner(System.in);
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

    }
}
