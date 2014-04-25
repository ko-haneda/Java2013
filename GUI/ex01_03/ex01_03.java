package ex01_03;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class ex01_03 extends Window implements ActionListener, MouseListener,
		MouseMotionListener {
	private static final long serialVersionUID = 1L;
	private Point dragPoint, position;
	private static int width = 760;
	private static int height = 400;
	private static MenuPanel panel = new MenuPanel(1, 1, Color.BLACK, Color.RED);

	public ex01_03(Frame frame) {
		super(frame);
	}

	public static void main(String[] args) {
		ex01_03 clock = new ex01_03(new Frame());
		clock.init();
	}

	public void init() {
		this.setSize(width, height);
		this.setLocation(200, 200);
		this.setVisible(true);
		this.add(panel);
		addMouseListener(this);
		addMouseMotionListener(this);
		while (true) {
			try {
				Thread.sleep(1000);
				this.repaint();
			} catch (InterruptedException e) {
				System.out.println("エラー" + e);
			}
		}
	}

	public void paint(Graphics g) {
		Calendar cal1 = Calendar.getInstance(); // オブジェクトの生成
		int hour = cal1.get(Calendar.HOUR_OF_DAY); // 現在の時を取得
		int minute = cal1.get(Calendar.MINUTE); // 現在の分を取得
		int second = cal1.get(Calendar.SECOND); // 現在の秒を取得

		
		if(panel.size == 1){
			width = 760;
			height = 370;
		}
		else if(panel.size == 2){
			width = 500;
			height = 240;
		}
		else{
			width = 390;
			height = 160;
		}
//なぜかウィンドウの大きさを変更させると動かない。
//		this.setSize(width, height);
		g.setColor(panel.bc);
		g.fillRect(0, 0, width, height);	
		if(panel.font == 1) degital(g, hour, minute, second);
		else		  		simple(g, hour, minute, second);
	}
	public void simple(Graphics g, int hour, int minute, int second){
		String h = String.format("%1$02d", hour);
		String m = String.format("%1$02d", minute);
		String s = String.format("%1$02d", second);
		String str = h + " : " + m + " : " + s;
		g.setColor(panel.cc);
		if(panel.size == 1){
			g.setFont(new Font("TimesRoman",Font.ITALIC,130));
			g.drawString(str, 50, 250);
		}
		else if(panel.size == 2){
			g.setFont(new Font("TimesRoman",Font.ITALIC,80));
			g.drawString(str, 50, 180);
		}
		else{
			g.setFont(new Font("TimesRoman",Font.ITALIC,50));
			g.drawString(str, 60, 120);
		}
	}
	public void degital(Graphics g, int hour, int minute, int second){
		g.setColor(panel.cc);
		if(panel.size == 1){
			g.fillRect(280, 130, 20, 20);
			g.fillRect(280, 270, 20, 20);	
		}
		else if(panel.size == 2){
			g.fillRect(200, 100, 10, 10);
			g.fillRect(200, 180, 10, 10);
		}
		else{
			g.fillRect(165, 80, 5, 5);
			g.fillRect(165, 120, 5, 5);
		}			

		int R = (10 * panel.bc.getRed() + panel.cc.getRed()) / 11;
		int G = (10 * panel.bc.getGreen() + panel.cc.getGreen()) / 11;
		int B = (10 * panel.bc.getBlue() + panel.cc.getBlue()) / 11;
		g.setColor(new Color(R, G, B));
		nana_seg(g, 0, seg_sepe(8), panel.size-1, false);
		nana_seg(g, 1, seg_sepe(8), panel.size-1, false);
		nana_seg(g, 2, seg_sepe(8), panel.size-1, false);
		nana_seg(g, 3, seg_sepe(8), panel.size-1, false);
		nana_seg(g, 4, seg_sepe(8), panel.size-1, true);
		nana_seg(g, 5, seg_sepe(8), panel.size-1, true);
		g.setColor(panel.cc);
		nana_seg(g, 0, seg_sepe(hour / 10), panel.size - 1, false);
		nana_seg(g, 1, seg_sepe(hour % 10), panel.size - 1, false);
		nana_seg(g, 2, seg_sepe(minute / 10), panel.size - 1, false);
		nana_seg(g, 3, seg_sepe(minute % 10), panel.size - 1, false);
		nana_seg(g, 4, seg_sepe(second / 10), panel.size - 1, true);
		nana_seg(g, 5, seg_sepe(second % 10), panel.size - 1, true);
	}

	void nana_seg(Graphics g, int area, boolean seg[], int size, boolean flag) {
		int resize = (int)Math.pow(2.0, size);
		int x = area * 80 / (size + 1) + 20 * (area + 1);	//余白は20とする。
		int y = flag ? 150 / resize - 10 / resize: 0;
		int sub_x = 0;
		if(area > 1) x += (40 / (size + 1));
		if(area > 3) x += (20 / (size + 1));
		if(area > 4) x -= 20;
		if(flag)	resize *= 2;
		int buf_resize = resize;
		while(buf_resize != 1){
			sub_x += 80 / buf_resize;
			buf_resize /= 2;
		}
		if(sub_x != 0) sub_x -= 20;
		if (seg[0])		g.fillRect(60 + x, 			70 + y, 						20 / resize, 	150 / resize);
		if (seg[1])		g.fillRect(60 + x, 			70 + y,  						80 / resize, 	20  / resize);
		if (seg[2])		g.fillRect(120 + x - sub_x, 70 + y,  						20 / resize, 	150 / resize);
		if (seg[3])		g.fillRect(60 + x, 			70 + (130 / resize) + y, 		80 / resize, 	20  / resize);
		if (seg[4])		g.fillRect(60 + x, 			70 + (130 / resize) + y, 		20 / resize, 	150 / resize);
		if (seg[5])		g.fillRect(60 + x, 			70 + (130 / resize) * 2 + y,	80 / resize, 	20  / resize);
		if (seg[6])		g.fillRect(120 + x - sub_x, 70 + (130 / resize) + y,		20 / resize, 	150 / resize);
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
	
	public void actionPerformed(ActionEvent e) {
	}

	Point getScreenLocation(MouseEvent e) {
		Point p1 = e.getPoint();
		Point p2 = this.getLocationOnScreen();
		return new Point(p1.x + p2.x, p1.y + p2.y);
	}

	public void mouseDragged(MouseEvent e) {
		Point cursor = getScreenLocation(e);
		int xdiff = cursor.x - dragPoint.x;
		int ydiff = cursor.y - dragPoint.y;
		this.setLocation(position.x + xdiff, position.y + ydiff);
	}

	public void mousePressed(MouseEvent e) {
		dragPoint = getScreenLocation(e);
		position = this.getLocation();
	}

	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger()) {
			panel.popup.show(panel, e.getX(), e.getY());
		}
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

}

/* メニュー付きのフレームです */
class MenuPanel extends Panel implements ActionListener {
	private static final long serialVersionUID = 1L;
	PopupMenu popup;
	Menu menuA = new Menu("フォントの種類");
	Menu menuB = new Menu("フォントの大きさ");
	Menu menuC = new Menu("背景色");
	Menu menuD = new Menu("文字色");
	public int font;
	public int size;
	public Color bc;
	public Color cc;

	MenuPanel(int font, int size, Color bc, Color cc) {
		this.font = font;
		this.size = size;
		this.bc = bc;
		this.cc = cc;
		popup = new PopupMenu();
		MenuItem menuE = new MenuItem("終了");
		MenuItem a1 = new MenuItem("タイプ１");
		MenuItem a2 = new MenuItem("タイプ２");
		MenuItem b1 = new MenuItem("大");
		MenuItem b2 = new MenuItem("中");
		MenuItem b3 = new MenuItem("小");
		MenuItem c1 = new MenuItem("背景 黒");
		MenuItem c2 = new MenuItem("背景 赤");
		MenuItem c3 = new MenuItem("背景 緑");
		MenuItem c4 = new MenuItem("背景 青");
		MenuItem c5 = new MenuItem("背景 白");
		MenuItem d1 = new MenuItem("文字 黒");
		MenuItem d2 = new MenuItem("文字 赤");
		MenuItem d3 = new MenuItem("文字 緑");
		MenuItem d4 = new MenuItem("文字 青");
		MenuItem d5 = new MenuItem("文字 白");

		menuA.add(a1);
		menuA.add(a2);
		menuB.add(b1);
		menuB.add(b2);
		menuB.add(b3);
		menuC.add(c1);
		menuC.add(c2);
		menuC.add(c3);
		menuC.add(c4);
		menuC.add(c5);
		menuD.add(d1);
		menuD.add(d2);
		menuD.add(d3);
		menuD.add(d4);
		menuD.add(d5);

		popup.add(menuA);
		popup.add(menuB);
		popup.add(menuC);
		popup.add(menuD);
		popup.add(menuE);
		a1.addActionListener(this);
		a2.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		c1.addActionListener(this);
		c2.addActionListener(this);
		c3.addActionListener(this);
		c4.addActionListener(this);
		c5.addActionListener(this);
		d1.addActionListener(this);
		d2.addActionListener(this);
		d3.addActionListener(this);
		d4.addActionListener(this);
		d5.addActionListener(this);
		menuE.addActionListener(this);
		add(popup);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		switch (e.getActionCommand()) {
			case "タイプ１": font = 1; break;
			case "タイプ２": font = 2; break;
			case "大":	size = 1; break;
			case "中":	size = 2; break;
			case "小":	size = 3; break;
			case "背景 黒":	bc = Color.BLACK; break;
			case "背景 赤":	bc = Color.RED; break;
			case "背景 緑":	bc = Color.GREEN; break;
			case "背景 青":	bc = Color.BLUE; break;
			case "背景 白":	bc = Color.WHITE; break;
			case "文字 黒":	cc = Color.BLACK;break;
			case "文字 赤":	cc = Color.RED; break;
			case "文字 緑":	cc = Color.GREEN; break;
			case "文字 青":	cc = Color.BLUE; break;
			case "文字 白":	cc = Color.WHITE; break;
			case "終了":System.exit(0);
			default: break;
			}
	}

}