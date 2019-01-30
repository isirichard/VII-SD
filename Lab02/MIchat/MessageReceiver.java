import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

public interface MessageReceiver extends Remote {
  
  public void deliverMsg(String fromPeer, String message) throws RemoteException;
  
  public void deliverMsg(String fromPeer, String message,String[]nombres) throws RemoteException;

}
