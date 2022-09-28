package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * 3.7 Lit ByteCode
 * The Lit ByteCode is used to push literal values to the runtime stack. In some cases, Lit ByteCodes will be
 * accompanied with an id ( a variable name ), this id represents the variable name the value belongs to. This id is
 * optional.
 *
 * 3.7.1 Requirements
 * • The Lit ByteCode takes 1 or 2 arguments.
 * • The Lit ByteCode must push a value to the RunTimeStack.
 * • Is it not required that the identifier argument exists.
 * • If dumping is on, Lit ByteCode is requried to be dumped.
 * • The Lit bytecode cannot detect when it should be dumped nor should it call dump in the VirtualMachine.
 * 3.7.2 Dumping
 *      Basic Syntax : LIT <value> [<id>  int <id>]
 *      <value> is the value being pushed to RuntimeStack
 *      <id> is a variable identifier [optional]
 * If we were to execute a LIT 0 j then the dump will be
 * LIT 0 j int j
 * if the id is missing then lit has the following dump format:
 *   LIT 0
 */

/**
 * TODO: implement logic
 */

public class LitCode extends ByteCode{

    private int value;
    private String id = "";

    public void init(ArrayList<String> stringArray){
        value = Integer.parseInt(stringArray.get(0));
        if (stringArray.size() > 1) {
            id = stringArray.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushValue(value);
    }

    @Override
    public void dump() {
        if (id.equals("")) {
            System.out.println("LIT " + value);
        } else {
            System.out.println("LIT " + id + " int " + value);
        }
    }
}
