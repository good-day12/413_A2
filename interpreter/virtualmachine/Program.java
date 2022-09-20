package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;

import interpreter.bytecodes.ByteCode;
import interpreter.bytecodes.FalseBranchCode;
import interpreter.bytecodes.GotoCode;
import interpreter.bytecodes.LabelCode;

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
        //switch statement to go through file if we encounter a falseBranch, call, goto, etc.
        //don't need one for label, will only look for lable after we find a falsebranch or goto
        //create ByteCodes to compare with
        ByteCode falseBranch = new FalseBranchCode();
        ByteCode goTo = new GotoCode();
        ByteCode label = new LabelCode();

        for (int i = 0; i < program.size(); i++){
            //if we find a falseBranch
            if (this.getCode(i).getClass().equals(falseBranch.getClass())){
                for (int j = 0; j < program.size(); j++){//nested loop to find where label of falseBranch goes to
                    if (this.getCode(j).getClass().equals(label.getClass())){
                        //if it equals label we need to check if it is the same label in our falseBranch
//                        if (){
//
//                        }
                    }
                }
            } else if(this.getCode(i).getClass().equals(goTo.getClass())){

            }

        }
    }

}
