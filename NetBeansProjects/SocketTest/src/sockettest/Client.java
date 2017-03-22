/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettest;
import java.net.*;
import java.io.*;

/**
 *
 * @author n0643456
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if (args.length!=1){
        System.err.println("Usage: java ex3 <file> <from> <to>");
        System.err.println("you must supply an argument value");
        System.exit(0);
    }
    else
    {
        String message = args[0]; //Argument 1
        
        try
        {
        InetAddress address = InetAddress.getByName("localhost");
         Socket server = new 
        Socket(address,9090);
         
          
        
        DataOutputStream outToServer = new DataOutputStream(server.getOutputStream());
        outToServer.writeUTF(message);
        
        
        
        DataInputStream inFromServer = new DataInputStream(server.getInputStream());
        String uppercaseMSG = inFromServer.readUTF();
        
        System.out.println(uppercaseMSG);
        
        }
        
        catch (UnknownHostException u)
        {
            System.err.println("Error - " + u.getMessage());
        }
        
        catch (IOException e)
        {
            System.err.println("Error - " + e.getMessage());
        }
        
       
        // TODO code application logic here
       
    }
    }
    }
    

