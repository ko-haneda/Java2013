package ex02_04;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
		this.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
			public void windowClosed(WindowEvent e) {}
			public void windowActivated(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {
				Rectangle r = MyFrame.this.getBounds();
				data.setPrefs();
				data.setX(r.x);
				data.setY(r.y);
				System.exit(-1);
			}
		});
		//その他のクラスの管理
		data = new MyFrameData();
		this.setBounds(data.getX(), data.getY(), 500, 500);
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