import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// Klasse, die den Server startet, auf Verbindungen von Clients wartet und auf
// eingehende Nachrichten reagiert
//Die `main`-Methode startet den Server und erstellt ein `QuoteService`-Objekt
// Dann wird die Anzahl der Zitate ausgegeben und ein `DatagramSocket` auf dem Port 4445 geöffnet
//In der `while`-Schleife wartet der Server auf eingehende Pakete
// Wenn ein Paket empfangen wird, wird die Adresse und der Port des Clients ausgegeben,
// ein zufälliges Zitat aus dem `QuoteService`-Objekt ausgewählt und als JSON-Objekt an
// den Client gesendet

@SuppressWarnings("InfiniteLoopStatement")
public class UDPServer {
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws Exception {
        int port = 4445;
        QuoteService quoteService = new QuoteService("C://Users//felix.schroffner//IdeaProjects//UDPMaven//src//main//java//quotes.txt");

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

