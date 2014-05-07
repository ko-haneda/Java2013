package ex02_03;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.*;

public class MyActionListener implements ActionListener {
	private MyWindowData data;
	private boolean isBgColor;
	
	public MyActionListener(MyWindowData data, boolean isBgColor) {
		this.data = data;
		this.isBgColor = isBgColor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		str = str.trim();
		if(getColor(str) != null){
			if(isBgColor)	data.setBgColor(getColor(str));
			else			data.setChColor(getColor(str));
		}
		else{
			Pattern p = Pattern.compile("[0-9]+pt$");
			Matcher m = p.matcher(str);
			if(!m.find())	data.setFontName(str);
			else			data.setFontSize(Integer.parseInt(str.substring(0, str.length() - 2)));
		}
	}
		
	private Color getColor(String color){
		if(color.equals("WHITE"))		return Color.WHITE;
		if(color.equals("LIGHT_GRAY"))	return Color.LIGHT_GRAY;
		if(color.equals("GRAY"))		return Color.GRAY;
		if(color.equals("DARK_GRAY"))	return Color.DARK_GRAY;
		if(color.equals("BLACK"))		return Color.BLACK;
		if(color.equals("RED"))			return Color.RED;
		if(color.equals("PINK"))		return Color.PINK;
		if(color.equals("ORANGE"))		return Color.ORANGE;
		if(color.equals("YELLOW"))		return Color.YELLOW;
		if(color.equals("GREEN"))		return Color.GREEN;
		if(color.equals("MAGENTA"))		return Color.MAGENTA;
		if(color.equals("CYAN"))		return Color.CYAN;
		if(color.equals("BLUE"))		return Color.BLUE;
		return null;
	}
	
}
