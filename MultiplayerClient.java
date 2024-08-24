import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MultiplayerClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
             
            // Envia e recebe dados do servidor
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}