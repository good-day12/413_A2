package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * Each ByteCode SHOULD implement a method to support dumping of the bytecode
 *
 * should I make this class abstract? or make a parent class and have that be the abstract one?
 */

public abstract class ByteCode {


    public abstract void init(ArrayList<String> stringArray); //do an array type strings

    public abstract void execute(VirtualMachine vm);

    public abstract void dump();


}

