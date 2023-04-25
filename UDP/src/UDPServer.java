import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws Exception {
        int port = 4445;
        QuoteService quoteService = new QuoteService("quotes.txt");

        System.out.println("Number of quotes: " + quoteService.getNumQuotes());

        DatagramSocket serverSocket = new DatagramSocket(port);

        byte[] receiveData = new byte[BUFFER_SIZE];
        byte[] sendData = new byte[BUFFER_SIZE];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            System.out.println("Connection from client: " + clientAddress + ":" + clientPort);

            Quote quote = quoteService.getRandomQuote();
            String json = quote.toJson();
            sendData = json.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);
        }
    }
}
