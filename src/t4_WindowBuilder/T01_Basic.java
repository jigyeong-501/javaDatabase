package t4_WindowBuilder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class T01_Basic {

	private JFrame frame;
	private JTextField txtMid;
	private JTextField txtName;
	private JTextField txtAge;
	private JPasswordField txtPwd;

	public static void main(String[] args) {
		new T01_Basic();
	}

	public T01_Basic() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		//frame.setBounds(100, 100, 800, 600);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("작업종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(525, 488, 200, 40);
		frame.getContentPane().add(btnExit);
		
		JButton btnReset = new JButton("다시입력");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setFont(new Font("굴림", Font.BOLD, 20));
		btnReset.setBounds(279, 488, 200, 40);
		frame.getContentPane().add(btnReset);
		
		JButton btnInput = new JButton("회원가입");
		btnInput.setFont(new Font("굴림", Font.BOLD, 20));
		btnInput.setBounds(33, 488, 200, 40);
		frame.getContentPane().add(btnInput);
		
		JLabel lblNewLabel = new JLabel("나이");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(33, 215, 227, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("굴림", Font.PLAIN, 20));
		lblPassword.setBounds(33, 95, 227, 50);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(33, 35, 227, 50);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("성명");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(33, 155, 227, 50);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtMid = new JTextField();
		txtMid.setBounds(308, 35, 417, 50);
		frame.getContentPane().add(txtMid);
		txtMid.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(308, 158, 417, 50);
		frame.getContentPane().add(txtName);
		
		txtAge = new JTextField();
		txtAge.setText("0");
		txtAge.setColumns(10);
		txtAge.setBounds(308, 218, 417, 50);
		frame.getContentPane().add(txtAge);
		
		txtPwd = new JPasswordField();
		txtPwd.setText("");
		txtPwd.setBounds(307, 97, 418, 51);
		frame.getContentPane().add(txtPwd);
		
		JLabel lblNewLabel_1 = new JLabel("자기소개");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(43, 275, 227, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(308, 278, 418, 106);
		frame.getContentPane().add(scrollPane);
		
		JTextArea txtaContent = new JTextArea();
		txtaContent.setLocation(309, 0);
		scrollPane.setViewportView(txtaContent);

		frame.setVisible(true);
		
		//-------------------------------위쪽은 디자인, 아래쪽은 메소드-----------------------------------------------------
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.exit(0);
				super.keyPressed(e);
			}
		});
		
		// 회원가입 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mid = txtMid.getText();
				String pwd = txtPwd.getText();
				String name = txtName.getText();
				int age = Integer.parseInt(txtAge.getText());
				String content = txtaContent.getText();
				
				if(mid.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디는 필수입력입니다.", "회원가입", JOptionPane.WARNING_MESSAGE);
					txtMid.requestFocus();
				}else if(pwd.trim().equals("") ){
					JOptionPane.showMessageDialog(null, "비밀번호는 필수입력입니다.", "회원가입", JOptionPane.WARNING_MESSAGE);
					txtPwd.requestFocus();
				}else if (name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명은 필수입력입니다.", "회원가입", JOptionPane.WARNING_MESSAGE);
					txtName.requestFocus();
				}else {					
					JOptionPane.showMessageDialog(null, "회원에 가입합니다.", "회원가입", JOptionPane.INFORMATION_MESSAGE);					
				}
				
			}
		});
		
		// 
	}
}
