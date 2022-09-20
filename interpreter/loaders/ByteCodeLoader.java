package interpreter.loaders;

import interpreter.bytecodes.ByteCode;
import interpreter.virtualmachine.Program;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
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
                String line = s.nextLine();
                expressionTokenizer = new StringTokenizer(line, delimiter);
                expressionToken = expressionTokenizer.nextToken();

                String  className = CodeTable.getClassName(expressionToken);

                Class c = Class.forName("edu.sfsu.bytecodes."+ className); //why intelliJ wants Class<?>

                ByteCode bc = (ByteCode) c.getDeclaredConstructor().newInstance();


                while(expressionTokenizer.hasMoreTokens()){
                    expressionToken = expressionTokenizer.nextToken();

                    //what do I do with the leftover tokens? store them in array and use them for init argument?
                }

                //call bc.init()?
                program.addByteCode(bc);
            }


        } catch (FileNotFoundException | ClassNotFoundException | InvocationTargetException | InstantiationException |
                IllegalAccessException | NoSuchMethodException e){
            throw new InvalidProgramException(e);
        }

        return program;
    }
}
