
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iopractice;

/**
 *
 * @author n0643456
 */
import java.io.*;
public class IOPractice {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
    
    if (args.length!=3){
        System.err.println("Usage: java ex3 <file> <from> <to>");
        System.err.println("you must supply three argument values");
        System.exit(0);
    }
    else
    {
        String fileName = args[0]; //Argument 1
        int from = Integer.parseInt(args[1]); // 2
        int to = Integer.parseInt(args[2]); // And 3
        
        // Now to create filestream and connect printwriter
    
    try
    {
        FileWriter fout = new FileWriter(fileName,false);
        PrintWriter pout = new PrintWriter(fout, true);
        
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
