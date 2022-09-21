package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 *  You will need to make sure that you protect the RunTimeStack from stack overflow or
 * stack underflow errors. Also make sure no ByteCode can pop past any frame boundary.
 */

class RunTimeStack {

    private List<Integer>  runTimeStack; //values for entire program
    private Stack<Integer> framePointer; //tells us where every frame begins

    private int index; //keep track of our runTimeStack index

    int lastIndex(){
        return Math.max(0, this.runTimeStack.size() - 1);
    }

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        index = 0;
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0. should never be empty
        framePointer.add(0); //so the frame pointer holds the value of the runTimeStack that we are currently
                                //working with? like if a function is called we would use the framePointer to
                                //store
    }

    /**
     * returns the top of the runtime stack, but does not remove it
     * @return copy of the top of stack.
     * @throws RuntimeStackIllegalAccess if peeking an empty stack.
     */
    public int peek() throws RuntimeStackIllegalAccess {
        if(this.runTimeStack.isEmpty()){
            throw new RuntimeStackIllegalAccess(new EmptyStackException());
        }
        return this.runTimeStack.get(lastIndex());
    }

    /**
     * push the value i to the top of the stack
     * @param i value to be pushed.
     * @return value pushed
     */
    public int push(int i) {
        runTimeStack.add(i); //insert element into top of our list
        index++;//increment counter to keep track of index
        return i;
    }

    /**
     * removes the top of the runtime stack
     * @return the value popped.
     * @throws RuntimeStackIllegalAccess if popping an empty stack
     */
    public int pop() throws RuntimeStackIllegalAccess {
        try{
            //make sure we don't try to access anything outside our current frame, check if it is empty
//            if(index >= framePointer.peek() && !runTimeStack.isEmpty() ) {
                return this.runTimeStack.remove(lastIndex());
//            } else{
//                throw new EmptyStackException();
//            }
        } catch (IndexOutOfBoundsException ex){
            throw new RuntimeStackIllegalAccess(ex);
        }
    }

    /**
     * Takes the top item of the run time stack, and stores it into an offset starting from the current frame.
     * @param offsetFromFramePointer number of slots above current frame marker
     * @returns the item just stored
     * @throws RuntimeStackIllegalAccess if offset is out of bounds of current frame
     */
    //like step 4 to 5 from pdf
    public int store(int offsetFromFramePointer) throws RuntimeStackIllegalAccess {

        //if our offset is out of bounds of its current frame it'll be bigger than the runtime stack size minus
        //the current framePointer which holds the size of our frame currently
        //if out of bounds throw exception
        try{
            if (offsetFromFramePointer > runTimeStack.size() - framePointer.peek()) {
                throw new IndexOutOfBoundsException(); //what exception should I use?
            }
            int temp = runTimeStack.get(index - 1); //grab item from top of runTimeStack, one behind index
            index -= (index - framePointer.peek()); //reset our index to new spot
            runTimeStack.add(index, temp);
            index++; //account for new item added

        } catch (IndexOutOfBoundsException ex){
            throw new RuntimeStackIllegalAccess(ex);
        }

        return 0;
    }

    /**
     * Takes a value from the run time stack that is at offset from the current frame marker and pushes it onto the top
     * of the stack.
     * @param offsetFromFramePointer number of slots above current frame marker
     * @return item just loaded into the offset
     * @throws RuntimeStackIllegalAccess if offset is out of bounds of current frame
     */
    public int load(int offsetFromFramePointer) throws RuntimeStackIllegalAccess {
        try{
            //if our offset is out of bounds of its current frame it'll be bigger than the runtime stack size minus
            //the current framePointer which holds the size of our frame currently
            //if out of bounds throw exception
            if (offsetFromFramePointer > runTimeStack.size() - framePointer.peek()) {
                throw new IndexOutOfBoundsException(); //what exception should I use?
            }
            return runTimeStack.get(index - offsetFromFramePointer);

        } catch (IndexOutOfBoundsException ex){
            throw new RuntimeStackIllegalAccess(ex);
        }
    }

    /**
     * create a new frame pointer at the index offset slots down from the top of the runtime stack.
     * @param offsetFromTopOfRunStack slots down from the top of the runtime stack (for our arguments to be passed)
     */
    public void newFrameAt(int offsetFromTopOfRunStack){
        //add number of new index for new frame into the frame pointer stack,
        framePointer.push(index - offsetFromTopOfRunStack);
    }

    /**
     * pop the current frame off the runtime stack. Also removes the frame pointer value from the FramePointer Stack.
     * I think that this should already have access to the framePointer
     */
    public void popFrame(){
        index = framePointer.pop() + 1; //account for off by one error.
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
     * How to test this class
     */

/*
Use this to test the runTimeStack
 */
    public static void main(String[] args) {
        RunTimeStack x = new RunTimeStack();
        x.push(1);
        x.push(2);
        x.runTimeStack.forEach(v -> System.out.println(v));
    }
}
