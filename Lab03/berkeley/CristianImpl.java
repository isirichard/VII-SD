package cristian;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class CristianImpl extends UnicastRemoteObject
    implements Cristian {

    public CristianImpl() throws RemoteException {
        super();
    }

    public Date getDate() {
        return new Date();
    }

    public static void main(String args[]) { 

        // Create and install a security manager 
        System.setSecurityManager(new RMISecurityManager()); 

        try { 
	    Cristian obj = new CristianImpl(); 
	    // Bind this object instance to the name "CristianServer" 
      // Naming.rebind("rmi://localhost/HelloServer", obj);
      // Creo un objeto que se levanta en el registro con Naming.
	    Naming.rebind("CristianServer", obj); 
	    System.out.println("CristianServer bound in registry"); 
        } catch (Exception e) { 
	    System.out.println("CristianImpl exception: " + e.getMessage()); 
	    e.printStackTrace(); 
        } 
    } 
}
