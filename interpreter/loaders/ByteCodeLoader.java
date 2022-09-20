package interpreter.loaders;

import interpreter.bytecodes.ByteCode;
import interpreter.virtualmachine.Program;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public final class ByteCodeLoader {
    private String codSourceFileName;
    
    /**
     * Constructs ByteCodeLoader object given a COD source code
     * file name
     * @param fileName name of .cod File to load.
     */
    public ByteCodeLoader(String fileName){
        this.codSourceFileName = fileName;
    }
    
    /**
     * TODO: implement logic
     * Loads a program from a .cod file.
     * @return a constructed Program Object.
     * @throws InvalidProgramException exception thrown when 
     * loadCodes fails.
     */
    public Program loadCodes() throws InvalidProgramException {
        String delimiter = " ";
        StringTokenizer expressionTokenizer;
        String expressionToken;
        Program program = new Program();
        CodeTable.init();

        try {
            Scanner s = new Scanner(new File(codSourceFileName));
            while (s.hasNextLine()){
                String line = s.nextLine();//variable to hold line read from file
                expressionTokenizer = new StringTokenizer(line, delimiter);//tokenize line read
                expressionToken = expressionTokenizer.nextToken();//store next token (our class name)
                String  className = CodeTable.getClassName(expressionToken);//use class name to create instance of class
                Class<?> c = Class.forName("interpreter.bytecodes."+ className); //create class with this name
                ByteCode bc = (ByteCode) c.getDeclaredConstructor().newInstance();//create bytecode out of this class

                //use this array to store our arguments, will pass this to init function
                ArrayList<String> tokens = new ArrayList<>(); //to hold our arguments passed as tokens
                while(expressionTokenizer.hasMoreTokens()){
                    tokens.add(expressionTokenizer.nextToken());
                }
                bc.init(tokens); //initialize our ByteCode with the tokens arrayList of strings
                program.addByteCode(bc); //add the initialized byteCode to our program
            }

//catch errors thrown by getDeclaredConstructor and file not found error from scanner
        } catch (FileNotFoundException | ClassNotFoundException | InvocationTargetException | InstantiationException |
                IllegalAccessException | NoSuchMethodException e){

            throw new InvalidProgramException(e);
        }

        return program;
    }
}
