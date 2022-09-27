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
        /**
         * Need to add dumping implementation
         */
        while (isRunning){ //add check for dump in loop
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            if (dumpFlag) { code.dump(); }
            programCounter++;
        }
    }

    /**
     * Will contain many functions to assist bytecodes
     * Create a method to halt program if HaltCode is found?
     */



    public void setDumpFlag(boolean arg){
        dumpFlag = arg;
    }

    public void setProgramCounter(int newProgramCount){
        programCounter = newProgramCount;
    }

    public void goTo(int newProgramCount){
        returnAddress.push(programCounter); //save the old address,so we go to the next step, avoid a loop (+1?)
        programCounter = newProgramCount;
    }

    public void returnCode(){
        if (!returnAddress.isEmpty()) {
            programCounter = returnAddress.pop();
        }//should we add one so we can go to the next step and avoid a loop
    } //POTENTIAL INFINITE LOOP ERROR***********************************************************************


    public int pop(){
        try {
            return runTimeStack.pop();
        } catch (RuntimeStackIllegalAccess e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void pushValue (int value){
        runTimeStack.push(value);
    }

    public int peek(){
        try {
            return runTimeStack.peek();
        } catch (RuntimeStackIllegalAccess e) { //what should I do in the catch statement?
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * This will create a newFrame with arguments if any are passed
     * @param args Number of arguments to use in new frame
     */
    public void newFrame(int args){
        this.runTimeStack.newFrameAt(args);
    }

    public void load(int offsetFromFrame){
        try {
            runTimeStack.load(offsetFromFrame);
        } catch (RuntimeStackIllegalAccess e) {
            e.printStackTrace();
        }
    }

    public void store(int offsetFromFrame){
        try {
            runTimeStack.load(offsetFromFrame);
        } catch (RuntimeStackIllegalAccess e) {
            e.printStackTrace();
        }
    }

    public void popFrame(){
        try {
            runTimeStack.popFrame();
        } catch (RuntimeStackIllegalAccess e) {
            e.printStackTrace();
        }
    }

    public void haltCode(){
        /**
         * TODO: add checks before closing program
         */
        isRunning = false;
    }

}
