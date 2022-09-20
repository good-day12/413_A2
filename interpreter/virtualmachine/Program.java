package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;

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

        //create Integer array to keep track of indexes
        ArrayList<Integer> falseBranchIndexes = new ArrayList<>();
        ArrayList<Integer> goToIndexes = new ArrayList<>();
        ArrayList<Integer> labelIndexes = new ArrayList<>();
        ArrayList<Integer> callIndexes = new ArrayList<>();

        //use an array to keep track of indexes where you find them, no nested loops

        //downcast this.getCode(i) to (FalseBranchCode) or whatever we need
        //then use labelcode's return address function to get label

        for (int i = 0; i < program.size(); i++){
//fill our respective lists with index occurrences of each type
            if (this.getCode(i).getClass().equals(falseBranch.getClass())){
                falseBranchIndexes.add(i);
            } else if (this.getCode(i).getClass().equals(goTo.getClass())){
                goToIndexes.add(i);
            } else if (this.getCode(i).getClass().equals(label.getClass())){
                labelIndexes.add(i);
            } else if (this.getCode(i).getClass().equals(call.getClass())){
                callIndexes.add(i);
            }

        }

        //now our indexes arrays are full with corresponding index for each entry
        LabelCode tempLabel;
        //handle falseBranch code bytes
        for (int i = 0; i < falseBranchIndexes.size(); i++){
            //cast our falseBranch CodeByte from the program to temp variable
            FalseBranchCode temp = (FalseBranchCode) this.getCode(falseBranchIndexes.get(i));
            for (int j = 0; j < labelIndexes.size(); j++){
                //cast our labelCode to compare with
                tempLabel = (LabelCode) this.getCode(labelIndexes.get(j));
                if (temp.getLabel().equals(tempLabel.getLabel())){
                    temp.setAddressOfLabel(labelIndexes.get(j));
                    labelIndexes.remove(j);
                }
            }
        }
        //handle goTo code bytes
        for (int i = 0; i < goToIndexes.size(); i++){
            //cast our falseBranch CodeByte from the program to temp variable
            GotoCode temp = (GotoCode) this.getCode(goToIndexes.get(i));
            for (int j = 0; j < labelIndexes.size(); j++){
                //cast our labelCode to compare with
                tempLabel = (LabelCode) this.getCode(labelIndexes.get(j));
                if (temp.getLabel().equals(tempLabel.getLabel())){
                    temp.setAddress(labelIndexes.get(j));
                    labelIndexes.remove(j); //idk why this is suspicious
                }
            }
        }
        //handle Call code bytes
        for (int i = 0; i < callIndexes.size(); i++){
            //cast our falseBranch CodeByte from the program to temp variable
            CallCode temp = (CallCode) this.getCode(callIndexes.get(i));
            for (int j = 0; j < labelIndexes.size(); j++){
                //cast our labelCode to compare with
                tempLabel = (LabelCode) this.getCode(labelIndexes.get(j));
                if (temp.getLabel().equals(tempLabel.getLabel())){
                    temp.setAddress(labelIndexes.get(j));
                    labelIndexes.remove(j);
                }
            }
        }
    }

}
