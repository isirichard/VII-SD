import java.net.*;
import java.io.*;
import java.util.Random;

public class ipmulticast_s {
  public static void main(String[] args) throws Exception {
    //se captura quien envio el mensaje
    if (args.length != 2) {
      System.out.println("Usage: java ipmulticast_s <your username> <puerto>");
      System.exit(0);
    }
    int port = Integer.parseInt(args[1]);

    //creo el string mensaje y un entero
    String message;
    //contador
    int n = 1;
    //declaro variables de dirección socket paquete random
    InetAddress address = null;
    MulticastSocket socket = null;
    DatagramPacket packet = null;
    Random r = new Random();
    //longitud
    long t;

    try {
      //le brindo una dirección definida
      address = InetAddress.getByName("224.0.0.1");
    } catch (UnknownHostException e) {
      System.out.println("Error: " + e.toString());
    }

    try {
      //creo que el socket grupo
      socket = new MulticastSocket();
      // socket.setTimeToLive(255);
    } catch (IOException e) {
      System.out.println("Error: " + e.toString());
    }

    while (true) {
      //envio mensaje
      message = args[0] + " sender's message #" + Integer.toString(n++);
      //envio en forma de paquete el mensaje
      byte[] data = new byte[8];
      data = message.getBytes();
      packet = new DatagramPacket(data, data.length, address, port);
      //envio el mensaje
      socket.send(packet);
      System.out.println("Sent: " + message);
      //veriodo random t
      t = (r.nextInt(10) + 1) * 100; // value between 100 and 1000
      Thread.sleep(t);
    }
  }
}
