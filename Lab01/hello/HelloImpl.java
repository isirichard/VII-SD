package hello;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class HelloImpl extends UnicastRemoteObject
    implements Hello {

    public HelloImpl() throws RemoteException {
        super();
    }

    public String sayHello() {
        return "Kaixo Mikel!";
    }

    public Date getDate() {
        return new Date();
    }

    public static void main(String args[]) { 

        // Create and install a security manager 
        System.setSecurityManager(new RMISecurityManager()); 

        try { 
	    Hello obj = new HelloImpl(); 
	    // Bind this object instance to the name "HelloServer" 
	    // Naming.rebind("rmi://localhost/HelloServer", obj); 
	    Naming.rebind("HelloServer", obj); 
	    System.out.println("HelloServer bound in registry"); 
        } catch (Exception e) { 
	    System.out.println("HelloImpl exception: " + e.getMessage()); 
	    e.printStackTrace(); 
        } 
    } 
}
