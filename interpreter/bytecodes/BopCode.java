package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.HashMap;

@FunctionalInterface //used for lambda expressions
interface Operate{ //local interface for our lambda expressions only
    int execute(int param1, int param2);
}

public class BopCode implements ByteCode {
    private String operator; //to hold our operator
    //Store our operator as the key, then the lambda expression we want as the value
    static private final HashMap<String, Operate> operatorMap;
    static { //static so it will only run once when class is loaded
        operatorMap = new HashMap<>();
        //create lambda expressions for each operation
        Operate add = (x, y) -> x + y;
        Operate sub = (x, y) -> x - y;
        Operate mul = (x, y) -> x * y;
        Operate div = (x, y) -> x / y;
        Operate eql = (x, y) -> {
            if (x == y) return 1;
            else return 0;
        };
        Operate notEql = (x, y) -> {
            if (x != y) return 1;
            else return 0;
        };
        Operate lessOrEql = (x, y) -> {
            if (x <= y) return 1;
            else return 0;
        };
        Operate lessThan = (x, y) -> {
            if (x < y) return 1;
            else return 0;
        };
        Operate greaterOrEql = (x, y) -> {
            if (x >= y) return 1;
            else return 0;
        };
        Operate greaterThan = (x, y) -> {
            if (x > y) return 1;
            else return 0;
        };
        Operate and = (x, y) -> {
            if (x + y == 2) return 1;
            else return 0;
        };
        Operate or = (x, y) -> {
            if (x + y != 0) return 1;
            else return 0;
        };
        //store these lambda expressions in the HashMap operatorMap along
        //with corresponding operator string value
        operatorMap.put("+", add);
        operatorMap.put("-", sub);
        operatorMap.put("*", mul);
        operatorMap.put("/", div);
        operatorMap.put("==", eql);
        operatorMap.put("!=", notEql);
        operatorMap.put("<=", lessOrEql);
        operatorMap.put("<", lessThan);
        operatorMap.put(">=", greaterOrEql);
        operatorMap.put(">", greaterThan);
        operatorMap.put("&&", and);
        operatorMap.put("||", or);
    }

    @Override
    public void init(ArrayList<String> stringArray) {
        operator = stringArray.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int temp1 = vm.pop(); //temp values to hold our popped values because they need to be reversed
        int temp2 = vm.pop();
        //use the operator as key to get the correct lambda expression value out of operatorMap to use on
        //two temp values, then push that result to the stack in VM
        vm.pushValue(operatorMap.get(operator).execute(temp2, temp1));
    }

    @Override
    public void dump() {
        System.out.println("BOP " + operator);
    }
}
