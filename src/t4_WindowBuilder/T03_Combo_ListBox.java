package t4_WindowBuilder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class T03_Combo_ListBox {

	private JFrame frame;
	private final JPanel pn1 = new JPanel();

	public static void main(String[] args) {
		new T03_Combo_ListBox();
	}

	public T03_Combo_ListBox() {
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
		pn1.setBounds(0, 0, 400, 377);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("직업을 선택하세요");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 360, 58);
		pn1.add(lblTitle);
		
		JComboBox comboJob = new JComboBox();
		comboJob.setFont(new Font("굴림", Font.BOLD, 20));
		comboJob.setModel(new DefaultComboBoxModel(new String[] {"학생", "의사", "변호사", "회계사", "군인", "회사원", "공무원", "간호사", "자영업", "기타"}));
		comboJob.setBounds(22, 75, 350, 32);
		pn1.add(comboJob);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(384, 0, 400, 377);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 122, 330, 146);
		pn2.add(scrollPane);
		
		JList listJob = new JList();
		listJob.setFont(new Font("굴림", Font.BOLD, 18));
		listJob.setModel(new AbstractListModel() {
			String[] values = new String[] {"학생", "의사", "변호사", "회계사", "군인", "회사원", "공무원", "간호사", "자영업", "기타"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listJob);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 375, 784, 97);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnCombo = new JButton("콤보출력");
		btnCombo.setFont(new Font("굴림", Font.BOLD, 20));
		btnCombo.setBounds(12, 10, 155, 66);
		pn3.add(btnCombo);
		
		JButton btnList = new JButton("리스트 출력");
		btnList.setFont(new Font("굴림", Font.BOLD, 20));
		btnList.setBounds(208, 10, 155, 66);
		pn3.add(btnList);
		
		JButton btnMessage = new JButton("메세지출력");
		btnMessage.setFont(new Font("굴림", Font.BOLD, 20));
		btnMessage.setBounds(413, 10, 155, 66);
		pn3.add(btnMessage);
		
		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(617, 10, 155, 66);
		pn3.add(btnExit);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(0, 464, 784, 97);
		frame.getContentPane().add(pn4);
		pn4.setLayout(null);
		
		JLabel lblMessage = new JLabel("메세지가 출력됩니다");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("굴림", Font.BOLD, 20));
		lblMessage.setBounds(212, 29, 360, 58);
		pn4.add(lblMessage);
		
		
		frame.setVisible(true);
		
		//-----------------위쪽은 디자인, 아래쪽은 메소드-----------------------------------------------------
	
		// 직업 리스트박스 선택할때 수행
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "";
//				Object[] jobs = listJob.getSelectedValues();
				Object[] jobs = listJob.getSelectedValuesList().toArray();
				
				for(Object job : jobs) msg+= job + "/";
				msg = msg.substring(0, msg.length()-1);
				
				lblMessage.setText(msg);	
			}
		});
		
		// 직업 콤보박스 선택할때 수행
		comboJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = comboJob.getSelectedItem().toString() + "(" + comboJob.getSelectedIndex() + ")";
				lblMessage.setText(msg);
			}
		});
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료할까요?", "작업종료", JOptionPane.YES_NO_OPTION);
				if(ans == 0) System.exit(0);
			}
		});
	}
}
