package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

/**
 * 3.5 Store ByteCode
 * The Store ByteCode will be used to move values from the top of the run time stack to an offset in the current frame.
 * This offset starts from the beginning of the frame. The idea behind this ByteCode is it is needed to do operations
 * like assignments. The Store ByteCode is not allowed to operate across frame boundaries.
 *
 * 3.5.1 Requirements
 * • The Store ByteCode can have 1 to 2 arguments.
 * – one argument is the offset in the current frame where the value that is popped is
 * to be stored.
 * – The second argument, if present, is the identifier (variable) the value being moved belongs to. This we be
 *      used for dumping.
 * • Store must pop the top of the runtime stack and store the value at the offset in the current frame.
 * • Store cannot operate across frame boundaries.
 * • Store’s offset is strictly positive
 * • If dump is on, Store is required to be dumped.
 * • The Store bytecode cannot detect when it should be dumped nor should it call dump in the VirtualMachine.
 *
 * Dump:
 *     Basic Syntax : STORE <offset> [<id>  <id>=<value-popped>]
 *      <offset> is the index in the current from to load from
 *      <id> is a variable identifier [optional]
 *      Example      :
 *      If we assume the RuntimeStack has the following values
 *      BEFORE executing the Store bytecode:
 *      [0,1,2,3]
 *      Then executing a Store 1 k would produce:
 * STORE 1 k k=3
 */

/**
 * TODO: implement logic
 */

public class StoreCode extends ByteCode {
    @Override
    public void execute(VirtualMachine vm) {

    }

    @Override
    public void dump() {

    }
}