package edu.educom.simplechat.client.controller;

import edu.educom.simplechat.client.gui.ClientView;
import org.junit.Test;

/**
 * Created by cmkim on 2014-12-13.
 */
public class ClientControllerTest {
    @Test
    public void testMain() throws Exception {
        final ClientView view = new ClientView();
        view.show();
        view.setEventListener(new ClientController("203.253.207.123", view));
    }
}
