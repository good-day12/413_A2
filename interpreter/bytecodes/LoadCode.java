package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * 3.6 Load ByteCode
 * The Load ByteCode will be used to move values from an offset in the current frame to the top of the stack. This
 * offset works from the beginning of the frame. The purpose behind this ByteCode is it is needed to setup copies of
 * values for things like expressions and arguments for functions. The load ByteCode is not allowed to operate across
 * frame boundaries.
 *
 * 3.6.1 Requirements
 * • The Load ByteCode can have 1 to 2 arguments.
 * – one argument is the offset in the current frame where the value is to be copied
 * from.
 * – The second argument, if present, is the identifier (variable) the value belongs to. This we be used for dumping.
 * • Load must copy the value at the offset in the current and push it to the top of the stack.
 * • Load must not remove any values from the runtime stack.
 * • Load cannot operate across frame boundaries.
 * • Loads’s offset is strictly positive.
 * • Is it not required that the identifier argument exists.
 * • If dump is on, Load is requried to be dumped.
 * • The Load bytecode cannot detect when it should be dumped nor should it call dump
 * in the VirtualMachine.
 *
 * 3.6.2 Dumping
 *      Basic Syntax : LOAD <offset> [<id>  <load id>]
 *      <offset> is the index in the current from to load from
 *      <id> is a variable identifier
 *      Example      : LOAD 2 j     <load j>
 * If id is missing then then dumping load will just be:
 * LOAD offset
 * therefore, using the above example, we have:
 *   LOAD 2
 */

/**
 * TODO: implement logic
 */

public class LoadCode extends ByteCode{

    private int offset;
    private String id;

    public void init(ArrayList<String> stringArray){
        offset = Integer.parseInt(stringArray.get(0));
        id = stringArray.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    @Override
    public void dump() {

    }
}
