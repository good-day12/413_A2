package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interpreter.bytecodes.*;

public class Program {

    private List<ByteCode> program;

    /**
     * Instantiates a program object using an
     * ArrayList
     */
    public Program() {
        program = new ArrayList<>();
    }

    /**
     * Gets the size of the current program.
     * @return size of program
     */
    public int getSize() {
        return program.size();
    }

    /**
     * Grabs an instance of a bytecode at an index.
     * @param programCounter index of bytecode to get.
     * @return a bytecode.
     */
    public ByteCode getCode(int programCounter) {
        return program.get(programCounter);
    }

    /**
     * Adds a bytecode instance to the Program List.
     * @param c bytecode to be added
     */
    public void addByteCode(ByteCode c) {
        program.add(c);
    }

    /**
     * Makes multiple passes through the program ArrayList resolving
     * address for Goto,Call and FalseBranch bytecodes. These bytecodes
     * can only jump to Label codes that have a matching label value.
     * HINT: make note what type of data-structure ByteCodes are stored in.
     * **** METHOD SIGNATURE CANNOT BE CHANGED *****
     */

    /**
     * Resolving symbolic addresses can be done in many ways. It is up to you to design a clean
     * implementation for mapping the generated labels the compiler uses to absolute addresses in
     * the program. An example is given below.
     * The Program class will hold the ByteCode program loaded from the file. It will also resolve
     * symbolic addresses in the program. For example, if we have the following program below
     * 0. FALSEBRANCH continue<<6>>
     * 1. LIT 2
     * 2. LIT 2
     * 3. BOP ==
     * 4. FALSEBRANCH continue<<9>>
     * 5. LIT 1
     * 6. ARGS 1
     * 7. CALL Write
     * 8. STORE O i
     * 9. LABEL continue<<9>>
     * 10. LABEL continue<<6>>
     * After address resolution has been completed the source code should look like the following
     * (NOTE you should not modify the original source code file, these changes are made to the
     * Program object):
     * 0. FALSEBRANCH 10
     * 1. LIT 2
     * 2. LIT 2
     * 3. BOP ==
     * 4. FALSEBRANCH 9
     * 5. LIT 1
     * 6. ARGS 1
     * 7. CALL Write
     * 8. STORE O i
     * 9. LABEL continue<<9>>
     * 10. LABEL continue<<6>>
     */
    public void resolveAddress() {
        //use if/else to go through file if we encounter a falseBranch, call, goto, etc.
        //don't need one for label, will only look for label after we find a falsebranch or goto
        //create ByteCodes to compare with
        ByteCode falseBranch = new FalseBranchCode();
        ByteCode goTo = new GotoCode();
        ByteCode label = new LabelCode();
        ByteCode call = new CallCode();

        //use a map to hold the label's string value as key and index as value
        HashMap<String, Integer> labelMap = new HashMap<String, Integer>();
        HashMap<String, Integer> conditionMap = new HashMap<>();

        //downcast this.getCode(i) to (FalseBranchCode) or whatever we need
        //then use labelcode's return address function to get label

        for (int i = 0; i < program.size(); i++){
//fill our map with the key (our address label) and value, address of current code
            if (this.getCode(i).getClass().equals(label.getClass())){
                LabelCode temp = (LabelCode) this.getCode(i);
                labelMap.put(temp.getLabel(), i);
            }
        } //map will be initialized with all labels and their addresses



        //what if i was right and I should make two maps, to make this more efficient
        //so it oculd be
        /*
        this.getCode(ByteCodeMap.get(Label)).setAddress(labelMap.get(address))

        maybe we could use the putAll function?

        how would this hold up if we add more conditioinal branches?
        should we add another abstract class that implements ByteCode?
        abstract class could be for conditional jumps

                    else if (this.getCode(i).getClass().equals(falseBranch.getClass())){
                FalseBranchCode temp = (FalseBranchCode) this.getCode(i);
                conditionMap.put(temp.getLabel(), i);
            }
            else if (this.getCode(i).getClass().equals(goTo.getClass())){
                GotoCode temp = (GotoCode) this.getCode(i);
                conditionMap.put(temp.getLabel(), i);
            }
            else if (this.getCode(i).getClass().equals(call.getClass())){
                CallCode temp = (CallCode) this.getCode(i);
                conditionMap.put(temp.getLabel(), i);
            }
         */

        for (int i = 0; i < program.size(); i++){
            //if we find a falseBranch
            if (this.getCode(i).getClass().equals(falseBranch.getClass())){
                //set temp to the current FalseBranchCode object
                FalseBranchCode temp = (FalseBranchCode) this.getCode(i);
                //set the address to the corresponding key value of our label
                temp.setAddress(labelMap.get(temp.getLabel()));
                //repeat for goTo and call
            } else if (this.getCode(i).getClass().equals(goTo.getClass())){
                GotoCode temp = (GotoCode) this.getCode(i);
                temp.setAddress(labelMap.get(temp.getLabel()));
            } else if (this.getCode(i).getClass().equals(call.getClass())){
                CallCode temp = (CallCode) this.getCode(i);
                temp.setAddress(labelMap.get(temp.getLabel()));
            }
        }
    }
}

/*
        for (int i = 0; i < program.size(); i++){
//fill our map with the key (our address label) and value, address of current code
            if (this.getCode(i).getClass().equals(label.getClass())){
                LabelCode temp = (LabelCode) this.getCode(i);
                labelMap.put(temp.getLabel(), i);
            }

        } //map will be initialized with all labels and their addresses

        //what if i was right and I should make two maps, to make this more efficient
        //so it oculd be
        /*
        this.getCode(ByteCodeMap.get(Label)).setAddress(labelMap.get(address))

        maybe we could use the putAll function?

        how would this hold up if we add more conditioinal branches?
        should we add another abstract class that implements ByteCode?
        abstract class could be for conditional jumps


        for (int i = 0; i < program.size(); i++){
        //if we find a falseBranch
        if (this.getCode(i).getClass().equals(falseBranch.getClass())){
        //set temp to the current FalseBranchCode object
        FalseBranchCode temp = (FalseBranchCode) this.getCode(i);
        //set the address to the corresponding key value of our label
        temp.setAddress(labelMap.get(temp.getLabel()));
        //repeat for goTo and call
        } else if (this.getCode(i).getClass().equals(goTo.getClass())){
        GotoCode temp = (GotoCode) this.getCode(i);
        temp.setAddress(labelMap.get(temp.getLabel()));
        } else if (this.getCode(i).getClass().equals(call.getClass())){
        CallCode temp = (CallCode) this.getCode(i);
        temp.setAddress(labelMap.get(temp.getLabel()));
        }
        }
 */
