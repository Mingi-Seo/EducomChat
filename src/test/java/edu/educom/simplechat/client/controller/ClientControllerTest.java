package edu.educom.simplechat.client.controller;

import edu.educom.simplechat.client.gui.ClientView;
import edu.educom.simplechat.server.SimpleChatServer;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by cmkim on 2014-12-13.
 */
public class ClientControllerTest {

    private static final String TEST_ID = "test";

    @Test
    public void testMain() throws Exception {
        final SimpleChatServer server = new SimpleChatServer();
        server.start();
        final ClientView view = new ClientView();
        view.setEventListener(new ClientController("203.253.207.123", view));
        view.show();
        server.close();
    }

    @Test
    public void testConnectServer() throws Exception {
        final SimpleChatServer server = new SimpleChatServer();
        server.start();
        final MockClientView view = new MockClientView();
        final ClientController controller = new ClientController("203.253.207.123", view);
        view.getEventListener().onLogin(view);
        controller.connectServer();
        assertEquals(true, controller.isConnected());
        server.close();
    }

    class MockClientView extends ClientView{
        
    }
}
