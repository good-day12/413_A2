package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * 3.15 Dump ByteCode
 * The Dump ByteCode is used to turn dumping ON and OFF. Dumping in the interpreter project is only done when dumping is
 * ON.
 *
 * 3.15.1 Requirements
 * • The Dump ByteCode has 1 argument. Either ”ON” or ”OFF”
 * • The Dump ByteCode must request the VirtualMachine to turn dumping either ”ON”
 * or ”OFF”.
 * • The Dump ByteCode is NOT TO BE DUMPED.
 */

/**
 * TODO: implement logic
 */

public class DumpCode extends ByteCode{

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
        if (dumpFlag){
            //run vm.dump function
        }

    }

    @Override
    public void dump() {

    }
}
