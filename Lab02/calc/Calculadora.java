package calc;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface Calculadora extends Remote {
  public int sumar(int a, int b) throws RemoteException;
  public int restar(int a, int b) throws RemoteException;
  public int multiplicar(int a, int b) throws RemoteException;
  public int dividir(int a, int b) throws RemoteException;

}
