package edu.educom.simplechat.client;

import edu.educom.simplechat.client.controller.ClientController;
import edu.educom.simplechat.client.gui.ClientView;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Mingi-Seo on 2014-12-04.
 */
public class ClientTest {
    @Test
    public void testClient() {
        new SimpleChatClient().startApp("192.168.0.25");
    }
}
