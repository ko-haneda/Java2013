package ex01_02;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

//ダブルバッファリングについて
//http://www.javadrive.jp/applet/thread/index8.html
class MyDialog extends Dialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	Button b1;
    Choice c1;
    Choice c2;
    TextField []t1;
    TextField []t2;
    boolean flag;
	
	MyDialog(Frame owner) {
        super(owner);
        this.addWindowListener(new DialogWindowListener());
        
        flag = false;
        setLayout(new GridLayout(5, 1));
        Panel []p = new Panel[5];
        for(int i = 0; i < 5; i++){
        	p[i] = new Panel();
            add(p[i]);
        }
        p[0].setLayout(new GridLayout(1, 1));
        p[1].setLayout(new GridLayout(1, 1));
        p[2].setLayout(new GridLayout(1, 1));
        p[3].setLayout(new GridLayout(1, 3));
        p[4].setLayout(new GridLayout(1, 3));

        //設定の更新ボタン
        b1 = new Button("update");
        b1.addActionListener(this);
        
        //フォントの指定
        c1 = new Choice();
        c1.add("Type1");
        c1.add("Type2");
        c1.setBounds(10, 10, 500, 20);

        //フォントサイズの指定
        c2 = new Choice();
        c2.add("Large");
        c2.add("Medium");
        c2.add("Small");
        c2.setBounds(10, 10, 500, 20);

        //文字色の指定
        t1 = new TextField[3];
        for(int i = 0; i < 3; i++){
        	t1[i] = new TextField(1);
        	t1[i].setText("0");
        }
        t1[0].setText("255");
        //背景色の設定
        t2 = new TextField[3];
        for(int i = 0; i < 3; i++){
        	t2[i] = new TextField(1);
        	t2[i].setText("0");
        }
        
        //パネルにボタン等を設置
        p[0].add(b1);
        p[1].add(c1);
        p[2].add(c2);
        for(int i = 0; i < 3; i++){
            p[3].add(t1[i]);
            p[4].add(t2[i]);        	
        }
        
        setTitle("MyDialog");
        setSize(100, 200);
        setResizable(false);
    }
    
	public void actionPerformed(ActionEvent e) {
		flag = true;
    }
	class DialogWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
		dispose();
		}
	}
}

public class ex01_02 extends Frame implements ActionListener{
	private static final long serialVersionUID = 1L;
	static int font_size;
	static int font;
	static Color moji;
	static Color back;
	static MyDialog dlg;
	static int width;
	static int height;
	
	ex01_02(){
		ex01_02 app = new ex01_02("GUI ex01_01");
		app.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		app.setVisible(true);
	    font = 0;
	    font_size = 0;
		moji = Color.red;
		back = Color.black;
		width = 760;
		height = 370;
		
	    dlg = new MyDialog(this);
	    app.createMenu();
		app.setResizable(false);
		while (true) {
			app.setSize(width, height);
			if(dlg.flag){
				
				dlg.flag = false;
				String buf_font = dlg.c1.getSelectedItem();
				String buf_font_size = dlg.c2.getSelectedItem();
				if(buf_font.equals("Type1"))	font = 0;
				else							font = 1;
				
				if(buf_font_size.equals("Large"))		font_size = 0;
				else if(buf_font_size.equals("Medium"))	font_size = 1;
				else									font_size = 2;
				
				int []RGB1 = new int[3];
				int []RGB2 = new int[3];
				for(int i = 0; i < 3; i++){
					RGB1[i] = Integer.parseInt(dlg.t1[i].getText());
					RGB2[i] = Integer.parseInt(dlg.t2[i].getText());
				}
				moji = new Color(RGB1[0], RGB1[1],RGB1[2]);
				back = new Color(RGB2[0], RGB2[1],RGB2[2]);
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
		new ex01_02();
	} 

	public ex01_02(String title) {
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
		 dlg.setVisible(true);
	}
}
