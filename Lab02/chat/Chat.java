package chat;

import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

public class Chat extends UnicastRemoteObject implements MessageReceiver {
  PrintStream outuser;

  public void deliverMsg(int fromPeer, String message) throws RemoteException {
    outuser.println("From peer " + fromPeer + ":" + message);
  }

  public Chat() throws RemoteException {
    super();
  }

  void start(BufferedReader inuser, PrintStream outuser, int myNum, MessageReceiver peer1, MessageReceiver peer2,
      MessageReceiver peer3) throws RemoteException, Exception {
    this.outuser = outuser;
    outuser.println("Enter messages:");
    for (;;) {
      String s = inuser.readLine();
      int toNum;
      try {
        toNum = Integer.parseInt(s.substring(0, 1));
        if (toNum < 1 || toNum > 3)
          throw new Exception();
      } catch (Exception e) {
        outuser.println("Error: The first character must be a peer number");
        continue;
      }
      switch (toNum) {
      case 1:
        peer1.deliverMsg(myNum, s);
        break;
      case 2:
        peer2.deliverMsg(myNum, s);
        break;
      case 3:
        peer3.deliverMsg(myNum, s);
        break;
      }
    }
  }
}
