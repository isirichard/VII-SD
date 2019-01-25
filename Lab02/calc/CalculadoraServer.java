package calc;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class CalculadoraServer {

  public static void main(String args[]) {
    try {
      CalculadoraImpl miSuma = new CalculadoraImpl("Calculadora");

    } catch (Exception e) {
      System.out.println("HelloImpl exception: " + e.getMessage());
      e.printStackTrace();
    }
  }


}
