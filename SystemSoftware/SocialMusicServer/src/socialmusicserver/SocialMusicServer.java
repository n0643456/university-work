/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialmusicserver;
import java.net.*;
import java.io.*;
/**
 *
 * @author n0643456
 */
public class SocialMusicServer {
     public static void main(String[] args) {
         

    try 
    {
    DatagramSocket server = new DatagramSocket(9090);
    
    while (true){
        byte[] data = new byte[1024];
        
        DatagramPacket receivedPacket = new DatagramPacket(data,1024);
        
        server.receive(receivedPacket);
         
        data = receivedPacket.getData();
      
        // Gathering user data
        
        String logindetails = new String(data);
    
        int midpoint = logindetails.indexOf( ',' );
        
        // Locating username and password entered
        String username = new String(logindetails.substring(0,(midpoint-1)));
        String password = new String(logindetails.substring(midpoint+1,logindetails.length()));
        
        // Checking for username and password matching in file.
        boolean userFound = false;
        
        try {
            FileReader fin = new FileReader("logins.txt");
            BufferedReader din  = new BufferedReader(fin);
        
            //read file, check username and passwords match
           
        String line = null;
        String userFromFile = null;
        String passFromFile = null;
      
        
        while((line=din.readLine())!= null)
        {
            for(int i = 0; i < line.length(); i++)
            {
                int commaloc = line.indexOf( ',' );
                char ch = line.charAt(i);
                
                if (i < commaloc)
                {
                    userFromFile += ch;
                }
                else if (i > commaloc)
                {
                    passFromFile += ch;
                }
                
            }
            
            if(userFromFile.equals(username) && passFromFile.equals(password) )
            {
                // add to active registers and call the user home screen
                userFound = true;
                 //InetAddress clientAddress = receivedPacket.getAddress();
        
 
       
                 // byte[] newdata = uppercaseMSG.getBytes();
       
                 //int port = receivedPacket.getPort();
        
        
                 // DatagramPacket sendPacket = new DatagramPacket(newdata,data.length,clientAddress,port);
       
                 // server.send(sendPacket);
            }
            else if (userFromFile.equals(username))
            {
                //return error: wrong password
                userFound = true;
                 // byte[] newdata = uppercaseMSG.getBytes();
       
                 //int port = receivedPacket.getPort();
        
        
                 // DatagramPacket sendPacket = new DatagramPacket(newdata,data.length,clientAddress,port);
       
                 // server.send(sendPacket);
            }  
        }
        
        if (userFound == false)
        {
            // Return no user found error.
               // byte[] newdata = uppercaseMSG.getBytes();
       
               //int port = receivedPacket.getPort();
        
        
               // DatagramPacket sendPacket = new DatagramPacket(newdata,data.length,clientAddress,port);
       
               // server.send(sendPacket);
        }
               
        
        }
            catch(IOException e)
                {
                    System.err.println("Error - " + e.getMessage());
                }
        
        //Check these match the username and passwords in file. If so, send packet confirming login.
        //If not, return error message to client.
        
        System.out.println(username);
        
       
        
       
     
}
}
    catch (IOException e)
    {
        System.err.println("Error - " + e.getMessage());
    }
}
}