package ex02_03;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class MyPopupMenu extends JPopupMenu implements ActionListener, MouseMotionListener{
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
	    	ImageIcon icon = new ImageIcon(new File("").getAbsolutePath() + "\\src\\ex02_03\\COLOR\\"+ color + ".jpg");
	    	JMenuItem mi1 = new JMenuItem(color, icon);
	    	JMenuItem mi2 = new JMenuItem(color, icon);
	    	mBgColor.add(mi1);
	    	mChColor.add(mi2);
	    	mi1.addActionListener(new MyActionListener(data, true));
	    	mi2.addActionListener(new MyActionListener(data, false));
	    }
	    
	    //閉じる
	    miExit.addActionListener(this);
	    upName.addActionListener(this);
	    upName.addMouseMotionListener(this);
	    downName.addActionListener(this);
	    downName.addMouseMotionListener(this);
	    upSize.addActionListener(this);
	    upSize.addMouseMotionListener(this);
	    downSize.addActionListener(this);
	    downSize.addMouseMotionListener(this);
	    
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
	public void action(AWTEvent e){
		if(e.getSource() == miExit)		System.exit(0);
		if(e.getSource() == upName)		moveIndex(mFontName, true);
		if(e.getSource() == downName)	moveIndex(mFontName, false);
		if(e.getSource() == upSize)		moveIndex(mFontSize, true);
		if(e.getSource() == downSize)	moveIndex(mFontSize, false);
	}
	
	public void actionPerformed(ActionEvent e) {
		action(e);
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

	/*マウスを押している間、下に下がるようにしたかった。*/
	//TODO 妥協プログラミング
	public void mouseDragged(MouseEvent e) {
		action(e);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	public void mouseMoved(MouseEvent e) {
		action(e);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
