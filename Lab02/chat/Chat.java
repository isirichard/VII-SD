import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

public class Chat extends UnicastRemoteObject implements MessageReceiver {
  PrintStream outuser;

  public void deliverMsg(String fromPeer,String message) throws RemoteException {
    outuser.println("From peer "+fromPeer+":"+message);
  }

  public Chat() throws RemoteException {
    super();
  }

  void start(BufferedReader inuser, 
             PrintStream outuser,
             String myNam,
             MessageReceiver peer1,
             MessageReceiver peer2,
             MessageReceiver peer3) throws RemoteException,Exception {
    this.outuser=outuser;
    outuser.println("Enter messages:");
    //peer1.toString();
    for(;;) {
      String s=inuser.readLine();     
      String toNam=s.split(" ")[0];
      try {
        
        
      } catch(Exception e) {
        outuser.println("Error: The first character must be a peer number");
        continue;
      }
      switch(toNam) {
        case "uno": peer1.deliverMsg(myNam,s); break;
        case "dos": peer2.deliverMsg(myNam,s); break;
        case "tres": peer3.deliverMsg(myNam,s); break;
      }
    }
  }
}
