
package socket2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
 
class ServerClientThread extends Thread 
{
  Socket serverClient;
  int clientNo;
  int squre;
  String requests;
  
    ServerClientThread(Socket inSocket,int counter)
    {
      serverClient = inSocket;
      clientNo=counter;
    }
    
  public void run()
  {
    try
    {
      DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
      DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
      String clientMessage="", serverMessage="";
    
      while(!clientMessage.equals("bye"))
      {
        clientMessage=inStream.readUTF();
        System.out.println("From Client-" +clientNo+ ": the Request is :"+clientMessage);
//        squre = Integer.parseInt(clientMessage) * Integer.parseInt(clientMessage);
        requests = clientMessage;
//        serverMessage="From Server to Client-" + clientNo + " Square of " + clientMessage + " is " +squre;
        serverMessage="Response for Requests from client : "+ requests;
        outStream.writeUTF(serverMessage);
        outStream.flush();
      }
      
      inStream.close();
      outStream.close();
      serverClient.close();
    }
    
    catch(Exception ex)
    {
      System.out.println(ex);
    }
    
    finally
    {
      System.out.println("Client -" + clientNo + " exit!! ");
    }
  }
}
