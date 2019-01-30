import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.rmi.registry.*;
import java.io.*;


class Main {
  static String n1="";
  static String n2="";
  static String n3="";
    public static void main(String[] args) throws Exception {
    // Classes to read from and write to user:
    BufferedReader inuser = new BufferedReader(new InputStreamReader(System.in));
    PrintStream outuser = System.out;

    // Read commandline arguments:
    /*if(args.length!=4) {
      outuser.println("Syntax: <myNam> <peer1> <peer2> <peer3>");
      outuser.println("Here <myNam> is 1, 2 or 3 depening on which peer we are ourself.");
      return;
    }*/
    /*String nombres[]=new String[3];
    for (int i = 0; i < 3; i++) {
      nombres[i]=args[i+1];
    }*/
    ArrayList<String> nombres=new ArrayList();
   /* for (int i = 0; i < args.length-1; i++) {
      nombres.add(args[i+1]);
    }*/
    //int myNam=Integer.parseInt(args[0]);
    String myNam=args[0];
    nombres.add(myNam);
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
    /*n1=nombres[0];
    n2=nombres[1];
    n3=nombres[2];*/
    for (int i = 0; i < nombres.size(); i++) {
      if(){
        
      }
      if(myNam.equals(nombres.get(i))){
        reg.rebind(nombres.get(i),myself);
      }
    }
    /*if(myNam.equals(n1)){
      reg.rebind(args[1],myself);
    }
    if(myNam.equals(n2)){
      reg.rebind(args[2],myself);
    }
    if(myNam.equals(n3)){
      reg.rebind(args[3],myself);
    }*/
    //reg.rebind(args[0],myself);
    outuser.println("Press enter when the two peers have started");
    inuser.readLine();

    // Find peers:
    outuser.println("Finding peers");
    ArrayList<MessageReceiver> peers= new ArrayList<>();
    for (int i = 0; i <nombres.size(); i++) {
      peers.add((MessageReceiver)reg.lookup(nombres.get(i)));
    }
   /* MessageReceiver peer1=(MessageReceiver)reg.lookup(args[1]);
    MessageReceiver peer2=(MessageReceiver)reg.lookup(args[2]);
    MessageReceiver peer3=(MessageReceiver)reg.lookup(args[3]);*/

    // And start application:
    myself.start(inuser,outuser,myNam,peers,nombres);
  }
};
