import java.net.InetAddress;
import java.net.UnknownHostException;

public class Hello {
    public static void main(String[] args) {
        try {

            InetAddress uniqueID = InetAddress.getLocalHost();
            String userIP = uniqueID.getHostAddress();
            System.out.println("Hello, " + userIP);
        } 
        catch (UnknownHostException error) {
            System.err.println("i couldn't figure out who you were :/");
        }

    }
}