package berkeley;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class BerkeleyImpl extends UnicastRemoteObject implements Berkeley {
    private long d;

    public BerkeleyImpl() throws RemoteException {
        super();
    }

    public Date getDate() {
        return new Date();
    }
    public void setD(long d){
      this.d = d;
    }
    public long berkeleyIn(Date c){
      //PASO 1: Pedir Hora M
      Date s = new Date();

      //PASO 2: Diferencia
      long dif = s.getTime() - c.getTime();

      //PASO 3: C envia M (devuelve)
      long horaS = s.getTime() + d;
      long horaC = c.getTime() + d/2;

      //PASO 4: S ajusta la diferencia
      long ajusteDif = dif - d/2;
      
      //PASO 5: S calcula la diferencia
      ajusteDif = ajusteDif/2;

      //PASO 6: S ajusta su valor
      horaS = horaS + ajusteDif;


      //PASO 7: S Envia D
      horaS = horaS + d;
      horaC = horaC + d;

      return horaS - horaC;
      //PASO 8: Actualiza C
      //horaC = horaC + return
      
    }

    public static void main(String args[]) { 

        // Create and install a security manager 
        System.setSecurityManager(new RMISecurityManager()); 

        try { 
	    Berkeley obj = new BerkeleyImpl(); 
	    // Bind this object instance to the name "BerkeleyServer" 
      // Naming.rebind("rmi://localhost/HelloServer", obj);
      // Creo un objeto que se levanta en el registro con Naming.
	    Naming.rebind("BerkeleyServer", obj); 
	    System.out.println("BerkeleyServer bound in registry"); 
        } catch (Exception e) { 
	    System.out.println("BerkeleyImpl exception: " + e.getMessage()); 
	    e.printStackTrace(); 
        } 
    } 
}
