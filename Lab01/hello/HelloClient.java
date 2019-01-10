package hello;

import java.rmi.Naming; 
import java.rmi.RemoteException; 
import java.rmi.RMISecurityManager;
import java.util.Date;

public class HelloClient {
    
    public static void main(String args[]) {
	
	if (args.length != 1) {
            System.out.println("Usage: java hello.HelloClient host");
            System.exit(1); 
        }

	// Create and install a security manager 
        System.setSecurityManager(new RMISecurityManager()); 
	
	try { 
            // "obj" is the identifier that we'll use to refer 
            // to the remote object that implements the "Hello" interface 
	    Hello obj = (Hello)Naming.lookup("rmi://" + args[0] + "/HelloServer"); 
	    String str = obj.sayHello(); 
	    System.out.println(str);

            // invoke method on server object and locally (to compare dates)
            Date d_remote = obj.getDate();
            Date d_local = new Date();

            System.out.println("Date on server is " + d_remote);
            System.out.println("Date on client is " + d_local);

	} catch (Exception e) { 
	    System.out.println("HelloClient exception: " + e.getMessage()); 
	    e.printStackTrace(); 
	} 
    }
}
