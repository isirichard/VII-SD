package chat;
import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

public interface MessageReceiver extends Remote {
  public void deliverMsg(int fromPeer, String message) throws RemoteException;
}
