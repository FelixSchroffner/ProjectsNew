import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class DNSLookup {

    public static void main(String[] args) {
        System.out.println(myLookup("www.google.com"));
        System.out.println(myLookup("216.58.214.132"));
        System.out.println(myLookup("not.a.valid.hostname"));
    }

    public static String[] myLookup(String name) {
        try {
            InetAddress[] addresses = InetAddress.getAllByName(name);
            String[] result = new String[addresses.length];
            for (int i = 0; i < addresses.length; i++) {
                result[i] = addresses[i].getHostAddress();
            }
            return result;
        } catch (UnknownHostException e) {
            try {
                InetAddress address = InetAddress.getByName(name);
                return new String[] { address.getHostName() };
            } catch (UnknownHostException ex) {
                return new String[] { "Hostname not found" };
            }
        }
    }
}
