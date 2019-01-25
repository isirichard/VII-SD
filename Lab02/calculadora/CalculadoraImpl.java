package calculadora;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class CalculadoraImpl extends UnicastRemoteObject
    implements Calculadora {

    public CalculadoraImpl(String name) throws RemoteException {
        super();
        try{
            System.out.println("iniciando servicio: "+name);
            Naming.rebind(name,this);
        }catch(Exception e){
            System.out.println("ocurrio un error "+e.getMessage());
        }
    }
    
    public int sumar(int a, int b) throws RemoteException {
        return a+b;
    } 
    
    public int restar(int a, int b) throws RemoteException {
        return a-b;
    }
    public int multiplicar(int a, int b) throws RemoteException {
        return a*b;
    }
    public int dividir(int a, int b)  throws RemoteException {
        return a/b;
    }
    public int potencia(int a, int b)throws RemoteException {
        int potencia=a;
        for(int i=0;i<b;i++){
            potencia=potencia*a;
        }
        return potencia;
    }
    public int alCuadrado(int a) throws RemoteException {
        return a*a;
    }

   
}
