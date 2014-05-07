package ex02_02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new MyFrame();
	}
	
	private MyFrameData data;
	private MyPropertyDialog dlg;
	private MyPanel panel;
	
	MyFrame(){
		//このフレームの設定
		super("CLOCK");
		JMenuBar menuBar = new JMenuBar();
		JMenuItem menuFile = new JMenuItem("プロパティを開く");
		getRootPane().setJMenuBar(menuBar);
		menuBar.add(menuFile);
		menuFile.addActionListener(this);
		this.setSize(500, 500);	//ダミー
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//その他のクラスの管理
		data = new MyFrameData();
		dlg = new MyPropertyDialog(this, data);
		dlg.setVisible(false);
		panel = new MyPanel(this, data);
		//このフレームの設定
		this.add(panel);
		this.setVisible(true);
		this.setResizable(false);
		//リペイントのタイミング
		while (true) {
			try {
				Thread.sleep(1000);
				panel.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		dlg.setBounds(getBounds().x, getBounds().y+getSize().height, 420, 420);
		dlg.setVisible(true);
	}
}
