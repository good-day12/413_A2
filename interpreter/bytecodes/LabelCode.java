package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * 3.14 Label ByteCode
 * The Label bytecode is a bytecode that has no functionality. Its sole purpose is to mark locations in the program
 * where other bytecodes can jump to. Label bytecodes will be used in address resolution so other ByteCodes know where
 * they are supposed to jump to.
 *
 * 3.14.1 Requirements
 * • Label takes one argument, a label which is used to denote a location in the program. • If dumping is on, dumping
 * the Label bytecode is optional.
 * 3.14.2 Dumping
 * If you deicde to dump the Label bytecode, it should have the following dump format:
 * LABEL label
 * where label is the string value that is the label of where to jump to.
 */


/**
 * TODO: implement logic
 */
public class LabelCode extends ByteCode{

    private String label;

    @Override
    public void init(ArrayList<String> stringArray) {
        label = stringArray.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    @Override
    public void dump() {
        System.out.println("LABEL " + label);
    }

    public String getLabel (){ return label; }
}
