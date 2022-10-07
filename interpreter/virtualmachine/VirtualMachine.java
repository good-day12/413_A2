package interpreter.virtualmachine;

import interpreter.bytecodes.ByteCode;

import java.util.List;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean        dumpFlag = true;

    public VirtualMachine(Program program) {
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
     * Used to set the dumpFlag if we are dumping or not
     * @param dump a boolean value used to set the dumpFlag to true or not
     */
    public void setDumpFlag(boolean dump){
        dumpFlag = dump;
    }

    /**
     * Used to change the programCounter
     * @param newProgramCount the new programCounter value
     */
    public void setProgramCounter(int newProgramCount){
        programCounter = newProgramCount;
    }

    /**
     * To execute the CallCode ByteCode, must save current programCounter
     * in returnAddress stack and set the programCounter to the new value
     * @param newProgramCount the new programCounter value
     */
    public void callCode(int newProgramCount){
        returnAddress.push(programCounter);
        programCounter = newProgramCount;
    }

    /**
     * To execute the ReturnCode ByteCode, must set the programCounter to the
     * returnAddress value
     */
    public void returnCode(){
        if (!returnAddress.isEmpty()) {
            programCounter = returnAddress.pop();
        }
    }

    /**
     * To help ByteCodes do their jobs, pops the top of RunTimeStack
     * @return the top of the RunTimeStack
     */
    public int pop(){
        try {
            return runTimeStack.pop();
        } catch (RuntimeStackIllegalAccess e) {
            return 0;
            /*
            * Cannot throw error here because Pop is allowed to have more than the allowed number of pops
            * we just pop all that we are allowed to pop, then continue on
            */
        }
    }

    /**
     * To help ByteCodes do their jobs, push a value onto the RunTimeStack
     * @param value - to be pushed onto stack
     */
    public void pushValue (int value){
        runTimeStack.push(value);
    }

    /**
     * To help ByteCodes do their jobs, look at top of runTimeStack
     * @return the top of the stack
     */
    public int peek(){
        try {
            return runTimeStack.peek();
        } catch (RuntimeStackIllegalAccess e) {
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

    /**
     * To help ByteCodes do their jobs, load values onto RunTimeStack
     * @param offsetFromFrame how many values from Frame to load
     */
    public void load(int offsetFromFrame){
        try {
            runTimeStack.load(offsetFromFrame);
        } catch (RuntimeStackIllegalAccess e) {
            e.printStackTrace();
        }
    }

    /**
     * To help ByteCodes do their jobs, stores value at offset from current frame
     * onto the RunTimeStack
     * @param offsetFromFrame offset where to find the value
     * @return the value we loaded
     */
    public int store(int offsetFromFrame){
        try {
            return runTimeStack.store(offsetFromFrame);
        } catch (RuntimeStackIllegalAccess e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Destroy the current frame and remove it from the RunTimeStack
     */
    public void popFrame(){
        try {
            runTimeStack.popFrame();
        } catch (RuntimeStackIllegalAccess e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the values of the current frame, to help the dump of CallCode
     * @return list of values in current frame
     */
    public List<Integer> getCurrentFrame(){
        return runTimeStack.getCurrentFrame();
    }

    /**
     * To help haltCode stop the program by setting isRunning to false;
     */
    public void haltCode(){ isRunning = false; }
}
