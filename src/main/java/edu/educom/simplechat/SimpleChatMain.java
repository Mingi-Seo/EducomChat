package edu.educom.simplechat;

import edu.educom.simplechat.client.controller.ClientController;
import edu.educom.simplechat.client.gui.ClientView;
import edu.educom.simplechat.server.SimpleChatServer;

/**
 * Created by cmkim on 2014-12-12.
 */
public class SimpleChatMain {
    public static void main(String[] args) {
        SimpleChatServer server = new SimpleChatServer();
        ClientController client = new ClientController("localhost", new ClientView());

        //server.start();
    }
}
