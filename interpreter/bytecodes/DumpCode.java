package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * DUMP BYTE CODE:
 * Turns dumping on or off, has one argument, either "ON" or "OFF"
 *
 * DUMP: n/a
 */
public class DumpCode implements ByteCode {

    private boolean dumpFlag;

    @Override
    public void init(ArrayList<String> stringArray) {
        if (stringArray.get(0).equals("ON")){
            dumpFlag = true;
        } else{
            dumpFlag = false;
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setDumpFlag(dumpFlag);
    }

    @Override
    public void dump() {
        /*Dump ByteCode is not to be dumped*/
    }
}
