package Swing.ex02_03;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class MyPopupMenu extends JPopupMenu implements ActionListener, MouseListener{
	private static final long serialVersionUID = 1L;
	private static final String[] COLORS = {"WHITE", "LIGHT_GRAY", "GRAY", "DARK_GRAY", 
											"BLACK", "RED", "PINK", "ORANGE", "YELLOW",
											"GREEN", "MAGENTA", "CYAN", "BLUE"};
	private JMenu mFontName;
	private JMenu mFontSize;
	private JMenu mBgColor;
	private JMenu mChColor;
	private JMenuItem miExit;
	private JButton upName;
	private JButton downName;
	private JButton upSize;
	private JButton downSize;

	MyPopupMenu(MyWindowData data) {
		super();
		mFontName = new JMenu("フォントの指定");
		mFontSize = new JMenu("フォントサイズの指定");
		mBgColor  = new JMenu("背景色の指定");
		mChColor  = new JMenu("文字色の指定");
		miExit    = new JMenuItem("閉じる");
		upName    = new JButton("                         ▲                         ");
		downName  = new JButton("                         ▼                         ");
		upSize    = new JButton("             ▲            ");
		downSize  = new JButton("             ▼            ");		
		upName.setPreferredSize(new Dimension(10, 15));		//10はダミー
		downName.setPreferredSize(new Dimension(10, 15));	//10はダミー
		upSize.setPreferredSize(new Dimension(100, 15));	//(100はダミー)
		downSize.setPreferredSize(new Dimension(100, 15));	//(100はダミー)
		//フォントの指定
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String fontfamilys[] = ge.getAvailableFontFamilyNames();
		mFontName.add(upName);
		for(int i = 0; i < fontfamilys.length; i++){
			JMenuItem mi = new JMenuItem(trimming(fontfamilys[i], 42));
	        mFontName.add(mi);
	        mi.addActionListener(new MyActionListener(data, false));
	        if(i >= 10)	mi.setVisible(false);
		}
		mFontName.add(downName);
		
		//フォントサイズの指定
		mFontSize.add(upSize);
		for(int i = 10, j = 0; i < 300; i += 5, j++){
			if(i > 100)	i += 5;
			if(i > 200)	i += 10;
			JMenuItem mi = new JMenuItem(i + "pt");
			mFontSize.add(mi);
			mi.addActionListener(new MyActionListener(data, false));
			if(j >= 10)	mi.setVisible(false);
		}
	    this.add(mFontSize);
	    mFontSize.add(downSize);
	
	    //背景色と文字色の指定
	    for(String color : COLORS){
	    	ImageIcon icon = new ImageIcon(new File("").getAbsolutePath() + "\\src\\Swing\\ex02_03\\COLOR\\"+ color + ".jpg");
	    	JMenuItem mi1 = new JMenuItem(color, icon);
	    	JMenuItem mi2 = new JMenuItem(color, icon);
	    	mBgColor.add(mi1);
	    	mChColor.add(mi2);
	    	mi1.addActionListener(new MyActionListener(data, true));
	    	mi2.addActionListener(new MyActionListener(data, false));
	    }
	    
	    //閉じる
	    miExit.addActionListener(this);
	    upName.addMouseListener(this);
	    downName.addMouseListener(this);
	    upSize.addMouseListener(this);
	    downSize.addMouseListener(this);
	    
	    //ポップアップに全てを追加
	    add(mFontName);
	    add(mFontSize);
	    add(mBgColor);
	    add(mChColor);
	    add(miExit);
	}
	
	public String trimming(String org, int size){
		StringBuffer sb = new StringBuffer(org);
		for(int i = sb.length(); i < size; i++){
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	private void moveIndex(JMenu menu, boolean isUP){
		int index = 1;
		for(; index < menu.getItemCount() - 1; index++){
			if(menu.getItem(index).isVisible())		break;
		}
		//UPと書いてあるが数字の値は下がる（UPは上に移動することを表している）
		if(isUP){
			if(index >= 2){
				menu.getItem(index - 1).setVisible(true);
				menu.getItem(index + 9).setVisible(false);
			}
		}
		else{
			index += 9;
			if(index <= menu.getItemCount() - 3){
				menu.getItem(index + 1).setVisible(true);
				menu.getItem(index - 9).setVisible(false);
			}
		}
	}
	
	Thread thread;
	
	public void mousePressed(MouseEvent e){
		thread = new Thread(new Runnable(){
			private MouseEvent e;
			
			public Runnable setE(MouseEvent e){
				this.e = e;
				return this;
			}
			public void run() {
				//クリック処理
				try {
					if(e.getSource() == upName)		moveIndex(mFontName, true);
					if(e.getSource() == downName)	moveIndex(mFontName, false);
					if(e.getSource() == upSize)		moveIndex(mFontSize, true);
					if(e.getSource() == downSize)	moveIndex(mFontSize, false);
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					return;
				}
				//長押し処理
				int ct = 0;
				long ms = 100;
				while(!thread.isInterrupted()){	//←終了条件間違っている？？　終了しない
						try {
							if(++ct % 10 == 0)	ms -= 30;
							if(ms < 20)	ms = 20;
							Thread.sleep(ms);
							if(e.getSource() == upName)		moveIndex(mFontName, true);
							if(e.getSource() == downName)	moveIndex(mFontName, false);
							if(e.getSource() == upSize)		moveIndex(mFontSize, true);
							if(e.getSource() == downSize)	moveIndex(mFontSize, false);
						} catch (InterruptedException e1) {//こちらが終了条件
							break;
						}
				}
			}
		}.setE(e));
		thread.start();
	}
	public void mouseReleased(MouseEvent e){
		thread.interrupt();
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
