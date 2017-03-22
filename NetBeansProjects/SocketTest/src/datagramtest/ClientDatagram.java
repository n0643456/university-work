package datagramtest;

import java.net.*;
import java.io.*;

/**
 *
 * @author n0643456
 */
public class ClientDatagram {

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
            byte[] data = message.getBytes();
            byte[] received = new byte[1024];
            
            InetAddress hostname = InetAddress.getByName("localhost");
        
            try (DatagramSocket client = new DatagramSocket(20)) {
                
                DatagramPacket sendPacket = new DatagramPacket(data,data.length,hostname,9090);
               
                
                sendPacket.setAddress(hostname);
                
                client.send(sendPacket);
                
                
                DatagramPacket receivedPacket = new DatagramPacket(received,1024);
             
                
                
                client.receive(receivedPacket);
         
    
               received = receivedPacket.getData();
                
               String newmessage = new String(received);
                
                 System.out.println(newmessage);
            }
            
           
// Unfinished
        }
        
        catch (SocketException s)
        {
            System.err.println("Error - " + s.getMessage());
        }
        
        catch (IOException e)
        {
            System.err.println("Error - " + e.getMessage());
        }
        
       
        // TODO code application logic here
       
    }
    }
    }
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author n0643456
 */

