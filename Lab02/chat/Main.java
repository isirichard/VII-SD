package chat;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    // Clases para leer y escribir al usuario:
    // Classes to read from and write to user:
    BufferedReader inuser = new BufferedReader(new InputStreamReader(System.in));
    PrintStream outuser = System.out;

    // Lee los argumentos de la línea de comando:
    if(args.length!=4) {
      outuser.println("Syntax: <mynum> <peer1> <peer2> <peer3>");
      // Aquí <mi número> es 1, 2 o 3 dependiendo de cual somos nosotros mismos
      outuser.println("Here <mynum> is 1, 2 or 3 depening on which peer we are ourself.");
      return;
    }
    int myNum=Integer.parseInt(args[0]);
    // Encontrar el registro a usar
    // Find registry to use:
    Registry reg;
    outuser.println("Creates new registry on port 7099");
    try {
      reg = LocateRegistry.createRegistry(7099);
    } catch (RemoteException ee) {
      //sino se crea ya se creo
      outuser.println("Registry could not be created - assumes one exists already.");
      reg=LocateRegistry.getRegistry(7099);
    }

    // Install security manager:
    // Instalar el administrador de seguridad:
    System.setSecurityManager(new RMISecurityManager());

    // And start:
    // y iniciar
    Chat myself=new Chat();
    reg.rebind(args[myNum],myself);
    // Presione enter cuando los dos compañeros hayan comenzado
    outuser.println("Press enter when the two peers have started");
    inuser.readLine();
    
    // Encontrar compañeros
    // Find peers:
    outuser.println("Finding peers");
    MessageReceiver peer1=(MessageReceiver)reg.lookup(args[1]);
    MessageReceiver peer2=(MessageReceiver)reg.lookup(args[2]);
    MessageReceiver peer3=(MessageReceiver)reg.lookup(args[3]);

    // Y comenzar la aplicación:
    // And start application:
    myself.start(inuser,outuser,myNum,peer1,peer2,peer3);
  }
};
