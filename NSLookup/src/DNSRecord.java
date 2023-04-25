import java.io.*;
import java.util.Vector;
import java.util.Arrays;
public class DNSRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    private String host;
    private Vector<String> addresses;

    public DNSRecord(String host, Vector<String> addresses) {
        this.host = host;
        this.addresses = addresses;
    }

    public String getHost() {
        return host;
    }

    public Vector<String> getAddresses() {
        return addresses;
    }

    public static void main(String[] args) {
        DNSRecord record = new DNSRecord("www.google.com", new Vector<String>(Arrays.asList("172.217.14.36", "172.217.14.68", "172.217.14.100")));
        writeRecord(record, "record.ser");
        DNSRecord deserializedRecord = readRecord("record.ser");
        System.out.println(deserializedRecord.getHost());
        System.out.println(deserializedRecord.getAddresses());
    }

    private static void writeRecord(DNSRecord record, String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(record);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static DNSRecord readRecord(String fileName) {
        DNSRecord record = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            record = (DNSRecord) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return record;
    }
}
