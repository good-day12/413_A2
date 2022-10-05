package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * BOP BYTE CODE:
 * Used to execute binary operations on arguments.
 * has one argument, operator, to store the operation it needs to execute
 * the values the operator will execute on will be the top two values of the stack
 *
 * DUMP: "BOP operator" where operator is the symbol of the operation we will be executing
 */

public class BopCode implements ByteCode {
    private String operator; //to hold our operator

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
