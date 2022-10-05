package interpreter.bytecodes;

public abstract class JumpByteCode extends ByteCode{

    public abstract void setLabel(String label);

    public abstract String getLabel();

    public abstract void setAddress(int address);
}
