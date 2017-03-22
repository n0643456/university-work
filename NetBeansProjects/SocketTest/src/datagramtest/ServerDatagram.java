package datagramtest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author n0643456
 */
import java.net.*;
import java.io.*;
/**
 *
 * @author n0643456
 */
public class ServerDatagram {
     public static void main(String[] args) {
         

    try 
    {
    DatagramSocket server = new DatagramSocket(9090);
    
    while (true){
        byte[] data = new byte[1024];
        
        DatagramPacket receivedPacket = new DatagramPacket(data,1024);
        
        
        
        server.receive(receivedPacket);
      
         
        data = receivedPacket.getData();
      
        String message = new String(data);
       
        String uppercaseMSG = message.toUpperCase();
        
        System.out.println(uppercaseMSG);
       
 
       
        byte[] newdata = uppercaseMSG.getBytes();
        
        InetAddress clientAddress = receivedPacket.getAddress();
        int port = receivedPacket.getPort();
        
        
        DatagramPacket sendPacket = new DatagramPacket(newdata,data.length,clientAddress,port);
        System.out.println("sent");
        server.send(sendPacket);
        
       
     
}
}
    catch (IOException e)
    {
        System.err.println("Error - " + e.getMessage());
    }
}
}