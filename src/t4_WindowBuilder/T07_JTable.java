package t4_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;

import t5_Insa.InsaMain;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings({ "rawtypes", "unused", "unchecked"})
public class T07_JTable {

	private JFrame frame;
	private JTable table;
	private Vector title, vData;
	
//	InsaDAO dao = new InsaDAO();

	public static void main(String[] args) {
		new T07_JTable();
	}
	public T07_JTable() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("JTable 연습");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 80);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JTable 연습");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 32));
		lblNewLabel.setBounds(105, 10, 284, 60);
		pn1.add(lblNewLabel);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(600, 20, 172, 41);
		pn1.add(btnExit);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 80, 784, 403);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 22, 702, 353);
		pn2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 481, 784, 80);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		//아래쪽으로  JTable 설계하기
		//JTable제작시는 '제목(필드명)'과 '데이터'를 설계하여 Vector 객체 타입으로 준비한다.
		
		//1. '제목'을 Vector에 저장
		title = new Vector();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
		//2.'데이터'를 Vector로 준비...데이터는 DB에서 가져온다.
//		vData = dao.getInsaList();
		
		
		
		frame.setVisible(true);	
		
		//-----------------위쪽은 디자인, 아래쪽은 메소드-----------------------------------------------------
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			// 종료버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
