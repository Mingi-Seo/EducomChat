import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Mingi-Seo on 2014-12-12.
 */
public class EducomGUI implements ActionListener, Runnable {
    private String ip;
    private String id;
    private Socket socket;
    private BufferedReader inMsg = null;
    private PrintWriter outMsg = null;

    // 로그인 패널
    private JPanel loginPanel;
    // 로그인 버튼
    private JButton loginButton;
    // 대화명 라벨
    private JLabel label1;
    // 대화명 입력 텍스트 필드
    private JTextField idInput;

    // 로그아웃 패널 구성
    private JPanel logoutPanel;
    // 대화명 출력 라벨
    private JLabel label2;
    // 로그아웃 버튼
    private JButton logoutButton;

    // 입력 패널 구성
    private JPanel msgPanel;
    // 메시지 입력 텍스트 필드
    private JTextField msgInput;
    // 종료 버튼
    private JButton exitButton;

    // 메인 윈도우
    private JFrame jframe;
    // 채팅 내용 출력 창
    private JTextArea msgOut;

    // 카드 레이아웃 관련
    private Container tab;
    private CardLayout clayout;
    private Thread thread;

    // 상태 플래그
    boolean status;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }
}
