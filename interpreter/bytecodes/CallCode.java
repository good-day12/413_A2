package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * CALL BYTE CODE
 * Has one argument, a label it needs to jump to, resolveAddress function in program
 * will give the correct address for our address value
 * Call code will store the return address on return stack in VM, then jump to the
 * address specified by the label
 *
 * DUMP: "CALL label f<args> "
 *     where args are the arguments being passed to the function
 * */
public class CallCode implements JumpByteCode {

    private String label;
    private int resolvedAddress;
    private List<Integer> argsForDump = new ArrayList<>();

    @Override
    public void init(ArrayList<String> stringArray) {
        label = stringArray.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.callCode(resolvedAddress);
        argsForDump = vm.getCurrentFrame();
    }

    @Override
    public void dump() { System.out.println("CALL " + label + "f" + argsForDump.toString()); }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setAddress(int address) {
        this.resolvedAddress = address;
    }
}
