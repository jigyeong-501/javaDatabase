
package Burgerking;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BurgerkingMain {

	private JFrame frame;

	public static void main(String[] args) {
		new BurgerkingMain();
	}
	public BurgerkingMain() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("메인화면");
		frame.setSize(600, 800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 584, 576);
		frame.getContentPane().add(pn1);
		
		JLabel lblMain = new JLabel("");
		lblMain.setIcon(new ImageIcon(BurgerkingMain.class.getResource("/Burgerking/images/main.jpg")));
		
		// 이미지 원본 로드
		ImageIcon originalIcon = new ImageIcon(BurgerkingMain.class.getResource("/Burgerking/images/main.jpg"));
		Image originalImage = originalIcon.getImage();
		
		// 원본 사이즈
		int imgWidth = originalImage.getWidth(null);
		int imgHeight = originalImage.getHeight(null);
		
		// 프레임 너비에 맞춰 비율 유지하면서 새 높이 계산
		int targetWidth = 584;
		int targetHeight = (int) ((double) targetWidth * imgHeight / imgWidth);
		
		// 리사이즈
		Image resizedImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
		pn1.setLayout(null);

		// JLabel에 적용
		lblMain.setBounds(0, 0, targetWidth, targetHeight);
		lblMain.setIcon(new ImageIcon(resizedImage));
		pn1.add(lblMain);
		
		JButton btnMaster = new JButton("직원용");
		btnMaster.setFont(new Font("굴림", Font.BOLD, 16));
		btnMaster.setBounds(478, 10, 94, 34);
		pn1.add(btnMaster);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 576, 584, 185);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JButton btnNewButton = new JButton("주문하기");
		
		btnNewButton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 25));
		btnNewButton.setBackground(new Color(255, 128, 64));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(56, 30, 476, 112);
		pn2.add(btnNewButton);
		
		frame.setVisible(true);
		
		//-----------------위쪽은 디자인, 아래쪽은 메소드-----------------------------------------------------
		
		// 직원용 버튼 화면이동
		btnMaster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BurgerkingOrder();
		        frame.dispose();
			}
		});
		
		// 주문하기 버튼 화면이동
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BurgerkingOrder();
		        frame.dispose();
			}
		});
		
		// 종료버튼
//		btnExit.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {				
//				System.exit(0);
//			}
//		});
	
	}
}
