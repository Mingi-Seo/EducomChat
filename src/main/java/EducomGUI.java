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

    public EducomGUI(String ip) {
        this.ip = ip;

        // 로그인 패널 구성
        loginPanel = new JPanel();
        // 레이아웃 설정
        loginPanel.setLayout(new BorderLayout());
        idInput = new JTextField(15);
        loginButton = new JButton("로그인");
        // 이벤트 리스너 등록
        loginButton.addActionListener(this);
        label1 = new JLabel("대화명");
        // 패널에 위젯 구성
        loginPanel.add(label1, BorderLayout.WEST);
        loginPanel.add(idInput, BorderLayout.CENTER);
        loginPanel.add(loginButton, BorderLayout.EAST);

        // 로그아웃 패널 구성
        logoutPanel = new JPanel();
        // 레이아웃 설정
        logoutPanel.setLayout(new BorderLayout());
        label2 = new JLabel();
        logoutButton = new JButton("로그아웃");
        // 이벤트 리스너 등록
        logoutButton.addActionListener(this);
        // 패널에 위젯 구성
        logoutPanel.add(label2, BorderLayout.CENTER);
        logoutPanel.add(logoutButton, BorderLayout.EAST);

        // 입력 패널 구성
        msgPanel = new JPanel();
        // 레이아웃 설정
        msgPanel.setLayout(new BorderLayout());
        msgInput = new JTextField(30);
        // 이벤트 리스너 등록
        msgInput.addActionListener(this);
        exitButton = new JButton("종료");
        exitButton.addActionListener(this);
        // 패널에 위젯 구성
        msgPanel.add(msgInput, BorderLayout.CENTER);
        msgPanel.add(exitButton, BorderLayout.EAST);

        // 로그인/로그아웃 패널 선택을 위한 카드 레이아웃 패널
        tab = new JPanel();
        clayout = new CardLayout();
        tab.setLayout(clayout);
        tab.add(loginPanel, "login");
        tab.add(logoutPanel, "logout");

        // 메인 프레임 구성
        jframe = new JFrame("Educom");
        msgOut = new JTextArea("", 10, 30);
        // JTextArea의 내용을 수정하지 못하게 함. 즉, 출력 전용으로 사용
        msgOut.setEditable(false);
        // 수직 스크롤바는 항상 나타내고, 수평 스크롤바는 필요할 때만 나타나게 함
        JScrollPane jsp = new JScrollPane(msgOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jframe.add(tab, BorderLayout.NORTH);
        jframe.add(jsp, BorderLayout.CENTER);
        jframe.add(msgPanel, BorderLayout.SOUTH);
        // 로그인 패널을 우선 표시
        clayout.show(tab, "login");
        // 프레임 크기 자동 설정
        jframe.pack();
        // 프레임 크기 조정 불가 설정
        jframe.setResizable(false);
        // 프레임 표시
        jframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        EducomGUI gui = new EducomGUI("127.0.0.1");
    }
}
