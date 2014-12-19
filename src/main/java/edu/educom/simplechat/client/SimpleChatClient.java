package edu.educom.simplechat.client;

import edu.educom.simplechat.client.controller.ClientController;
import edu.educom.simplechat.client.gui.ClientView;

/**
 * Created by cmkim on 2014-12-12.
 */
public class SimpleChatClient {
    public static void main(String[] args) {
        new SimpleChatClient().startApp("192.168.0.25");
    }

    public void startApp(String ip){
        ClientView clientView = new ClientView();

        //  컨트롤러에게 제어권 위임
        ClientController controller = new ClientController(ip, clientView);

        //  채팅창 보여주는 역할
        clientView.show();
    }
}
