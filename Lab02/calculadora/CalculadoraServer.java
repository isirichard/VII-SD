package calculadora;

import java.rmi.*;

public class CalculadoraServer{
    public static void main(String args[]) { 

        // Create and install a security manager 
        //System.setSecurityManager(new RMISecurityManager()); 

        try { 
	    CalculadoraImpl misuma = new CalculadoraImpl("calcu"); 
	    // Bind this object instance to the name "HelloServer" 
	    // Naming.rebind("rmi://localhost/HelloServer", obj); 
	    //Naming.rebind("HelloServer", obj); 
	    //System.out.println("HelloServer bound in registry"); 
        } catch (Exception e) { 
	    System.out.println("HelloImpl exception: " + e.getMessage()); 
	    e.printStackTrace(); 
        } 
    } 
}
 