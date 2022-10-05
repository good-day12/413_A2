package interpreter.virtualmachine;

import interpreter.bytecodes.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean        dumpFlag = false; //if dumpFlag is on call dump method for each bytecode?

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
            if (dumpFlag) {
                code.dump();
                System.out.println(runTimeStack.dump());
            }
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

    public void callCode(int newProgramCount){
        returnAddress.push(programCounter);
        programCounter = newProgramCount;
    }

    public void returnCode(){
        if (!returnAddress.isEmpty()) {
            programCounter = returnAddress.pop();
        }
    }


    public int pop(){
        try {
            return runTimeStack.pop();
        } catch (RuntimeStackIllegalAccess e) {
            return 0; //if we pop more than we have
        }
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
            runTimeStack.store(offsetFromFrame);
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

    public void printFrame(){
        runTimeStack.printFramePointer();
    }

    public void haltCode(){ isRunning = false; }

}
