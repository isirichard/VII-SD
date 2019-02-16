package berkeley;

import java.rmi.Remote; 
import java.rmi.RemoteException; 
import java.util.Date;

public interface Berkeley extends Remote { 
    Date getDate() throws RemoteException;
    void setD(long d) throws RemoteException;
    long berkeleyIn(Date c) throws RemoteException;
}
