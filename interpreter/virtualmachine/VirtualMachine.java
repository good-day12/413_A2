package interpreter.virtualmachine;

import interpreter.bytecodes.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean        dumpFlag; //if dumpFlag is on call dump method for each bytecode?

    public VirtualMachine(Program program) { //this object will already be loaded with everything by the interpreter
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
    }

    public void executeProgram(){
        isRunning = true;

        while (isRunning){ //add check for dump in loop
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            programCounter++;
        }
    }

    /**
     * Will contain many functions to assist bytecodes
     * Create a method to halt program if HaltCode is found?
     */

    public int popCode(){
        try {
            return runTimeStack.pop();
        } catch (RuntimeStackIllegalAccess e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void haltCode(){
        /**
         * TODO: add checks before closing program
         */
        System.exit(2);
    }

}
