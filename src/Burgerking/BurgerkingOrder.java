
package Burgerking;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//주문하기 토핑 빼기 넣기 담기
public class BurgerkingOrder {

	private JFrame frame;
	private JTable orderList;
	BurgerkingDAO dao = new BurgerkingDAO();
	
	private JPanel menuPanel;
	
//	public static void main(String[] args) {
//		new BurgerkingOrder();
//	}

	public BurgerkingOrder() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("주문하기");
		frame.setSize(600, 800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel menuBar = new JPanel();
		menuBar.setBounds(0, 0, 584, 80);
		frame.getContentPane().add(menuBar);
		menuBar.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 78, 584, 451);
		menuBar.add(scrollPane_1);
		
		JButton btnType1 = new JButton("햄버거");
		btnType1.setFont(new Font("굴림", Font.BOLD, 18));
		btnType1.setBounds(12, 31, 124, 37);
		menuBar.add(btnType1);
		
		JButton btnType2 = new JButton("사이드");
		btnType2.setFont(new Font("굴림", Font.BOLD, 18));
		btnType2.setBounds(148, 31, 124, 37);
		menuBar.add(btnType2);
		
		JButton btnType3 = new JButton("음료");
		btnType3.setFont(new Font("굴림", Font.BOLD, 18));
		btnType3.setBounds(286, 31, 124, 37);
		menuBar.add(btnType3);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 77, 584, 451);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 584, 451);
		pn2.add(scrollPane_2);

		// 1. 메뉴 표시용 패널 만들기 (GridLayout: 3열, 행 자동 증가)
		menuPanel = new JPanel(); // 위에서 선언한 필드에 대입
		menuPanel.setLayout(new GridLayout(0, 3, 10, 10)); // 행 자동, 열 3개, 간격 10px
		
		JPanel wrapperPanel = new JPanel();
		wrapperPanel.setLayout(new BoxLayout(wrapperPanel, BoxLayout.Y_AXIS));
		wrapperPanel.add(menuPanel);
		
		// 3. scrollPane_2 설정
		scrollPane_2.setViewportView(wrapperPanel);
		scrollPane_2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		// 스크롤 강제 설정
		scrollPane_2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 528, 414, 233);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 414, 233);
		pn3.add(scrollPane);
		
		orderList = new JTable();
		scrollPane.setViewportView(orderList);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(413, 528, 170, 233);
		frame.getContentPane().add(pn4);
		pn4.setLayout(null);
		
		JButton goOrder = new JButton("주문하기");
		goOrder.setBounds(0, 0, 170, 113);
		pn4.add(goOrder);
		
		JButton goHome = new JButton("취소");
		goHome.setBounds(0, 113, 170, 120);
		pn4.add(goHome);
		
		
		btnType1.addActionListener(e -> loadMenuByKind(1)); // 햄버거
		btnType2.addActionListener(e -> loadMenuByKind(2)); // 사이드
		btnType3.addActionListener(e -> loadMenuByKind(3)); // 음료
		
		// 처음 실행 시 햄버거 메뉴 출력
		loadMenuByKind(1);
		
		frame.setVisible(true);
		
		//-----------------위쪽은 디자인, 아래쪽은 메소드-----------------------------------------------------
		
	}
	// 햄버거 버튼 클릭시
	public void loadMenuByKind(int kind) {
		menuPanel.removeAll(); // 기존 메뉴 제거
		
		List<String> menuList = dao.getMenuByKind(kind);
		
		for (String menuName : menuList) {
			JButton btn = new JButton(menuName);
			btn.setFocusPainted(false);
			menuPanel.add(btn);
		}
		
		menuPanel.revalidate();
		menuPanel.repaint();
	}		
}
