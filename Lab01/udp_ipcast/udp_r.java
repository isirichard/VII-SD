import java.net.*;

// This program waits to receive datagrams sent to a specified port.
// Este programa espera recibir los datagramas enviados a un puerto específico
// When it receives one, it displays the sending host and port,
// Cuando recibe uno, muestra el host de envío y el puerto,
// and prints the contents of the datagram as a string.
// e imprime el contenido del datagrama como una cadena.

public class udp_r {
    public static void main(String args[]) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java udp_r <port>");
            System.exit(0);
        }

        int port = Integer.parseInt(args[0]);

        byte[] buffer = new byte[1024];
        String s;

        // Create a socket to listen on the port.
        // Crea un socket para escuchar en el puerto.
        DatagramSocket socket = new DatagramSocket(port);
        System.out.println("Reception socket created...");

        long expected = 1;
        
        for(;;) {
            // Create a packet with an empty buffer to receive data
            // Crear un paquete con un búfer vacío para recibir datos
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Wait to receive a datagram
            // Espera recibir un datagrama
            socket.receive(packet);
            socket.send(packet);

            // Convert the contents to a string
            // Convertir el contenido en una cadena
            s = new String(buffer, 0, packet.getLength());

            // Get the seuqence number as a long
            // Obtener el número de secuencia como un largo
            long sequence_number = Long.parseLong(s);
            // el expected es el número de paquete que calculo y espero 
            // el número de secuencia es lo que recibo en el datagrama
            if (sequence_number <= expected) {
                expected++;
                System.out.println("udp_r: received from " + 
                           packet.getAddress().getHostName() + ":" +
                           packet.getPort() + ": " + s);
            }
            else {
                System.out.println("ERROR: unexpected sequence number: " + sequence_number);
                System.exit(-1);
            }
            
        }
        
    }
}

// Varios emisores a un receptor
// ¿Que sucedes y por qué? Se crashea error, por el codigo de comparación.

