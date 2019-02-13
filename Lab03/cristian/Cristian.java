package cristian;

import java.rmi.Remote; 
import java.rmi.RemoteException; 
import java.util.Date;

public interface Cristian extends Remote { 
    Date getDate() throws RemoteException;
}
