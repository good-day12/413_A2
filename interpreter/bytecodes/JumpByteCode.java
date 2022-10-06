package interpreter.bytecodes;

public interface JumpByteCode extends ByteCode{

    /**
     * Will set the JumpByteCodes's label value to the given string
     * @param label what we are setting our JumpByteCode's label to
     */
    void setLabel(String label);

    /**
     * Will return the JumpByteCode's current label
     * @return a string representing the current label
     */
    String getLabel();

    /**
     * Will set the JumpByteCode's resolvedAddress to the address given
     * @param address the new address for our resolvedAddress
     */
    void setAddress(int address);
}
