package calc;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {
  public CalculadoraImpl(String name) throws RemoteException {
    super();
    try{
      System.out.print("Invocando el servicio "+name);
      Naming.rebind(name, this);
    }catch(Exception e){
      System.out.print("Exception "+e.getMessage()+e.getStackTrace());
    }
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
  public int sumar(int a, int b)throws RemoteException{
    return a+b;
  }
  public int restar(int a, int b)throws RemoteException{
    return a-b;
  }
  public int multiplicar(int a, int b)throws RemoteException{
    return a*b;
  }
  public int dividir(int a, int b)throws RemoteException{
    return a/b;
  }

}
