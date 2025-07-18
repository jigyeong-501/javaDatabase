package t6ex_Kiosk;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class KioskOrder {
	
	KioskDAO dao = new KioskDAO();
	KioskVO vo = null;

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblImg1, lblImg2, lblImg3, lblImg4, lblImg5, lblImg6, lblImg7, lblImg8;

//	public static void main(String[] args) {
//		new KioskOrder();
//	}

	public KioskOrder() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("버거킹 주문");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 48);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("분류선택");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(12, 10, 89, 28);
		pn1.add(lblNewLabel);
		
		JRadioButton rd1 = new JRadioButton("프리미엄");
		buttonGroup.add(rd1);
		rd1.setFont(new Font("굴림", Font.BOLD, 18));
		rd1.setBounds(121, 15, 116, 23);
		pn1.add(rd1);
		
		JRadioButton rd2 = new JRadioButton("와퍼&주니어");
		buttonGroup.add(rd2);
		rd2.setFont(new Font("굴림", Font.BOLD, 18));
		rd2.setBounds(253, 15, 143, 23);
		pn1.add(rd2);
		
		JRadioButton rd3 = new JRadioButton("사이드");
		buttonGroup.add(rd3);
		rd3.setFont(new Font("굴림", Font.BOLD, 18));
		rd3.setBounds(414, 15, 116, 23);
		pn1.add(rd3);
		
		JPanel pn2 = new JPanel();
		pn2.setLayout(null);
		pn2.setBounds(0, 49, 784, 465);
		frame.getContentPane().add(pn2);
		
		JScrollPane sp1 = new JScrollPane();
		sp1.setBounds(12, 10, 760, 445);
		pn2.add(sp1);
		
		JPanel pnProduct = new JPanel();
		sp1.setViewportView(pnProduct);
		pnProduct.setLayout(null);
		
		lblImg1 = new JLabel("");
		lblImg1.setBounds(15, 10, 170, 170);
		pnProduct.add(lblImg1);
		
		lblImg2 = new JLabel("");
		lblImg2.setBounds(200, 10, 170, 170);
		pnProduct.add(lblImg2);
		
		lblImg3 = new JLabel("");
		lblImg3.setBounds(385, 10, 170, 170);
		pnProduct.add(lblImg3);
		
		lblImg4 = new JLabel("");
		lblImg4.setBounds(570, 10, 170, 170);
		pnProduct.add(lblImg4);
		
		lblImg5 = new JLabel("");
		lblImg5.setBounds(15, 190, 170, 170);
		pnProduct.add(lblImg5);
		
		lblImg6 = new JLabel("");
		lblImg6.setBounds(200, 190, 170, 170);
		pnProduct.add(lblImg6);
		
		lblImg7 = new JLabel("");
		lblImg7.setBounds(385, 190, 170, 170);
		pnProduct.add(lblImg7);
		
		lblImg8 = new JLabel("");
		lblImg8.setBounds(570, 190, 170, 170);
		pnProduct.add(lblImg8);
		
		JPanel pn3 = new JPanel();
		pn3.setLayout(null);
		pn3.setBounds(0, 513, 784, 48);
		frame.getContentPane().add(pn3);
		
		JButton btnClose = new JButton("창닫기");
		btnClose.setFont(new Font("굴림", Font.BOLD, 18));
		btnClose.setBounds(638, 10, 134, 28);
		pn3.add(btnClose);
		
		frame.setVisible(true);
		
//------------------------위쪽은 디자인 , 아래쪽은 메소드------------------------------------------------------

		// 사이드메뉴 rd3 버튼 클릭시 수행
		rd3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ArrayList<KioskVO> vos = dao.getProductList(rd3.getText());
				System.out.println();
				productAllClear();
				productDisplay(vos);
			}
		});		
		
		// 와퍼&주니어 rd2 버튼 클릭시 수행
		rd2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ArrayList<KioskVO> vos = dao.getProductList(rd2.getText());
				productAllClear();
				productDisplay(vos);
			}
		});		
		
		// 프리미엄 rd1 버튼 클릭시 수행
		rd1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ArrayList<KioskVO> vos = dao.getProductList(rd1.getText());
				productAllClear();
				productDisplay(vos);
			}
		});		
		
		// 작업종료
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new KioskMain();
			}
		});
		
	}

	protected void productAllClear() {
		String filePath = "D:\\springGroup\\java\\works\\0714_Database_swing\\src\\t6ex_Kiosk\\images\\";
		String smallFile = filePath+"ready.jpg";
		
		lblImg1.setIcon(new ImageIcon(smallFile));
		lblImg2.setIcon(new ImageIcon(smallFile));
		lblImg3.setIcon(new ImageIcon(smallFile));
		lblImg4.setIcon(new ImageIcon(smallFile));
		lblImg5.setIcon(new ImageIcon(smallFile));
		lblImg6.setIcon(new ImageIcon(smallFile));
		lblImg7.setIcon(new ImageIcon(smallFile));
		lblImg8.setIcon(new ImageIcon(smallFile));
	}

	protected void productDisplay(ArrayList<KioskVO> vos) {
		String filePath = "D:\\springGroup\\java\\works\\0714_Database_swing\\src\\t6ex_Kiosk\\images\\";

		for(int i=0; i<vos.size(); i++) {
			String smallFile = filePath+vos.get(i).getImage().toString();
			smallFile = smallFile.substring(0,smallFile.lastIndexOf(".")) + "_s" + smallFile.substring(smallFile.lastIndexOf("."));
			switch(i+1) {
				case 1: lblImg1.setIcon(new ImageIcon(smallFile)); break;
				case 2: lblImg2.setIcon(new ImageIcon(smallFile)); break;
				case 3: lblImg3.setIcon(new ImageIcon(smallFile)); break;
				case 4: lblImg4.setIcon(new ImageIcon(smallFile)); break;
				case 5: lblImg5.setIcon(new ImageIcon(smallFile)); break;
				case 6: lblImg6.setIcon(new ImageIcon(smallFile)); break;
				case 7: lblImg7.setIcon(new ImageIcon(smallFile)); break;
				case 8: lblImg8.setIcon(new ImageIcon(smallFile)); break;
				default: break;
			}
		}
	}
}
