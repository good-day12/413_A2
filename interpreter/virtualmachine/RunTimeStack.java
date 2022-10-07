package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

class RunTimeStack {

    private List<Integer>  runTimeStack; //values for entire program
    private Stack<Integer> framePointer; //tells us where every frame begins

    int lastIndex(){
        return Math.max(0, this.runTimeStack.size() - 1);
    }

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0. should never be empty
        framePointer.add(0);
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
        return i;
    }

    /**
     * removes the top of the runtime stack
     * @return the value popped.
     * @throws RuntimeStackIllegalAccess if popping an empty stack
     */
    public int pop() throws RuntimeStackIllegalAccess {
        if (this.runTimeStack.isEmpty()){
            throw new RuntimeStackIllegalAccess(new EmptyStackException());
        }
        return this.runTimeStack.remove(lastIndex());
    }

    /**
     * Takes the top item of the run time stack, and stores it into an offset starting from the current frame.
     * @param offsetFromFramePointer number of slots above current frame marker
     * @returns the item just stored
     * @throws RuntimeStackIllegalAccess if offset is out of bounds of current frame
     */
    //like step 4 to 5 from pdf
    public int store(int offsetFromFramePointer) throws RuntimeStackIllegalAccess {
        if (lastIndex() - framePointer.peek() < offsetFromFramePointer){ // check if we are in our current frame
            throw new RuntimeStackIllegalAccess(new EmptyStackException());
        }
        runTimeStack.add(framePointer.peek() + offsetFromFramePointer, runTimeStack.remove(lastIndex()));
        return runTimeStack.get(framePointer.peek() + offsetFromFramePointer);
    }

    /**
     * Takes a value from the run time stack that is at offset from the current frame marker and pushes it onto the top
     * of the stack.
     * @param offsetFromFramePointer number of slots above current frame marker
     * @return item just loaded into the offset
     * @throws RuntimeStackIllegalAccess if offset is out of bounds of current frame
     */
    public int load(int offsetFromFramePointer) throws RuntimeStackIllegalAccess {
            //if our offset is out of bounds of its current frame it'll be bigger than the runtime stack size minus
            //the current framePointer which holds the size of our frame currently
            //if out of bounds throw exception
            if (runTimeStack.size() - framePointer.peek() < offsetFromFramePointer || this.runTimeStack.isEmpty()) {
                throw new RuntimeStackIllegalAccess(new IndexOutOfBoundsException()); //what exception should I use?
            }
            runTimeStack.add(runTimeStack.get(offsetFromFramePointer + framePointer.peek()));
            return runTimeStack.get(lastIndex());
    }

    /**
     * create a new frame pointer at the index offset slots down from the top of the runtime stack.
     * @param offsetFromTopOfRunStack slots down from the top of the runtime stack (for our arguments to be passed)
     */
    public void newFrameAt(int offsetFromTopOfRunStack){
        //add number of new index for new frame into the frame pointer stack,
        framePointer.push((lastIndex() - offsetFromTopOfRunStack) + 1); //+1 because the frame is everything new?
    }

    /**
     * pop the current frame off the runtime stack. Also removes the frame pointer value from the FramePointer Stack.
     * I think that this should already have access to the framePointer
     */
    public void popFrame() throws RuntimeStackIllegalAccess {
        for (int i = lastIndex(); i >= framePointer.peek(); i--){
            this.pop();
        }
        if (framePointer.size() != 1) { //zero should always be loaded into here so if size is one leave zero in here
            framePointer.pop();
        }
    }

    /**
     * Used for dumping the current state of the runTimeStack. It will print portions of the stack based on respective
     * frame markers.
     * Example [1,2,3] [4,5,6] [7,8]
     * Frame pointers would be 0, 3, 6 */
    public String dump(){
        StringBuilder print = new StringBuilder();
        if(runTimeStack.isEmpty()){
            //return "" if the stack is empty
            return print.toString();
        } else if (framePointer.size() == 1){
            //print the whole stack because framePointer only contains 0
            print.append(runTimeStack.toString());
            return print.toString();
        }
        for (int i = 0; i < framePointer.size(); i++) {
            //if we are at our last framePointer but still have more to print
            //from runTimeStack
            if (i == framePointer.size() - 1 && !runTimeStack.isEmpty()){
                print.append(runTimeStack.subList(framePointer.get(i), runTimeStack.size()));
            } else if (!runTimeStack.isEmpty()) { //print between the two framePointer elements
                print.append(runTimeStack.subList(framePointer.get(i), framePointer.get(i + 1)));
            }
        }
        return print.toString();
    }

    /**
     * Get the values of the current frame
     * @return a list filled with the values of the current frame
     */
    public List<Integer> getCurrentFrame (){
        List<Integer> currentFrame = new ArrayList<>();
        //check we have a frame to print
        if (framePointer.size() != 1 && runTimeStack.size() > framePointer.peek()) {
            currentFrame = runTimeStack.subList(framePointer.peek(), runTimeStack.size());
        }
        return currentFrame;
    }
}
