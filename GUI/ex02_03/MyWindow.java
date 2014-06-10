package Swing.ex02_03;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MyWindow extends JWindow implements MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new MyWindow();
	}
	
	private MyWindowData data;
	private MyPopupMenu pop;
	private MyPanel panel;
	
	MyWindow(){
		super();
		this.setSize(500, 500);	//ダミー
		//その他のクラスの管理
		data = new MyWindowData();
		pop = new MyPopupMenu(data);
		panel = new MyPanel(this, data);
		//このフレームの設定
		this.add(panel);
		this.setVisible(true);		
		addMouseListener(this);
		addMouseMotionListener(this);
		
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

	private Point dragPoint, position;
	
	Point getScreenLocation(MouseEvent e) {
		Point p1 = e.getPoint();
		Point p2 = this.getLocationOnScreen();
		return new Point(p1.x + p2.x, p1.y + p2.y);
	}
	
	//MouseListener
	public void mousePressed(MouseEvent e) {
		dragPoint = getScreenLocation(e);
		position = this.getLocation();
	}

	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger()) {
			pop.show(e.getComponent(), e.getX(), e.getY());
		}
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}

	//MouseMotionListener
	public void mouseDragged(MouseEvent e) {
		Point cursor = getScreenLocation(e);
		int xdiff = cursor.x - dragPoint.x;
		int ydiff = cursor.y - dragPoint.y;
		this.setLocation(position.x + xdiff, position.y + ydiff);
	}
	public void mouseMoved(MouseEvent e) {
	}
}
