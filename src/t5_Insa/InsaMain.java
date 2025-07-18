package t5_Insa;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InsaMain {

	private JFrame frame;

	public static void main(String[] args) {
		new InsaMain();
	}

	public InsaMain() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("파일 연습");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 90);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("인사관리 프로그램(v1.0)");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 784, 90);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 90, 784, 381);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(InsaMain.class.getResource("/t4_WindowBuilder/images/4.jpg")));
		lblLogo.setBounds(0, 0, 784, 381);
		pn2.add(lblLogo);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 471, 784, 90);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnInput = new JButton("사원등록");
		btnInput.setFont(new Font("굴림", Font.BOLD, 20));
		btnInput.setBounds(37, 10, 149, 70);
		pn3.add(btnInput);
		
		JButton btnSearch = new JButton("개별조회");
		btnSearch.setFont(new Font("굴림", Font.BOLD, 20));
		btnSearch.setBounds(223, 10, 149, 70);
		pn3.add(btnSearch);
		
		JButton btnList = new JButton("전체조회");
		btnList.setFont(new Font("굴림", Font.BOLD, 20));
		btnList.setBounds(409, 10, 149, 70);
		pn3.add(btnList);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(595, 10, 149, 70);
		pn3.add(btnExit);
		
		frame.setVisible(true);
		
		//-----------------위쪽은 디자인, 아래쪽은 메소드-----------------------------------------------------
		
		// 전체조회버튼 마우스 클릭
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new InsaList();
				
			}
		});
		
		// 개별조회버튼 마우스 클릭
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("검색할 성명을 입력하세요");
				InsaDAO dao = new InsaDAO();
				InsaVO vo = dao.getNameSearch(name);
				
				if(vo.getName() == null) JOptionPane.showMessageDialog(frame, "검색한 회원이 없습니다");
				else {
					frame.dispose();
					new InsaSearch(vo);
				}
			}
		});
		
		//사원등록 폼 호출
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsaInput();
			}
		});
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료할까요?", "작업종료", JOptionPane.YES_NO_OPTION);
//				if(ans == 0) System.exit(0);
				
				System.exit(0);
			}
		});
	}
}
