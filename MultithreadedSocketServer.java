/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket2;
 
import java.net.*;

public class MultithreadedSocketServer 
{
  public static void main(String[] args) throws Exception 
  {
    try
    {
      ServerSocket server=new ServerSocket(4444);
      int counter=0;
      System.out.println("Server Started ....");
      while(true){
        counter++;
        Socket serverClient = server.accept();  //server accept the client connection request
        System.out.println(" >> " + "Client No:" + counter + " is connected!");
        ServerClientThread sct = new ServerClientThread(serverClient,counter); //send  the request to a separate thread
        sct.start();
      }
    }catch(Exception e){
      System.out.println(e);
    }
  }
  
}
