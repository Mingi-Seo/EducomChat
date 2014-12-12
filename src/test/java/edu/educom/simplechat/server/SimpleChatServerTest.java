package edu.educom.simplechat.server;

import org.junit.Test;

/**
 * Created by cmkim on 2014-12-13.
 */
public class SimpleChatServerTest {
    @Test
    public void testServerStartAndStop() throws Exception {
        SimpleChatServer server = new SimpleChatServer();
        server.serverStart();
        server.serverStop();
    }
}
