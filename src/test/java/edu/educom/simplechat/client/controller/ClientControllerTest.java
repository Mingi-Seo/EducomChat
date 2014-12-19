package edu.educom.simplechat.client.controller;

import edu.educom.simplechat.client.gui.ClientView;
import edu.educom.simplechat.server.SimpleChatServer;
import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by cmkim on 2014-12-13.
 */
public class ClientControllerTest {

    private static final String TEST_ID = "test";
    static SimpleChatServer server;
    @BeforeClass
    public static void setUp() throws Exception {
        server = new SimpleChatServer();
        server.serverStart();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        server.serverStop();
    }

    @Test
    public void testMain() throws Exception {
        final ClientView view = new ClientView();
        view.setEventListener(new ClientController("192.168.0.25", view));
        view.show();
    }

    @Test
    public void testConnectServer() throws Exception {
        final ClientView view = new ClientView();
        final ClientController controller = new ClientController("192.168.0.25", view);
        view.getEventListener().onLogin(view);
        controller.connectServer();
        assertEquals(true, controller.isConnected());
    }
}
