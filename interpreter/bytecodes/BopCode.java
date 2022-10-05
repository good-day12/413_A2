package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * 3.11 Bop ByteCode
 * The Bop ByteCode is used to implement binary operations for the Interpreter Project. The Bop ByteCode will need to
 * remove 2 values from the runtime stack and operate on them accordingly. The result needs to be pushed back to the top
 * of the stack. Be careful, the order of the operands matter.
 *
 * 3.11.1 Requirements
 * • Bop must pop 2 values from the runtime stack.
 * • Bop must push 1 value, the result, back to the top of the runtime stack.
 * • Bop must implement the following binary operations:
 *              +--------------------------+---------------------+
 * BOP +
 * | Addition
 * | Division
 * | Equality
 * | Less-Than Equal
 * | Greater-Than Equal : >= | Greater-Than : > | | Logical And :& | Logical-OR :||
 * :+ :/ : == : <=
 * • If dump is on, the Bop ByteCode is requried to be dumped.
 * • The Bop bytecode cannot detect when it should be dumped nor should it call dump
 * in the VirtualMachine.
 * 3.11.2 Dumping
 * The Pop bytecode has the following dump syntax:
 * BOP operator
 * where operator is the operation executed. For example, if we execute a + operation the, dumping the bytecode would be:
 */

public class BopCode extends ByteCode{
    private String operator;

    @Override
    public void init(ArrayList<String> stringArray) {
        operator = stringArray.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int temp1 = vm.pop(); //temp values to hold our popped values because they need to be reversed
        int temp2 = vm.pop();
        switch (operator) {
            case "+" -> vm.pushValue(temp2 + temp1);
            case "-" -> vm.pushValue(temp2 - temp1);
            case "*" -> vm.pushValue(temp2 * temp1);
            case "/" -> vm.pushValue(temp2 / temp1);
            case "==" -> {
                if (temp2 == temp1){
                    vm.pushValue(1); //1 = true in java
                } else{
                    vm.pushValue(0); //0 = false in java
                }
            }
            case "!=" -> {
                if (temp2 != temp1){
                    vm.pushValue(1); //1 = true in java
                } else{
                    vm.pushValue(0); //0 = false in java
                }
            }
            case "<=" -> {
                if (temp2 <= temp1){
                    vm.pushValue(1); //1 = true in java
                } else{
                    vm.pushValue(0); //0 = false in java
                }
            }
            case "<" -> {
                if (temp2 < temp1){
                    vm.pushValue(1); //1 = true in java
                } else{
                    vm.pushValue(0); //0 = false in java
                }
            }
            case ">=" -> {
                if (temp2 >= temp1){
                    vm.pushValue(1); //1 = true in java
                } else{
                    vm.pushValue(0); //0 = false in java
                }
            }
            case ">" -> {
                if (temp2 > temp1){
                    vm.pushValue(1); //1 = true in java
                } else{
                    vm.pushValue(0); //0 = false in java
                }
            }
            case "&" -> {
                if (temp2 + temp1 == 2){ //if pops are both one, then both are true values
                    vm.pushValue(1); //1 = true in java
                } else{
                    vm.pushValue(0); //0 = false in java
                }
            }
            case "|" -> {
                //if equal to zero than both are false, if one or two, then at least one is true
                if (temp2 +temp1 != 0){
                    vm.pushValue(1); //1 = true in java
                } else{
                    vm.pushValue(0); //0 = false in java
                }
            }
        }
    }

    @Override
    public void dump() {
        System.out.println("BOP " + operator);
    }
}
