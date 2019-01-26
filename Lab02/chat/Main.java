import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    // Classes to read from and write to user:
    BufferedReader inuser = new BufferedReader(new InputStreamReader(System.in));
    PrintStream outuser = System.out;

    // Read commandline arguments:
    if(args.length!=4) {
      outuser.println("Syntax: <mynum> <peer1> <peer2> <peer3>");
      outuser.println("Here <mynum> is 1, 2 or 3 depening on which peer we are ourself.");
      return;
    }
    int myNum=Integer.parseInt(args[0]);
    
    // Find registry to use:
    Registry reg;
    outuser.println("Creates new registry on port 7099");
    try {
      reg = LocateRegistry.createRegistry(7099);
    } catch (RemoteException ee) {
      outuser.println("Registry could not be created - assumes one exists already.");
      reg=LocateRegistry.getRegistry(7099);
    }

    // Install security manager:
    System.setSecurityManager(new RMISecurityManager());

    // And start:
    Chat myself=new Chat();
    reg.rebind(args[myNum],myself);
    outuser.println("Press enter when the two peers have started");
    inuser.readLine();

    // Find peers:
    outuser.println("Finding peers");
    MessageReceiver peer1=(MessageReceiver)reg.lookup(args[1]);
    MessageReceiver peer2=(MessageReceiver)reg.lookup(args[2]);
    MessageReceiver peer3=(MessageReceiver)reg.lookup(args[3]);

    // And start application:
    myself.start(inuser,outuser,myNum,peer1,peer2,peer3);
  }
};
