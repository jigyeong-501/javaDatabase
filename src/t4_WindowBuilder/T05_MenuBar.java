package t4_WindowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class T05_MenuBar {

	private JFrame frame;

	public static void main(String[] args) {
		new T05_MenuBar();
	}

	public T05_MenuBar() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("메뉴만들기");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(T05_MenuBar.class.getResource("/t4_WindowBuilder/images/new.jpg")));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(T05_MenuBar.class.getResource("/t4_WindowBuilder/images/open.jpg")));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon(T05_MenuBar.class.getResource("/t4_WindowBuilder/images/save.jpg")));
		toolBar.add(btnNewButton_1_1);
		
//		JSeparator separator_1 = new JSeparator();
//		toolBar.add(separator_1);
		
		toolBar.addSeparator();
		
		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(T05_MenuBar.class.getResource("/t4_WindowBuilder/images/exit.jpg")));
		toolBar.add(btnExit);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem_1_1);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_1_2 = new JMenuItem("Exit");
		mnNewMenu.add(mntmNewMenuItem_1_2);
		
		JMenu mnNewMenu_1 = new JMenu("edit");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("about");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("About SpringGroup");
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		frame.setVisible(true);
		
		//-----------------위쪽은 디자인, 아래쪽은 메소드-----------------------------------------------------
		
		//about springGroup 클릭시
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "SpringGroup Ver 1.0");
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
		
		//메뉴에서 exit버튼 
		mntmNewMenuItem_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료할까요?", "작업종료", JOptionPane.YES_NO_OPTION);
				if(ans == 0) System.exit(0);
			}
		});
	}

}
