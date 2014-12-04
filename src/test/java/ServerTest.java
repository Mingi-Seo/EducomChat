import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Mingi-Seo on 2014-12-04.
 */
public class ServerTest {

    private Server server;

    @Before
    public void setUp() throws Exception {
        server = new Server();
    }

    @Test
    public void serverStart() {
        server.start();
    }
}
