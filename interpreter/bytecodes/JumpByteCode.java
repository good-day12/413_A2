package interpreter.bytecodes;

public interface JumpByteCode extends ByteCode{

    public abstract void setLabel(String label);

    public abstract String getLabel();

    public abstract void setAddress(int address);
}
