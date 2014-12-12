package edu.educom.simplechat.client;

import edu.educom.simplechat.client.controller.ClientController;
import edu.educom.simplechat.client.gui.ClientView;

/**
 * Created by cmkim on 2014-12-12.
 */
public class SimpleChatClient {
    public static void main(String[] args) {
        ClientView clientView = new ClientView();
        ClientController controller = new ClientController("203.253.207.123", clientView);
        clientView.show();
    }
}
