import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Mingi-Seo on 2014-12-04.
 */
public class ServerTest {

    private Server server = null;
    private ServerSocket socket = null;

    @Before
    public void setUp() throws Exception {
        server = new Server();
    }

    @Test
    public void serverStart() {
        server.start();
    }

    @Test
    public void serverConnection() throws IOException {
        socket = server.createSocket();
    }
}
