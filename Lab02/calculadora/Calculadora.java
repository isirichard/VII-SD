package calculadora;

import java.rmi.Remote; 
import java.rmi.RemoteException; 
import java.util.Date;

public interface Calculadora extends Remote { 
     int sumar(int a, int b) throws RemoteException; 
    public int restar(int a, int b) throws RemoteException; 
     int multiplicar(int a, int b) throws RemoteException; 
    public int dividir(int a, int b) throws RemoteException; 
     int potencia(int a, int b) throws RemoteException; 
    public int alCuadrado(int a) throws RemoteException; 
}
