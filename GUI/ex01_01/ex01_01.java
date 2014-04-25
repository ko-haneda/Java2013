package ex01_01;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ex01_01 extends Frame {
	private static final long serialVersionUID = 1L;
	
	public static void main(String args[]) {
		ex01_01 app = new ex01_01("GUI ex01_01");
		app.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		app.setSize(760, 400);
		System.out.println(app.getSize().width);
		app.setVisible(true);
		while (true) {
			try {
				app.setSize(760, 400);
				Thread.sleep(1000);
				app.repaint();
			} catch (InterruptedException e) {
				System.out.println("エラー" + e);
			}
		}
	}

	public ex01_01(String title) {
		super(title);
	}

	public void paint(Graphics g) {
		Calendar cal1 = Calendar.getInstance(); 	// オブジェクトの生成
		int hour = cal1.get(Calendar.HOUR_OF_DAY);  // 現在の時を取得
		int minute = cal1.get(Calendar.MINUTE);	    // 現在の分を取得
		int second = cal1.get(Calendar.SECOND); 	// 現在の秒を取得

		g.setColor(Color.black);
		g.fillRect(30, 50, 700, 320);
		g.setColor(new Color(40, 20, 20));
		nana_seg(g, 0, seg_sepe(8), false);
		nana_seg(g, 1, seg_sepe(8), false);
		nana_seg(g, 2, seg_sepe(8), false);
		nana_seg(g, 3, seg_sepe(8), false);
		nana_seg(g, 4, seg_sepe(8), true);
		nana_seg(g, 5, seg_sepe(8), true);
		
		g.setColor(Color.red);
		nana_seg(g, 0, seg_sepe(hour / 10), false);
		nana_seg(g, 1, seg_sepe(hour % 10), false);
		nana_seg(g, 2, seg_sepe(minute / 10), false);
		nana_seg(g, 3, seg_sepe(minute % 10), false);
		nana_seg(g, 4, seg_sepe(second / 10), true);
		nana_seg(g, 5, seg_sepe(second % 10), true);
		g.fillRect(260, 150, 20, 20);
		g.fillRect(260, 250, 20, 20);
	}

	void nana_seg(Graphics g, int area, boolean seg[], boolean is_second) {
		int x = area * 100;
		int y = 0;
		int resize = 1;
		if(is_second){
			y = 130;
			resize = 2;
		}
		if(area > 1) x += 40;
		if(area > 3) x += 20;
		if (seg[0])		g.fillRect(60 + x, 	70 + y, 					20, 	150 / resize);
		if (seg[1])		g.fillRect(60 + x, 	70 + y,  					80, 	20  / resize);
		if (seg[2])		g.fillRect(120 + x, 70 + y,  					20, 	150 / resize);
		if (seg[3])		g.fillRect(60 + x, 	70 + (130 / resize) + y, 	80, 	20  / resize);
		if (seg[4])		g.fillRect(60 + x, 	70 + (130 / resize) + y, 	20, 	150 / resize);
		if (seg[5])		g.fillRect(60 + x, 	70 + (130 / resize) * 2 + y,80, 	20  / resize);
		if (seg[6])		g.fillRect(120 + x, 70 + (130 / resize) + y, 	20, 	150 / resize);
	}

	boolean[] seg_sepe(int num) {
		if(num == 0)		return new boolean []{ true, true, true, false, true, true, true};
		else if(num == 1)	return new boolean []{ false, false, true, false, false, false, true};
		else if(num == 2)	return new boolean []{ false, true, true, true, true, true, false};
		else if(num == 3)	return new boolean []{ false, true, true, true, false, true, true};
		else if(num == 4)	return new boolean []{ true, false, true, true, false, false, true};
		else if(num == 5)	return new boolean []{ true, true, false, true, false, true, true};
		else if(num == 6)	return new boolean []{ true, true, false, true, true, true, true};
		else if(num == 7)	return new boolean []{ true, true, true, false, false, false, true};
		else if(num == 8)	return new boolean []{ true, true, true, true, true, true, true};
		else if(num == 9)	return new boolean []{ true, true, true, true, false, true, true};
		else 				return new boolean []{ false, false, false, false, false, false, false};
	}
}