import java.net.*;
import java.io.*;

public class ipmulticast_r {
  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.out.println("Usage: java udp_r <port>");
      System.exit(0);
    }
    // recibimos el puerto dado, mensaje, dirección, socket multiple, packete nulo
    int port = Integer.parseInt(args[0]);
    String message = null;
    InetAddress address = null;
    MulticastSocket socket = null;
    DatagramPacket packet = null;

    try {
      // le damos una dirección
      address = InetAddress.getByName("224.0.0.1");
    } catch (UnknownHostException e) {
      // si ocurre un error imprimimos
      System.out.println("Error: " + e.toString());
    }

    try {
      // se inicializa el socket multicast
      socket = new MulticastSocket(port);
      // se le da al socket la dirección
      socket.joinGroup(address);
    } catch (IOException e) {
      // se captura error
      System.out.println("Error: " + e.toString());
    }
    // esta listo
    System.out.println("ipmulticast_r ready...");

    while (true) {
      // se crea una memoria
      byte buffer[] = new byte[1024];
      // se inicializar el paquete con la memoria
      packet = new DatagramPacket(buffer, buffer.length);
      // el socket recibe la info en la paquete.
      socket.receive(packet);
      // se saca el mensaje
      message = new String(buffer, 0, packet.getLength());
      // se imprime el mensaje de quien
      System.out.println("Received: " + message);
    }
  }
}
