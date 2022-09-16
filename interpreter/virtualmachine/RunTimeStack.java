package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class RunTimeStack {

    private List<Integer>  runTimeStack; //values for entire program
    private Stack<Integer> framePointer; //tells us where every frame begins

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0. should never be empty
        framePointer.add(0); //so the frame pointer holds the value of the runTimeStack that we are currently
                                //working with? like if a function is called we would use the framePointer to
                                //store
    }
    /**
     * Used for dumping the current state of the runTimeStack. It will print portions of the stack based on respective
     * frame markers.
     * Example [1,2,3] [4,5,6] [7,8]
     * Frame pointers would be 0, 3, 6 */
    public String dump(){
        return "";
    }

    /**
     * returns the top of the runtime stack, but does not remove it
     * @return copy of the top of stack.
     * @throws RuntimeStackIllegalAccess if peeking an empty stack.
     */
    public int peek() throws RuntimeStackIllegalAccess {
        return -1;
    }

    /**
     * push the value i to the top of the stack
     * @param i value to be pushed.
     * @return value pushed
     */
    public int push(int i) {
        return -1;
    }

    /**
     * removes the top of the runtime stack
     * @return the value popped.
     * @throws RuntimeStackIllegalAccess if popping an empty stack
     */
    public int pop() throws RuntimeStackIllegalAccess {
        return -1;
    }

    /**
     * Takes the top item of the run time stack, and stores it into an offset starting from the current frame.
     * @param offsetFromFramePointer number of slots above current frame marker
     * @returns the item just stored
     * @throws RuntimeStackIllegalAccess if offset is out of bounds of current frame
     */
    public int store(int offsetFromFramePointer) throws RuntimeStackIllegalAccess {
        return -1;
    }

    /**
     * Takes a value from the run time stack that is at offset from the current frame marker and pushes it onto the top
     * of the stack.
     * @param offsetFromFramePointer number of slots above current frame marker
     * @return item just loaded into the offset
     * @throws RuntimeStackIllegalAccess if offset is out of bounds of current frame
     */
    public int load(int offsetFromFramePointer) throws RuntimeStackIllegalAccess {
        return -1;
    }

    /**
     * create a new frame pointer at the index offset slots down from the top of the runtime stack.
     * @param offset slots down from the top of the runtime stack
     */
    public void newFrameAt(int offsetFromTopOfRunStack){

    }

    /**
     * pop the current frame off the runtime stack. Also removes the frame pointer value from the FramePointer Stack.
     * I think that this should already have access to the framePointer
     */
    public void popFrame(){

    }
}
