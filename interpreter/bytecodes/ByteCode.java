package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

/**
 * Each ByteCode SHOULD implement a method to support dumping of the bytecode
 *
 * should I make this class abstract? or make a parent class and have that be the abstract one?
 */

public abstract class ByteCode {

public abstract void execute(VirtualMachine vm);

public abstract void dump();


}
