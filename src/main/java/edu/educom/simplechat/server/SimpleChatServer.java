package edu.educom.simplechat.server;

import edu.educom.simplechat.server.core.SimpleChatServerCore;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Mingi-Seo on 2014-11-18.
 */
public class SimpleChatServer {
    Thread serverCoreThread;
    public static void main(String[] args) {

    }

    public void serverStart(){
        serverCoreThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new SimpleChatServerCore().start();
            }
        });
        serverCoreThread.start();
    }

    public void serverStop(){
        serverCoreThread.interrupt();
    }
}