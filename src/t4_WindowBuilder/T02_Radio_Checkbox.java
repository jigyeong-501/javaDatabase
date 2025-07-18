package t4_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class T02_Radio_Checkbox {

	private JFrame frame;
	private final JLabel lblTitle = new JLabel("라디오버튼/ 체크박스 연습");
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static void main(String[] args) {
		new T02_Radio_Checkbox();
	}

	public T02_Radio_Checkbox() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("라디오 체크박스 연습");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(0, 255, 255));
		pn1.setBounds(0, 0, 784, 82);
		frame.getContentPane().add(pn1);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 34));
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setBounds(0, 79, 784, 403);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("굴림", Font.BOLD, 20));
		lblGender.setBounds(12, 37, 147, 45);
		pn2.add(lblGender);
		
		JLabel lblHobby = new JLabel("취미");
		lblHobby.setHorizontalAlignment(SwingConstants.CENTER);
		lblHobby.setFont(new Font("굴림", Font.BOLD, 20));
		lblHobby.setBounds(12, 103, 147, 45);
		pn2.add(lblHobby);
		
		JRadioButton rdMale = new JRadioButton("남자");
		buttonGroup.add(rdMale);
		rdMale.setBackground(new Color(255, 255, 255));
		rdMale.setFont(new Font("굴림", Font.BOLD, 20));
		rdMale.setBounds(197, 37, 147, 45);
		pn2.add(rdMale);
		
		JRadioButton rdFemale = new JRadioButton("여자");
		rdFemale.setSelected(true);
		buttonGroup.add(rdFemale);
		rdFemale.setBackground(new Color(255, 255, 255));
		rdFemale.setFont(new Font("굴림", Font.BOLD, 20));
		rdFemale.setBounds(404, 37, 147, 45);
		pn2.add(rdFemale);
		
		JCheckBox ckHoddy1 = new JCheckBox("등산");
		ckHoddy1.setBackground(new Color(255, 255, 255));
		ckHoddy1.setFont(new Font("굴림", Font.BOLD, 20));
		ckHoddy1.setBounds(197, 103, 110, 45);
		pn2.add(ckHoddy1);
		
		JCheckBox ckHoddy2 = new JCheckBox("낚시");
		ckHoddy2.setBackground(new Color(255, 255, 255));
		ckHoddy2.setFont(new Font("굴림", Font.BOLD, 20));
		ckHoddy2.setBounds(311, 103, 110, 45);
		pn2.add(ckHoddy2);
		
		JCheckBox ckHoddy3 = new JCheckBox("수영");
		ckHoddy3.setBackground(new Color(255, 255, 255));
		ckHoddy3.setFont(new Font("굴림", Font.BOLD, 20));
		ckHoddy3.setBounds(425, 103, 110, 45);
		pn2.add(ckHoddy3);
		
		JCheckBox ckHoddy4 = new JCheckBox("바둑");
		ckHoddy4.setBackground(new Color(255, 255, 255));
		ckHoddy4.setFont(new Font("굴림", Font.BOLD, 20));
		ckHoddy4.setBounds(539, 103, 110, 45);
		pn2.add(ckHoddy4);
		
		JCheckBox ckHoddy5 = new JCheckBox("바이크");
		ckHoddy5.setFont(new Font("굴림", Font.BOLD, 20));
		ckHoddy5.setBackground(Color.WHITE);
		ckHoddy5.setBounds(648, 103, 110, 45);
		pn2.add(ckHoddy5);
		
		JLabel lblMessage = new JLabel("메세지가 출력됩니다");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("굴림", Font.BOLD, 20));
		lblMessage.setBounds(29, 220, 720, 149);
		pn2.add(lblMessage);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(255, 128, 128));
		pn3.setBounds(0, 479, 784, 82);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnGender = new JButton("성별출력");
		btnGender.setFont(new Font("굴림", Font.BOLD, 20));
		btnGender.setBounds(12, 10, 150, 50);
		pn3.add(btnGender);
		
		JButton btnHobby = new JButton("취미출력");
		btnHobby.setFont(new Font("굴림", Font.BOLD, 20));
		btnHobby.setBounds(345, 10, 150, 50);
		pn3.add(btnHobby);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(622, 10, 150, 50);
		pn3.add(btnExit);
		
		frame.setVisible(true);
		
//-----------------위쪽은 디자인, 아래쪽은 메소드-----------------------------------------------------
		
		//취미 출력버튼 클릭시 수행
		btnHobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String hoddy = "선택하신 취미는 ? ";
			if(ckHoddy1.isSelected()) hoddy += ckHoddy1.getText() + "/";
			if(ckHoddy2.isSelected()) hoddy += ckHoddy1.getText() + "/";
			if(ckHoddy3.isSelected()) hoddy += ckHoddy1.getText() + "/";
			if(ckHoddy4.isSelected()) hoddy += ckHoddy1.getText() + "/";
			if(ckHoddy5.isSelected()) hoddy += ckHoddy1.getText() + "/";
				
			hoddy = hoddy.substring(0,hoddy.length()-1);
			lblMessage.setText(hoddy);
			}
		});
		
		//성별 출력버튼 클릭시 수행
		btnGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender = "선택하신 성별은 ? ";
				if(rdMale.isSelected()) gender += rdMale.getText(); 
				else gender += rdFemale.getText();
					
				lblMessage.setText(gender);
				
			}
		});
		
		//종료버튼을 마우스로 클릭시 수행
		btnExit.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료할까요?", "작업종료", JOptionPane.YES_NO_OPTION);
				if(ans == 0) System.exit(0);
			}
		});
		 
	}
}
