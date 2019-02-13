package cristian;

import java.rmi.Naming; 
import java.rmi.RemoteException; 
import java.rmi.RMISecurityManager;
import java.util.Date;

public class CristianClient {
    
    public static void main(String args[]) {
	
	if (args.length != 1) {
            System.out.println("Usage: java cristian.CristianClient host");
            System.exit(1); 
        }

	// Create and install a security manager 
        System.setSecurityManager(new RMISecurityManager()); 
	
	try { 
            // "obj" is the identifier that we'll use to refer 
            // to the remote object that implements the "Cristian" interface
            // Capturo el objeto del servidor
	    Cristian obj = (Cristian)Naming.lookup("rmi://" + args[0] + "/CristianServer");

            // Here we go...
            // Objeto las horas locales y del servidor
            Date d_local_1 = new Date();
            Date d_remote = obj.getDate();
            Date d_local_2 = new Date();
      
            System.out.println("Time before RMI on client is " + d_local_1 + " (" + d_local_1.getTime() + " ms)");
            System.out.println("Time after  RMI on client is " + d_local_2 + " (" + d_local_2.getTime() + " ms)");
            System.out.println("Time returned by server is   " + d_remote  + " (" + d_remote.getTime()  + " ms)");

            //calculo la diferencia entre tiempos en el cliente tiempo total de envio y respuesta con el servidor
            long d = d_local_2.getTime() - d_local_1.getTime();
            System.out.println("Request duration (D) is " + d + " ms");

            //Por default el servidor siempre tendra hora retrasada
            //resto a la hora final del cliente la mitad de tiempo de acceso = servidor y resto la hora capturada del servidor
            //erro de la horas
            long theta = d_local_2.getTime() - d/2 - d_remote.getTime();
            System.out.println("Clock skew (Theta) is " + theta + " ms");
            //tiempo de envio entre el servidor y cliente
            System.out.println("Accuracy is +/-" + d/2 + " ms");
            System.out.println("Is it possible to have a more precise accuracy? (Hint: try 'ping " + args[0] +"')");
	} catch (Exception e) { 
	    System.out.println("HelloClient exception: " + e.getMessage()); 
	    e.printStackTrace(); 
	} 
    }
}
