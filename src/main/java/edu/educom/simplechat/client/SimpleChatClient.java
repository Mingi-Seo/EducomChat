package edu.educom.simplechat.client;

import edu.educom.simplechat.client.controller.ClientController;
import edu.educom.simplechat.client.gui.ClientView;

/**
 * Created by cmkim on 2014-12-12.
 */
public class SimpleChatClient {
    public static void main(String[] args) {
        new SimpleChatClient().startApp("203.253.207.123");
    }

    public void startApp(String ip){
        ClientView clientView = new ClientView();
        ClientController controller = new ClientController(ip, clientView);
        clientView.show();
    }
}
