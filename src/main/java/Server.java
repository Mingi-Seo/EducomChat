import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Mingi-Seo on 2014-12-04.
 */
public class Server {
    public void start() {

    }

    public ServerSocket createSocket() throws IOException {
        return new ServerSocket(9999);
    }
}
