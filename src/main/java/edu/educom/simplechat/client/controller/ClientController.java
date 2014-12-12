package edu.educom.simplechat.client.controller;

import edu.educom.simplechat.client.gui.ClientView;

import java.io.*;
import java.net.Socket;

/**
 * Created by Mingi-Seo on 2014-11-18.
 */
public class ClientController implements ClientView.ClientEventListener, Runnable {
    private final ClientView view;
    private String ip;
    private String id;
    private Socket socket;
    private BufferedReader inMsg = null;
    private PrintWriter outMsg = null;

    private Thread thread;

    // 상태 플래그
    boolean status;


    public ClientController(String ip, ClientView view) {
        this.ip = ip;
        this.view = view;
        view.setEventListener(this);
    }

    public void connectServer(String id) {
        try {
            // 소켓 생성
            socket = new Socket(ip, 8888);
            System.out.println("[Client]Server 연결 성공!");

            // 입출력 스트림 생성
            inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
            //outMsg = new PrintWriter(socket.getOutputStream(), true);
            outMsg = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));

            // 서버에 로그인 메시지 전달
            outMsg.println(id + "/" + "login");
            outMsg.flush();
            // 메시지 수신을 위한 스레드 생성
            thread = new Thread(this);
            thread.start();
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("[MultiChatClient]connectServer() Exception 발생!!");
        }
    }

    public void run() {
        // 수신 메시지를 처리하는 변수
        String msg;
        String[] rmsg;

        status = true;

        while (status) {
            try {
                // 메시지 수신과 파싱
                msg = inMsg.readLine();
                rmsg = msg.split("/");

                // JTextArea에 수신된 메시지 추가
                view.msgOut.append(rmsg[0] + ">" + rmsg[1] + "\n");

                // 커서를 현재 대화 메시지에 표시
                view.msgOut.setCaretPosition(view.msgOut.getDocument().getLength());
            } catch (IOException e) {
                // e.printStackTrace();
                status = false;
            }
        }

        System.out.println("[MultiChatClient]" + thread.getName() + "종료됨");
    }

    public static void main(String[] args) {
        //ClientController mcc = new ClientController("203.253.207.123");
        //EduComClient mcc = new EduComClient("127.0.0.1");
        final ClientView view = new ClientView();
        view.show();
        view.setEventListener(new ClientController("203.253.207.123", view));
    }


    @Override
    public void onExit(ClientView view) {
        System.exit(0);
    }

    @Override
    public void onLogin(ClientView view) {
        id = view.idInput.getText();
        view.label2.setText("대화명 : " + id);
        view.clayout.show(view.tab, "logout");
        connectServer(id);
    }

    @Override
    public void onLogout(ClientView view) {
        // 로그아웃 메시지 전송
        outMsg.println(id + "/" + "logout");
        // 대화 창 클리어
        view.msgOut.setText("");
        // 로그인 패널로 전환
        view.clayout.show(view.tab, "login");
        outMsg.close();
        try {
            inMsg.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        outMsg.flush();
        status = false;
    }

    @Override
    public void onMsgSend(ClientView view) {
        // 메시지 전송
        outMsg.println(id + "/" + view.msgInput.getText());
        // 입력 창 클리어
        view.msgInput.setText("");
        outMsg.flush();
    }
}