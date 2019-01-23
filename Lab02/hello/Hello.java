package hello;

import java.rmi.Remote; 
import java.rmi.RemoteException; 
import java.util.Date;

public interface Hello extends Remote { 
    String sayHello() throws RemoteException; 
    Date getDate() throws RemoteException;
}
