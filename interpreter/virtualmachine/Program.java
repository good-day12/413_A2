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
        //use a map to hold the label's string value as key and index as value
        HashMap<String, Integer> labelMap = new HashMap<String, Integer>();
        //use an ArrayList to hold the JumpByteCodes
        ArrayList<JumpByteCode> conditionList = new ArrayList<>();

        for (int i = 0; i < program.size(); i++){
            ByteCode bc = this.program.get(i);
            //fill our map with the key (our address label) and value, address of current code
            if (bc instanceof LabelCode temp){
                labelMap.put(temp.getLabel(), i);
            }//if not label, check if it is a JumpByteCode
            else if (bc instanceof JumpByteCode temp){
                //add JumpByteCode to conditionList
                conditionList.add(temp);
            }
        } //labelMap will be initialized with all labels and their addresses
        //conditionList will be initialized with all JumpByteCodes

        //go through condition list, grab addresses from labelMap, set those addresses
        //to the JumpByteCode's new address
        for (JumpByteCode jumpByteCode : conditionList) {
            jumpByteCode.setAddress(labelMap.get(jumpByteCode.getLabel()));
        }
    }
}