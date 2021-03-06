package edu.educom.simplechat.server.core;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by cmkim on 2014-12-13.
 */
public class SimpleChatServerCore {
    private boolean alive = false;
    // 서버 소켓과 클라이언트 연결 소켓
    private ServerSocket serverSocket = null;
    private Socket clientSocket = null;

    // 연결된 클라이언트 스레드를 관리하는 ArrayList
    ArrayList<ChatThread> chatlist = new ArrayList<ChatThread>();

    // 멀티챗 메인 프로그램부
    public void start() {
        try {
            // 서버 소켓 생성
            serverSocket = new ServerSocket(8888);
            alive = true;
            System.out.println("server start");

            // 무한루프를 돌면서 클라이언트 연결을 기다림
            while (alive) {
                clientSocket = serverSocket.accept();
                // 연결된 클라이언트에서 스레드 클래스 생성
                ChatThread chat = new ChatThread();
                // 클라이언트 리스트 추가
                chatlist.add(chat);
                // 스레드 시작
                chat.start();
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("[MultiChatServer]start() Exception 발생!");
        }
    }

    /*
    public static void main(String[] args) {
        SimpleChatServerCore server = new SimpleChatServerCore();
        server.start();
    }
    */

    // 연결된 모든 클라이언트에 메시지 중계
    void msgSendAll(String msg) {
        for (ChatThread ct : chatlist) {
            if (ct.outMsg != null) {
                ct.outMsg.println(msg);
                ct.outMsg.flush();
            }
        }
    }

    public void close() {
        alive = false;
    }

    public boolean isAlive(){
        return alive;
    }

    // 각 클라이언트 관리를 위한 스레드 클래스
    class ChatThread extends Thread {

        // 수신 메시지와 파싱 메시지 처리하는 변수 선언
        String msg;
        String[] rmsg;

        // 입출력 스트림 생성
        private BufferedReader inMsg = null;
        private PrintWriter outMsg = null;

        public void run() {
            boolean status = true;
            System.out.println("##ChatThread start...");
            try {
                // 입출력 스트림 생성
                //inMsg = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                //outMsg = new PrintWriter(clientSocket.getOutputStream(), true);
                inMsg = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "utf-8"));
                outMsg = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "utf-8"));

                // 상태정보가 true면 루프를 돌면서 사용자한테서 수신된 메시지 처리
                while (status) {
                    // 수신된 메시지를 msg 변수에 저장
                    if (!inMsg.ready()){    // 버퍼가 준비되지 않았을 경우
                        continue;
                    }
                    msg = inMsg.readLine();
                    // '/' 구분자를 기준으로 메시지를 문자열 배열로 파싱
                    rmsg = msg.split("/");

                    // 파싱된 문자열 배열의 두번째 요소값에 따라 처리
                    if (rmsg.length < 2){
                        System.out.println("It must be empty msg... do not broadcast / msg : " + msg);
                        continue;
                    }
                    // 로그아웃 메시지일 때
                    if (rmsg[1].equals("logout")) {
                        status = logoutMsg();
                    }
                    // 로그인 메시지일 때
                    else if (rmsg[1].equals("login")) {
                        loginMsg();
                    }
                    // 그 밖의 일반 메시지일 때
                    else {
                        etcMsg();
                    }
                } // while 종료
                // 루프를 벗어나면 클라이언트 연결이 종료되므로 스레드 인터럽트됨
                this.interrupt();
                System.out.println("##" + this.getName() + "stop!!");
            } catch (IOException e) {
                chatlist.remove(this);
                // e.printStackTrace();
                System.out.println("[ChatThread]run() IOException 발생!!");
            }
        }

        private void etcMsg() {
            msgSendAll(msg);
        }

        private void loginMsg() {
            msgSendAll("server/" + rmsg[0] + "님이 로그인했습니다.");
        }

        private boolean logoutMsg() {
            boolean status;
            chatlist.remove(this);
            msgSendAll("server/" + rmsg[0] + "님이 종료했습니다.");
            // 해당 클라이언트 스레드 종료로 인해 status를 false로 설정
            status = false;
            return status;
        }
    }
}
