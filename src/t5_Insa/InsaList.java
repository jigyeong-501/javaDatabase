package t5_Insa;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

@SuppressWarnings({ "rawtypes", "unused", "unchecked"})
public class InsaList {

	private JFrame frame;
	private JTable table;
	private Vector title, vData;
	private DefaultTableModel dtm;
	
	InsaDAO dao = new InsaDAO();
	private JTextField txtCondition;

//	public static void main(String[] args) {
//		new InsaList();
//	}
	public InsaList() {
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
		
		JButton btnClose = new JButton("종 료");
		btnClose.setFont(new Font("굴림", Font.BOLD, 20));
		btnClose.setBounds(650, 10, 122, 60);
		pn1.add(btnClose);
		
		JButton btnList = new JButton("전체검색");
		btnList.setFont(new Font("굴림", Font.BOLD, 20));
		btnList.setBounds(516, 10, 122, 60);
		pn1.add(btnList);
		
		JComboBox cbCondition = new JComboBox();
		cbCondition.setFont(new Font("굴림", Font.BOLD, 18));
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"성명", "나이", "성별", "입사일"}));
		cbCondition.setBounds(12, 10, 102, 60);
		pn1.add(cbCondition);
		
		txtCondition = new JTextField();
		txtCondition.setFont(new Font("굴림", Font.BOLD, 18));
		txtCondition.setBounds(126, 10, 202, 60);
		pn1.add(txtCondition);
		txtCondition.setColumns(10);
		
		JButton btnCondition = new JButton("조건검색");
		btnCondition.setFont(new Font("굴림", Font.BOLD, 18));
		btnCondition.setBounds(340, 10, 113, 60);
		pn1.add(btnCondition);
		
		JPanel pn2 = new JPanel();
		pn2.setLayout(null);
		pn2.setBounds(0, 78, 784, 403);
		frame.getContentPane().add(pn2);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(12, 10, 760, 383);
//		pn2.add(scrollPane);
		
//		table = new JTable();
//		scrollPane.setViewportView(table);
		
		JPanel pn3 = new JPanel();
		pn3.setLayout(null);
		pn3.setBounds(0, 481, 784, 80);
		frame.getContentPane().add(pn3);
		
		JButton btnIpsailAsc = new JButton("입사일 오름차순 ");
		btnIpsailAsc.setFont(new Font("굴림", Font.BOLD, 16));
		btnIpsailAsc.setBounds(420, 10, 170, 60);
		pn3.add(btnIpsailAsc);
		
		JButton btnIpsailDesc = new JButton("입사일 내림차순 ");
		btnIpsailDesc.setFont(new Font("굴림", Font.BOLD, 16));
		btnIpsailDesc.setBounds(602, 10, 170, 60);
		pn3.add(btnIpsailDesc);
		
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
		vData = dao.getInsaList("", ""); //idx 내림차순
		
		//3. DB에서 가져온 자료(vData)와 타이틀(title)을 DefaultTableModel객체 생성시 할당한다.
		dtm = new DefaultTableModel(vData, title); //(데이터, 타이틀)
		
		//4. DefaultTableModel에 담긴 Vector타입의 '데이터/타이틀'을 JTable객체 생성시에 담아준다.
		table = new JTable(dtm);
		
		//5. 자료가 담긴 JTable을 JScrollPane객체 생성시에 담아준다
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(39, 22, 702, 353);
		pn2.add(scrollPane);
		
		//6. 출력결과를 화면에 표시한다.	
		frame.setVisible(true);
		
		//-----------------위쪽은 디자인, 아래쪽은 메소드-----------------------------------------------------

		//조건검색 버튼 마우스로 클릭시
		btnCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String condition = cbCondition.getSelectedItem().toString();
				String textCondition = txtCondition.getText();
				
				if(textCondition.trim().equals("")) {
					JOptionPane.showMessageDialog(frame, "검색할 내용을 입력하세요");
					txtCondition.requestFocus();
					return;
				}
				
				if(condition.equals("성명")) vData = dao.getConditionSearch("name", textCondition);
				else if(condition.equals("나이")) {
					if(!Pattern.matches("^[0-9]+$", textCondition)) {
						JOptionPane.showMessageDialog(frame, "나이는 숫자로 입력하세요");
						txtCondition.requestFocus();
					}else  vData = dao.getConditionSearch("age", textCondition);
				}
				else if(condition.equals("성별")) vData = dao.getConditionSearch("gender", textCondition);
				else if(condition.equals("입사일")) vData = dao.getConditionSearch("ipsail", textCondition);
				dtm.setDataVector(vData, title);
			}
		});
		
		//전체검색 버튼 마우스로 클릭시
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList("", "");
				dtm.setDataVector(vData, title);
			}
		});

		//입사일 오름차순 버튼 마우스로 클릭시
		btnIpsailAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList("ipsail", "asc");
				dtm.setDataVector(vData, title);
			}
		});
		
		//입사일 내림차순 버튼 마우스로 클릭시
		btnIpsailDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList("ipsail", "desc");
				dtm.setDataVector(vData, title);
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
