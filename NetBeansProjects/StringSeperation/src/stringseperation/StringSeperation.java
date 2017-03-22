/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringseperation;

/**
 *
 * @author n0643456
 */
import java.io.*;

public class StringSeperation {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length!=3){
        System.err.println("Usage: java ex3 <file> <from> <to>");
        System.err.println("you must supply three argument values");
        System.exit(0);
    }
    else
    {
           // Usually this can be a field rather than a method variable
   

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
   
        String fileName = args[0]; //Argument 1
        int min = Integer.parseInt(args[1]); // 2
        int max = Integer.parseInt(args[2]); // And 3
        int[] randNum = new int[max];
        int[] randNum2 = new int[max];
        
       for (int i = min; i < max; i++)
                {
                   randNum[i] =(int) ((Math.random() * (max)) + 1); 
                   randNum2[i]= (int) ((Math.random() * (max) + 1));
                    
                }   
      
        
        // Now to create filestream and connect printwriter
    
    try
    {
        FileWriter fout = new FileWriter(fileName,false);
            //write to file
            try (PrintWriter pout = new PrintWriter(fout, true)) {
                //write to file
                for (int i = min; i < (max); i++)
                {
                    
                    pout.println(randNum[i] + "," + randNum2[i]);
                }   }
    }
    catch(IOException e)
            {
                System.err.println("Error - " + e.getMessage());
            }
    }
    }
        // TODO code application logic here
    }
    

