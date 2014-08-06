package ex02_04;
import java.awt.Color;
import java.awt.Font;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class MyFrameData {

	private Color bgColor;	//背景色
	private Color chColor;	//文字色
	private String fontName;//Fontの種類
	private int fontSize;	//Fontのサイズ
	private Preferences prefs; 
	MyFrameData(){
		this.prefs = Preferences.userNodeForPackage(this.getClass());
		int bgColor_R = Integer.parseInt(prefs.get("bgColor_R", "0"));
		int bgColor_G = Integer.parseInt(prefs.get("bgColor_G", "150"));
		int bgColor_B = Integer.parseInt(prefs.get("bgColor_B", "200"));
		int chColor_R = Integer.parseInt(prefs.get("chColor_R", "0"));
		int chColor_G = Integer.parseInt(prefs.get("chColor_G", "0"));
		int chColor_B = Integer.parseInt(prefs.get("chColor_B", "0"));
		this.setBgColor(new Color(bgColor_R, bgColor_G, bgColor_B));
		this.setChColor(new Color(chColor_R, chColor_G, chColor_B));
		this.fontName = prefs.get("fontName", "Segoe UI Light");
		this.fontSize = Integer.parseInt(prefs.get("fontSize", "100"));
	}

	public Color getBgColor() {
		return bgColor;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}

	public Color getChColor() {
		return chColor;
	}

	public void setChColor(Color chColor) {
		this.chColor = chColor;
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public Font getFont() {
		return new Font(this.fontName, Font.BOLD, this.fontSize);
	}

	public void setPrefs() {
		prefs.put("bgColor_R", String.valueOf(getBgColor().getRed()));
		prefs.put("bgColor_G", String.valueOf(getBgColor().getGreen()));
		prefs.put("bgColor_B", String.valueOf(getBgColor().getBlue()));
		prefs.put("chColor_R", String.valueOf(getChColor().getRed()));
		prefs.put("chColor_G", String.valueOf(getChColor().getGreen()));
		prefs.put("chColor_B", String.valueOf(getChColor().getBlue()));
		prefs.put("fontName", getFontName());
		prefs.put("fontSize", String.valueOf(getFontSize()));
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}

	}
}