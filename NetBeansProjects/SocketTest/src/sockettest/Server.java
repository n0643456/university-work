package sockettest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;
/**
 *
 * @author n0643456
 */
public class Server {
     public static void main(String[] args) {
         
         
    try 
    {
    ServerSocket server = new ServerSocket(9090);
    
    while (true){
    Socket client = server.accept();
     DataInputStream inFromClient = new DataInputStream(client.getInputStream());
       String message =  inFromClient.readUTF();
        
         System.out.println(message);
       
        String uppercaseMSG = message.toUpperCase();
        
        DataOutputStream OutToClient = new DataOutputStream(client.getOutputStream());
        OutToClient.writeUTF(uppercaseMSG);
       
     
}
}
    catch (IOException e)
    {
        System.err.println("Error - " + e.getMessage());
    }
}
}

