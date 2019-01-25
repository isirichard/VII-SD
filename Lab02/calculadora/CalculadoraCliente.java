package calculadora;

import java.rmi.Naming; 
import java.rmi.RemoteException; 
import java.rmi.RMISecurityManager;
import java.util.Date;

public class CalculadoraCliente {
    
    public static void main(String args[]) {
	
	if (args.length != 1) {
            System.out.println("Usage: java hello.HelloClient host");
            System.exit(1); 
        }

	// Create and install a security manager 
       // System.setSecurityManager(new RMISecurityManager()); 
	
	try { 
            // "obj" is the identifier that we'll use to refer 
            // to the remote object that implements the "Hello" interface 
	    System.out.println("usando calculadora");
        int res=0;
        Calculadora misuma = (Calculadora) Naming.lookup("rmi://" + args[0]+"/calcu"); 	    
        res = misuma.restar(10,5);
        System.out.println("la suma de  10 y 5 es: "+misuma.restar(10,5));
	    System.out.println("la resta de  10 y 5 es: "+res);
        System.out.println("la multi de  10 y 5 es: "+misuma.multiplicar(10,5));
        System.out.println("la division de  10 y 5 es: "+misuma.dividir(10,5));
        System.out.println("la potencia de  10 a la  5 es: "+misuma.potencia(10,5));
        System.out.println("el cuadrado de  10 es: "+misuma.alCuadrado(10));

            // invoke method on server object and locally (to compare dates)


	} catch (Exception e) { 
	    System.out.println("error en cliente " + e.getMessage()); 
	    e.printStackTrace(); 
	} 
    }
}
