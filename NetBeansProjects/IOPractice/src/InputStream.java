
import java.io.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author n0643456
 */
public class InputStream {
       public static void main(String[] args) {
        // TODO code application logic here
    
    if (args.length!=3){
        System.err.println("Usage: java ex3 <file> <from> <to>");
        System.err.println("you must supply a file name");
        System.exit(0);
    }
    else
    {
        String fileName = args[0]; //Argument 1

        
        // Now to create filestream and connect printwriter
    
    try
    {
        FileReader fin = new FileReader(fileName);
        BufferedReader din  = new BufferedReader(fin);
        
        //write to file
        for (int i = from; i < to; i++)
        {
            pout.println(i);
        }
        pout.close();
    }
    catch(IOException e)
            {
                System.err.println("Error - " + e.getMessage());
            }
    }
    }
    
}
