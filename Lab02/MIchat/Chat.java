import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
import java.util.ArrayList;

public class Chat extends UnicastRemoteObject implements MessageReceiver {
  PrintStream outuser;

  public void deliverMsg(String fromPeer,String message) throws RemoteException {
    outuser.println("From peer "+fromPeer+":"+message);
  }
  public void deliverMsg(String fromPeer,String message,String nombres[]) throws RemoteException {
    outuser.println("From peer "+fromPeer+":"+message);
  }
  public Chat() throws RemoteException {
    super();
  }

  void start(BufferedReader inuser, 
             PrintStream outuser,
             String myNam,
             ArrayList<MessageReceiver> peers,
             ArrayList<String> nombres) throws RemoteException,Exception {
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
      for (int i = 0; i < peers.size(); i++) {
        if(toNam.equals(nombres.get(i))){
          peers.get(i).deliverMsg(myNam,s);
          break;
        }
      }
      /*if(toNam.equals(nombres[0])){
        peer1.deliverMsg(myNam,s);
      }
      if(toNam.equals(nombres[1])){
        peer2.deliverMsg(myNam,s);
      }
      if(toNam.equals(nombres[2])){
        peer3.deliverMsg(myNam,s); 
      }*/
     /* switch(toNam) {
        case n1: peer1.deliverMsg(myNam,s); break;
        case n2: peer2.deliverMsg(myNam,s); break;
        case n3: peer3.deliverMsg(myNam,s); break;
      }*/
    }
  }
}
