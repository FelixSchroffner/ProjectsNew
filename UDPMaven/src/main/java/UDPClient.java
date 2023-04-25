
// Klasse für den UDP-Client, um eine Verbindung zum Server aufzubauen
// und das empfangene JSON-Objekt zu deserialisieren

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws Exception {
        String serverHostname = "localhost";
        int serverPort = 4445;

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName(serverHostname);

        byte[] receiveData = new byte[BUFFER_SIZE];
        byte[] sendData = new byte[BUFFER_SIZE];

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String json = new String(receivePacket.getData(), 0, receivePacket.getLength());
        Quote quote = Quote.fromJson(json);

        System.out.println("Quote: " + quote.getQuote());
        System.out.println("Author: " + quote.getAuthor());

        clientSocket.close();
    }
}
