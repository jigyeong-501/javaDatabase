package t5_Insa;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;

public class InsaInput {
	private InsaDAO dao = new InsaDAO();
	private InsaVO vo = null;
	private int res = 0;
	
	private JFrame frame;
	private JTextField txtName;
	private JTextField txtAge;
	private final ButtonGroup buttonGroup = new ButtonGroup();

//	public static void main(String[] args) {
//		new InsaInput();
//	}

	public InsaInput() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("회원가입 처리");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 80);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("회원가입 폼");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 784, 80);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 80, 784, 401);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.BOLD, 20));
		lblName.setBounds(30, 40, 150, 50);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("굴림", Font.BOLD, 20));
		lblAge.setBounds(30, 130, 150, 50);
		pn2.add(lblAge);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("굴림", Font.BOLD, 20));
		lblGender.setBounds(30, 220, 150, 50);
		pn2.add(lblGender);
		
		JLabel lblIpsail = new JLabel("입사일");
		lblIpsail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpsail.setFont(new Font("굴림", Font.BOLD, 20));
		lblIpsail.setBounds(30, 310, 150, 50);
		pn2.add(lblIpsail);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText("admin");
		txtName.setFont(new Font("굴림", Font.BOLD, 20));
		txtName.setBounds(192, 40, 562, 50);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setText("20");
		txtAge.setHorizontalAlignment(SwingConstants.CENTER);
		txtAge.setFont(new Font("굴림", Font.BOLD, 20));
		txtAge.setColumns(10);
		txtAge.setBounds(192, 130, 562, 50);
		pn2.add(txtAge);
		
		JRadioButton rdMale = new JRadioButton("남자");
		buttonGroup.add(rdMale);
		rdMale.setFont(new Font("굴림", Font.BOLD, 20));
		rdMale.setBounds(188, 220, 100, 50);
		pn2.add(rdMale);
		
		JRadioButton rdFemale = new JRadioButton("여자");
		buttonGroup.add(rdFemale);
		rdFemale.setSelected(true);
		rdFemale.setFont(new Font("굴림", Font.BOLD, 20));
		rdFemale.setBounds(308, 220, 100, 50);
		pn2.add(rdFemale);
		
		// 년/월/일 초기값 생성하기
		String[] yy = new String[25];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		int imsi = 2025;
		for(int i=0; i<yy.length;i++) {
			yy[i] = imsi - i + "";
		}
		
		for(int i=0; i<mm.length;i++) {
			mm[i] = (i + 1) + "";
		}
		
		for(int i=0; i<dd.length;i++) {
			dd[i] = (i + 1) + "";
		}
		
		JComboBox cbYY = new JComboBox(yy);
		cbYY.setFont(new Font("굴림", Font.BOLD, 18));
		cbYY.setBounds(192, 312, 120, 50);
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);
		cbMM.setFont(new Font("굴림", Font.BOLD, 18));
		cbMM.setBounds(396, 310, 80, 50);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);
		cbDD.setFont(new Font("굴림", Font.BOLD, 18));
		cbDD.setBounds(557, 312, 80, 50);
		pn2.add(cbDD);
		
		JLabel lblYY = new JLabel("년");
		lblYY.setFont(new Font("굴림", Font.BOLD, 20));
		lblYY.setBounds(324, 312, 57, 50);
		pn2.add(lblYY);
		
		JLabel lblMM = new JLabel("월");
		lblMM.setFont(new Font("굴림", Font.BOLD, 20));
		lblMM.setBounds(488, 310, 57, 50);
		pn2.add(lblMM);
		
		JLabel lblDD = new JLabel("일");
		lblDD.setFont(new Font("굴림", Font.BOLD, 20));
		lblDD.setBounds(651, 310, 57, 50);
		pn2.add(lblDD);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 481, 784, 80);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnInput = new JButton("가입하기");
		btnInput.setFont(new Font("굴림", Font.BOLD, 20));
		btnInput.setBounds(42, 10, 205, 60);
		pn3.add(btnInput);
		
		JButton btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("굴림", Font.BOLD, 20));
		btnReset.setBounds(289, 10, 205, 60);
		pn3.add(btnReset);
		
		JButton btnClose = new JButton("창닫기");
		btnClose.setFont(new Font("굴림", Font.BOLD, 20));
		btnClose.setBounds(536, 10, 205, 60);
		pn3.add(btnClose);
		
		//오늘날짜를 가입화면의 날짜에 표시하기
		InsaService service = new InsaService();
		vo = service.getCurrentDate();
		cbYY.setSelectedItem(vo.getCbYY());
		cbMM.setSelectedItem(vo.getCbMM());
		cbDD.setSelectedItem(vo.getCbDD());
		
		frame.setVisible(true);
		
		//-----------------위쪽은 디자인, 아래쪽은 메소드-----------------------------------------------------
		// 가입하기버튼 마우스로 클릭시 
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText().trim();
				String age = txtAge.getText().trim();
				String gender = "";
				String ipsail = cbYY.getSelectedItem() + "-" + cbMM.getSelectedItem() + "-" + cbDD.getSelectedItem();
				
				//유효성 검사
				if(name.equals("")) {
					JOptionPane.showMessageDialog(frame, "성명을 입력하세요");
					txtName.requestFocus();
				}else if(!Pattern.matches("^[0-9]+$", age)) {
					JOptionPane.showMessageDialog(frame, "나이는 숫자로 입력하세요");
					txtAge.requestFocus();
				}else{
					
					if(rdMale.isSelected()) gender="남자";
					else gender = "여자";
					
					//회원명 중복처리
					vo = dao.getNameSearch(name);
					if(vo.getName() != null) {
						JOptionPane.showMessageDialog(frame, "이미 가입된 회원입니다.다시 성명을 확인하세요");
						txtName.requestFocus();
					}else {
						
						//회원명 중복처리 완료후 앞에서 기록한 내용을 vo에 담아서 DB에 저장한다.
						vo = new InsaVO();
						vo.setName(name);
						vo.setAge(Integer.parseInt(age));
						vo.setGender(gender);
						vo.setIpsail(ipsail);
						
						res = dao.setInsaInput(vo);
						
						if(res != 0) {
							JOptionPane.showMessageDialog(frame, "회원가입 되었습니다.");
							frame.dispose();
							new InsaMain();
						}else {
							JOptionPane.showMessageDialog(frame, "회원가입 실패");
							txtName.requestFocus();
						}
					}
					
				}
			}
		});
		
		// 종료버튼
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new InsaMain();
			}
		});
	}
}
