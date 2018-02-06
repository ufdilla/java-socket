
package socket2;
 
import java.net.*;

public class MultithreadedSocketServer 
{
  public static void main(String[] args) throws Exception 
  {
    try
    {
      ServerSocket server = new ServerSocket(4444);
      int counter = 0;
      System.out.println("Server Started ....");
      
      while(true)
      {
        counter++;
        Socket serverClient = server.accept();  
        System.out.println(" >> " + "Client No:" + counter + " is connected!");
        ServerClientThread sct = new ServerClientThread(serverClient,counter); 
        sct.start();
      }
    }
    
    catch(Exception e)
    {
      System.out.println(e);
    }
  } 
}
