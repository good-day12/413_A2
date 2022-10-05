package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.HashMap;
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
     * Will give addresses to jump to corresponding to the label for all jump ByteCodes
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
//        HashMap<String, JumpByteCode> conditionMap = new HashMap<>();
        ArrayList<JumpByteCode> conditionList = new ArrayList<>();


        //downcast this.getCode(i) to (FalseBranchCode) or whatever we need
        //then use labelcode's return address function to get label

        for (int i = 0; i < program.size(); i++){
            ByteCode bc = this.program.get(i);
//fill our map with the key (our address label) and value, address of current code
            if (bc instanceof LabelCode temp){
                labelMap.put(temp.getLabel(), i);
            }
            else if (bc instanceof JumpByteCode temp){
//                conditionMap.put(temp.getLabel(), temp);
                conditionList.add(temp);
            }
        } //labelMap will be initialized with all labels and their addresses
        //conditionList will be initialized with all JumpByteCodes

        for (JumpByteCode jumpByteCode : conditionList) {
            String currLabel = jumpByteCode.getLabel();
            int newAddress = labelMap.get(currLabel);
            jumpByteCode.setAddress(newAddress);
        }

//        for (HashMap.Entry<String,JumpByteCode> entry : conditionMap.entrySet()){
//            //newAddress should hold the int of where our Jump needs to go to
//            int newAddress = labelMap.get(entry.getKey());
//            //now set the corresponding JumpByteCode to the new address
//            entry.getValue().setAddress(newAddress);
//        }
        /*
        what if i was right and I should make two maps, to make this more efficient
        so it could be

        this.getCode(ByteCodeMap.get(Label)).setAddress(labelMap.get(address))

        maybe we could use the putAll function?

        how would this hold up if we add more conditioinal branches?
        should we add another abstract class that implements ByteCode?
        abstract class could be for conditional jumps
         */

    }
}