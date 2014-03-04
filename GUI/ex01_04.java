package ex01_04;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class ex01_04 extends Frame implements ActionListener{
	private static final long serialVersionUID = 1L;
	static int font_size;
	static int font;
	static Color moji;
	static Color back;
	static MyDialog dlg;
	static int width;
	static int height;
	private Preferences prefs;
	
	ex01_04(){
		System.out.println("まれにフォントが勝手に変わってしまう。　修正済み");
		System.out.println("layoutが言うことを聞いてくれない。");
		ex01_04 app = new ex01_04("GUI ex01_01");
		app.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		prefs = Preferences.userNodeForPackage(this.getClass());
		app.setVisible(true);
		width = 760;
		height = 370;
	    dlg = new MyDialog(this);
	    load();
	    set();
	    app.createMenu();
		app.setResizable(false);
		while (true) {
			app.setSize(width, height);
			if(dlg.flag){
				dlg.flag = false;
				String buf_font = dlg.c1.getSelectedItem();
				if(buf_font.equals("Type1"))	font = 0;
				else							font = 1;
				String buf_font_size = dlg.c2.getSelectedItem();
				if(buf_font_size.equals("Large"))		font_size = 0;
				else if(buf_font_size.equals("Medium"))	font_size = 1;
				else									font_size = 2;
				String ch_color = dlg.c3.getSelectedItem();
				if(ch_color.equals("BLACK"))		moji = Color.black;
				else if(ch_color.equals("WHITE"))	moji = Color.white;
				else if(ch_color.equals("RED"))		moji = Color.red;
				else if(ch_color.equals("GREEN"))	moji = Color.green;
				else								moji = Color.blue;
				
				String back_color = dlg.c4.getSelectedItem();
				if(back_color.equals("BLACK"))		back = Color.black;
				else if(back_color.equals("WHITE"))	back = Color.white;
				else if(back_color.equals("RED"))	back = Color.red;
				else if(back_color.equals("GREEN"))	back = Color.green;
				else								back = Color.blue;
				save();
				set();
			}
			try {
				Thread.sleep(1000);
				app.repaint();
			} catch (InterruptedException e) {
				System.out.println("エラー" + e);
			}
		}
	}
	
	public void createMenu(){
		MenuBar m_bar = new MenuBar();
		setMenuBar(m_bar);
		
		Menu menu = new Menu("opsion");
		m_bar.add(menu);
		
		MenuItem m_item = new MenuItem("setting");
		menu.add(m_item);
		m_item.addActionListener(this);
	}
	public static void main(String args[]) {
		new ex01_04();
	} 

	public ex01_04(String title) {
		super(title);
	}

	public void paint(Graphics g) {
		Calendar cal1 = Calendar.getInstance(); 	// オブジェクトの生成
		int hour = cal1.get(Calendar.HOUR_OF_DAY);  // 現在の時を取得
		int minute = cal1.get(Calendar.MINUTE);	    // 現在の分を取得
		int second = cal1.get(Calendar.SECOND); 	// 現在の秒を取得

		g.setColor(back);
		if(font_size == 0){
			width = 760;
			height = 370;
		}
		else if(font_size == 1){
			width = 500;
			height = 240;
		}
		else{
			width = 390;
			height = 160;
		}			
		g.fillRect(0, 0, width, height);
		if(font == 0) degital(g, hour, minute, second);
		else		  simple(g, hour, minute, second);

	}
	public void simple(Graphics g, int hour, int minute, int second){
		String h = String.format("%1$02d", hour);
		String m = String.format("%1$02d", minute);
		String s = String.format("%1$02d", second);
		String str = h + " : " + m + " : " + s;
		g.setColor(moji);
		if(font_size == 0){
			g.setFont(new Font("TimesRoman",Font.ITALIC,130));
			g.drawString(str, 50, 250);
		}
		else if(font_size == 1){
			g.setFont(new Font("TimesRoman",Font.ITALIC,80));
			g.drawString(str, 50, 180);
		}
		else{
			g.setFont(new Font("TimesRoman",Font.ITALIC,50));
			g.drawString(str, 60, 120);
		}
	}
	public void degital(Graphics g, int hour, int minute, int second){
		g.setColor(moji);
		if(font_size == 0){
			g.fillRect(280, 130, 20, 20);
			g.fillRect(280, 270, 20, 20);	
		}
		else if(font_size == 1){
			g.fillRect(200, 100, 10, 10);
			g.fillRect(200, 180, 10, 10);
		}
		else{
			g.fillRect(165, 80, 5, 5);
			g.fillRect(165, 120, 5, 5);
		}			

		int R = (10 * back.getRed() + moji.getRed()) / 11;
		int G = (10 * back.getGreen() + moji.getGreen()) / 11;
		int B = (10 * back.getBlue() + moji.getBlue()) / 11;
		g.setColor(new Color(R, G, B));
		nana_seg(g, 0, seg_sepe(8), font_size, false);
		nana_seg(g, 1, seg_sepe(8), font_size, false);
		nana_seg(g, 2, seg_sepe(8), font_size, false);
		nana_seg(g, 3, seg_sepe(8), font_size, false);
		nana_seg(g, 4, seg_sepe(8), font_size, true);
		nana_seg(g, 5, seg_sepe(8), font_size, true);
		g.setColor(moji);
		nana_seg(g, 0, seg_sepe(hour / 10), font_size, false);
		nana_seg(g, 1, seg_sepe(hour % 10), font_size, false);
		nana_seg(g, 2, seg_sepe(minute / 10), font_size, false);
		nana_seg(g, 3, seg_sepe(minute % 10), font_size, false);
		nana_seg(g, 4, seg_sepe(second / 10), font_size, true);
		nana_seg(g, 5, seg_sepe(second % 10), font_size, true);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		 set();
		 dlg.setVisible(true);
	}
	
	public void load(){
		System.out.println("load");
		font = Integer.parseInt(prefs.get("p_font", "0"));
	    font_size = Integer.parseInt(prefs.get("p_font_size", "0"));
		moji = getColor(prefs.get("p_moji", "red"));
		back = getColor(prefs.get("p_back", "black"));
    }
	
	public void save() {
		System.out.println("save");
		prefs.put("p_font", String.valueOf(font));
		prefs.put("p_font_size", String.valueOf(font_size));
		prefs.put("p_moji", getColor(moji));
		prefs.put("p_back", getColor(back));
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}
	
	public Color getColor(String color){
		if(color.equals("black"))	return Color.black;
		if(color.equals("white"))	return Color.white;
		if(color.equals("red"))		return Color.red;
		if(color.equals("green"))	return Color.green;
		if(color.equals("blue"))	return Color.blue;
		return null;
	}
	
	public String getColor(Color color){
		if(Color.black.equals(color))	return "black";
		if(Color.white.equals(color))	return "white";
		if(Color.red.equals(color))		return "red";
		if(Color.green.equals(color))	return "green";
		if(Color.blue.equals(color))	return "blue";
		return null;
	}
	
	public int getIndex(Color color){
		if(Color.black.equals(color))	return 0;
		if(Color.white.equals(color))	return 1;
		if(Color.red.equals(color))		return 2;
		if(Color.green.equals(color))	return 3;
		if(Color.blue.equals(color))	return 4;
		return -1;
	}
	
	public void set(){
		System.out.println("set");
		dlg.c1.select(font);
		dlg.c2.select(font_size);
		dlg.c3.select(getIndex(moji));
		dlg.c4.select(getIndex(back));
	}
}
