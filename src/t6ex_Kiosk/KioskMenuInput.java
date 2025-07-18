package t6ex_Kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings({"rawtypes","unchecked","static-access"})
public class KioskMenuInput {
	private KioskDAO dao = new KioskDAO();
	private KioskVO vo = null;
	
	private int res = 0;

	private JFrame frame;
	private JTextField txtProduct;
	private JTextField txtDetail;
	private JTextField txtCalorie;
	private JTextField txtPrice;

//	public static void main(String[] args) {
//		new KioskMenuInput();
//	}

	public KioskMenuInput() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("버거킹");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 58);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("버거킹 메뉴 등록 화면");
		lblTitle.setBackground(Color.PINK);
		lblTitle.setOpaque(true);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 22));
		lblTitle.setBounds(0, 0, 784, 58);
		pn1.add(lblTitle);
		
		JPanel pn1_1 = new JPanel();
		pn1_1.setLayout(null);
		pn1_1.setBounds(0, 56, 784, 448);
		frame.getContentPane().add(pn1_1);
		
		JLabel lblPart = new JLabel("상품분류");
		lblPart.setFont(new Font("굴림", Font.BOLD, 18));
		lblPart.setBounds(23, 28, 108, 31);
		pn1_1.add(lblPart);
		
		JLabel lblProduct = new JLabel("상품명");
		lblProduct.setFont(new Font("굴림", Font.BOLD, 18));
		lblProduct.setBounds(23, 82, 108, 31);
		pn1_1.add(lblProduct);
		
		JLabel lblDetile = new JLabel("간단설명");
		lblDetile.setFont(new Font("굴림", Font.BOLD, 18));
		lblDetile.setBounds(23, 134, 108, 31);
		pn1_1.add(lblDetile);
		
		JLabel lblContent = new JLabel("상세설명");
		lblContent.setFont(new Font("굴림", Font.BOLD, 18));
		lblContent.setBounds(23, 189, 108, 31);
		pn1_1.add(lblContent);
		
		JLabel lblKcal = new JLabel("칼로리(kcal)");
		lblKcal.setFont(new Font("굴림", Font.BOLD, 18));
		lblKcal.setBounds(23, 273, 108, 31);
		pn1_1.add(lblKcal);
		
		JLabel lblImageName = new JLabel("상품이미지");
		lblImageName.setFont(new Font("굴림", Font.BOLD, 18));
		lblImageName.setBounds(23, 391, 108, 31);
		pn1_1.add(lblImageName);
		
		JLabel lblPrice = new JLabel("상품가격");
		lblPrice.setFont(new Font("굴림", Font.BOLD, 18));
		lblPrice.setBounds(23, 332, 108, 31);
		pn1_1.add(lblPrice);
		
		JComboBox cbPart = new JComboBox();
		cbPart.setModel(new DefaultComboBoxModel(new String[] {"프리미엄", "와퍼&주니어", "사이드"}));
		cbPart.setFont(new Font("굴림", Font.PLAIN, 17));
		cbPart.setBounds(158, 34, 316, 31);
		pn1_1.add(cbPart);
		
		txtProduct = new JTextField();
		txtProduct.setFont(new Font("굴림", Font.PLAIN, 18));
		txtProduct.setBounds(158, 82, 316, 31);
		pn1_1.add(txtProduct);
		txtProduct.setColumns(10);
		
		txtDetail = new JTextField();
		txtDetail.setFont(new Font("굴림", Font.PLAIN, 18));
		txtDetail.setColumns(10);
		txtDetail.setBounds(158, 134, 316, 31);
		pn1_1.add(txtDetail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(158, 187, 316, 61);
		pn1_1.add(scrollPane);
		
		JTextArea taContent = new JTextArea();
		taContent.setFont(new Font("Monospaced", Font.PLAIN, 18));
		scrollPane.setViewportView(taContent);
		
		txtCalorie = new JTextField();
		txtCalorie.setFont(new Font("굴림", Font.PLAIN, 18));
		txtCalorie.setColumns(10);
		txtCalorie.setBounds(158, 273, 316, 31);
		pn1_1.add(txtCalorie);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("굴림", Font.PLAIN, 18));
		txtPrice.setColumns(10);
		txtPrice.setBounds(158, 332, 316, 31);
		pn1_1.add(txtPrice);
		
		JButton btnImage = new JButton("이미지등록");
		btnImage.setFont(new Font("굴림", Font.BOLD, 18));
		btnImage.setBounds(158, 391, 316, 31);
		pn1_1.add(btnImage);
		
		JLabel lblImage = new JLabel("상품 이미지가 표시됩니다.");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setIcon(null);
		lblImage.setOpaque(true);
		lblImage.setBackground(Color.LIGHT_GRAY);
		lblImage.setBounds(511, 174, 245, 245);
		pn1_1.add(lblImage);
		
		JPanel pn1_2 = new JPanel();
		pn1_2.setLayout(null);
		pn1_2.setBounds(0, 503, 784, 58);
		frame.getContentPane().add(pn1_2);
		
		JButton btnInput = new JButton("상품등록");
		btnInput.setFont(new Font("굴림", Font.BOLD, 18));
		btnInput.setBounds(41, 10, 154, 38);
		pn1_2.add(btnInput);
		
		JButton btnExit = new JButton("창닫기");
		btnExit.setFont(new Font("굴림", Font.BOLD, 18));
		btnExit.setBounds(597, 10, 154, 38);
		pn1_2.add(btnExit);
		
		
		
		frame.setVisible(true);
		
//------------------------위쪽은 디자인 , 아래쪽은 메소드------------------------------------------------------

		// 상품 등록하기 마우스클릭시 수행
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String part = cbPart.getSelectedItem().toString();
				String product = txtProduct.getText();
				String detail = txtDetail.getText();
				String content = taContent.getText();
				String calorie = txtCalorie.getText();
				String strImage = lblImage.getIcon().toString();
				String image = strImage.substring(strImage.lastIndexOf("\\")+1);
				String strPrice = txtPrice.getText().toString();
				
				if(product.trim().equals("")) {
					JOptionPane.showMessageDialog(frame, "상품명을 입력하세요");
					txtProduct.requestFocus();
				}
				else if(detail.trim().equals("")) {
					JOptionPane.showMessageDialog(frame, "상품명을 입력하세요");
					txtDetail.requestFocus();
				}
				else if(image.trim().equals("")) {
					JOptionPane.showMessageDialog(frame, "상품그림을 등록하세요");
					txtDetail.requestFocus();
				}
				else if(!Pattern.matches("^[0-9]+$", strPrice)) {
					JOptionPane.showMessageDialog(frame, "상품가격은 숫자로 입력하세요");
					txtPrice.requestFocus();
				}
				else if(!Pattern.matches("^[0-9]+$", calorie)) {
					JOptionPane.showMessageDialog(frame, "칼로리는 숫자로 입력하세요");
					txtCalorie.requestFocus();
				}
				else {
					// 상품명 중복처리
					vo = dao.getProductSearch(product);
					if(vo.getProduct() != null) {
						JOptionPane.showMessageDialog(null, "이미 가입된 상품입니다. 다시 상품을 입력해 주세요.");
						txtProduct.requestFocus();
					}
					else {
						vo.setPart(part);
						vo.setProduct(product);
						vo.setDetail(detail);
						vo.setContent(content);
						vo.setCalorie(Integer.parseInt(calorie));
						vo.setImage(image);
						vo.setPrice(Integer.parseInt(strPrice));
						
						res = dao.setKooskInput(vo);
						
						if(res != 0) {
							JOptionPane.showMessageDialog(null, product + " 상품이 등록되었습니다.");
							txtProduct.setText("");
							txtDetail.setText("");
							taContent.setText("");
							txtCalorie.setText("");
							lblImage.setText("");
							txtPrice.setText("");
						}
						else {
							JOptionPane.showMessageDialog(null, "상품 등록 실패~~ 다시 등록해 주세요.");
							txtProduct.requestFocus();
						}
					}
				}
			}
		});
		
		// 이미지 불러오기 버튼 클릭시 수행
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg","gif","png");
				chooser.setFileFilter(filter);
				
				int res = chooser.showOpenDialog(null);
				
				if(res != chooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(frame, "파일을 선택해 주세요","경고",JOptionPane.WARNING_MESSAGE);
				}
				else {
					String filePath = chooser.getSelectedFile().getPath();
					lblImage.setIcon(new ImageIcon(filePath));
				}
			}
		});
		
		// 작업종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new KioskMain();
			}
		});
		
	}
}
