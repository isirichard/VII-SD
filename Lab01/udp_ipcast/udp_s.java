import java.net.*;

// This program sends periodically a datagram to the specified (host & port)
// Este programa envía periódicamente un datagrama al especificado (host y puerto)
public class udp_s {
    public static void main(String args[]) throws Exception {
        if (args.length != 3) {
            System.out.println("Usage: java udp_s <host> <port> <period in ms>");
            System.exit(0);
        }

        // Get the internet address of the specified host and the port number
        // Obtenga la dirección de Internet del host especificado y el número de p
        // erto
        InetAddress address = InetAddress.getByName(args[0]);
        int port = Integer.parseInt(args[1]);

        // Create a socket, and send the packet through it
        // Crea un socket, y envía el paquete a través de él.
        DatagramSocket socket = new DatagramSocket();
        System.out.println("Sending socket created...");

        String s,s2 = new String();
        long sequence_number = 0;

        long period = Long.parseLong(args[2]);

        for (;;) {
            sequence_number++;
            Long sequence = new Long(sequence_number);
            s = sequence.toString();

            // Convert the string s to an array of bytes
            // Convertir la cadena s a una matriz de bytes
            byte[] message = new byte[1024];
            message = s.getBytes();

            // Initialize the packet with data and address
            // Inicializar el paquete con datos y dirección
            DatagramPacket packet = new DatagramPacket(message, s.length(), address, port);

            // send the packet through the socket
            // // enviar el paquete a través del zócalo
            System.out.println("udp_s: sending message " + sequence_number);
            socket.send(packet);
            socket.receive(packet);
            byte[] buffer = new byte[1024];
            s2 = new String(buffer, 0, packet.getLength());
            long sequence2 = Long.parseLong(s);
            if (sequence_number == sequence2) {
              System.out.println("ping recibido ");
            }
            else{
              System.out.println("Tiempo de respuesta agotada");
            }

            // Wait for period milliseconds
            // Espera por periodo milisegundos
            Thread.sleep(period);
        }
    }
}
