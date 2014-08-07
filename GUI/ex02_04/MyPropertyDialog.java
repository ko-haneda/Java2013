package ex02_04;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyPropertyDialog extends JDialog implements ActionListener,
		AdjustmentListener, FocusListener {
	private static final long serialVersionUID = 1L;
	private JFrame owner;
	private MyFrameData data;
	private GridBagLayout gbl = new GridBagLayout();
	private JComboBox<String> cb_fontName;
	private JTextField tf_fontSize;
	private JTextField tf_bgColor;
	private JTextField tf_chColor;
	private JTextField[] tf_bgRGB;
	private JTextField[] tf_chRGB;
	private JScrollBar[] sb_bgRGB;
	private JScrollBar[] sb_chRGB;
	private JButton ok_btn;
	private JButton ng_btn;

	MyPropertyDialog(JFrame owner, MyFrameData data) {
		super(owner);
		this.data = data;
		this.owner = owner;
		getContentPane().setLayout(gbl);

		JLabel l_fontName = new JLabel("フォントの種類");
		JLabel l_fontSize = new JLabel("フォントのサイズ");
		JLabel l_bgColor = new JLabel("背景色");
		JLabel l_chColor = new JLabel("文字色");
		JLabel l_bgRGB[] = new JLabel[3];
		JLabel l_chRGB[] = new JLabel[3];
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		String fontfamilys[] = ge.getAvailableFontFamilyNames();
		cb_fontName = new JComboBox<String>(fontfamilys);
		tf_fontSize = new JTextField(3);
		tf_bgColor = new JTextField(2);
		tf_chColor = new JTextField(2);
		tf_bgRGB = new JTextField[3];
		tf_chRGB = new JTextField[3];
		sb_bgRGB = new JScrollBar[3];
		sb_chRGB = new JScrollBar[3];
		String[] rgb = "R,G,B".split(",");
		for (int i = 0; i < 3; i++) {
			l_bgRGB[i] = new JLabel(rgb[i]);
			l_chRGB[i] = new JLabel(rgb[i]);
			tf_bgRGB[i] = new JTextField(3);
			tf_chRGB[i] = new JTextField(3);
			sb_bgRGB[i] = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 256);
			sb_chRGB[i] = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 256);
		}
		tf_bgColor.setEditable(false);
		tf_chColor.setEditable(false);
		ok_btn = new JButton("OK");
		ng_btn = new JButton("NG");
		// フォントの種類
		addComponent(l_fontName, 0, 0, 4, 1); // ラベル
		addComponent(cb_fontName, 4, 0, 2, 1); // リスト
		// フォントのサイズ
		addComponent(l_fontSize, 0, 1, 4, 1); // ラベル
		addComponent(tf_fontSize, 4, 1, 1, 1); // テキストフィールド
		// 背景色
		addComponent(l_bgColor, 0, 2, 2, 1); // ラベル
		addComponent(tf_bgColor, 2, 2, 1, 1); // カラーチップ
		for (int i = 0; i < 3; i++) {
			addComponent(l_bgRGB[i], 1, (i + 3), 1, 1); // ラベル
			addComponent(sb_bgRGB[i], 2, (i + 3), 4, 1); // スクロール
			addComponent(tf_bgRGB[i], 6, (i + 3), 1, 1); // テキストフィールド
		}
		// 文字色
		addComponent(l_chColor, 0, 6, 2, 1); // ラベル
		addComponent(tf_chColor, 2, 6, 1, 1); // カラーチップ
		for (int i = 0; i < 3; i++) {
			addComponent(l_chRGB[i], 1, (i + 7), 1, 1); // ラベル
			addComponent(sb_chRGB[i], 2, (i + 7), 4, 1); // スクロール
			addComponent(tf_chRGB[i], 6, (i + 7), 1, 1); // テキストフィールド
		}
		// 更新
		addComponent(ok_btn, 5, 10, 2, 1); // ボタン
		addComponent(ng_btn, 5, 11, 2, 1); // ボタン

		tf_fontSize.addFocusListener(this);
		for (int i = 0; i < 3; i++) {
			sb_bgRGB[i].addAdjustmentListener(this);
			sb_chRGB[i].addAdjustmentListener(this);
			tf_bgRGB[i].addFocusListener(this);
			tf_chRGB[i].addFocusListener(this);
		}
		ok_btn.addActionListener(this);
		ng_btn.addActionListener(this);
		setTitle("プロパティダイアログ");
		init();
		setVisible(true);
		// setResizable(false);
	}

	private void init() {
		cb_fontName.setSelectedItem(data.getFontName());
		tf_fontSize.setText(String.valueOf(data.getFontSize()));
		int bg_rgb = data.getBgColor().getRGB() << 8;
		int ch_rgb = data.getChColor().getRGB() << 8;
		for (int i = 2; i >= 0; i--) {
			bg_rgb >>>= 8;
			ch_rgb >>>= 8;
			tf_bgRGB[i].setText(String.valueOf(bg_rgb & 0x000000FF));
			tf_chRGB[i].setText(String.valueOf(ch_rgb & 0x000000FF));
			sb_bgRGB[i].setValue(Integer.parseInt(tf_bgRGB[i].getText()));
			sb_chRGB[i].setValue(Integer.parseInt(tf_chRGB[i].getText()));
		}
	}

	private void addComponent(JComponent c, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbc.insets = new Insets(5, 5, 0, 0);
		gbl.setConstraints(c, gbc);
		getContentPane().add(c);
	}

	private Color createColor(JTextField[] color) {
		int[] rgb = new int[3];
		for (int i = 0; i < 3; i++) {
			rgb[i] = Integer.parseInt(color[i].getText());
			if (rgb[i] < 0)
				rgb[i] = 0;
			if (rgb[i] > 255)
				rgb[i] = 255;
			color[i].setText(String.valueOf(rgb[i]));
		}
		return new Color(rgb[0], rgb[1], rgb[2]);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok_btn){
			data.setFontName(cb_fontName.getSelectedItem().toString());
			int font_size = Integer.parseInt(tf_fontSize.getText());
			if (font_size < 10)		font_size = 10;
			if (font_size > 300)	font_size = 300;
			data.setFontSize(font_size);
			data.setBgColor(createColor(tf_bgRGB));
			data.setChColor(createColor(tf_chRGB));
		}
		if(e.getSource() == ng_btn){
			data.loadPrefs();
			init();
		}
		owner.repaint();
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		for (int i = 0; i < 3; i++) {
			tf_bgRGB[i].setText(String.valueOf(sb_bgRGB[i].getValue()));
			tf_chRGB[i].setText(String.valueOf(sb_chRGB[i].getValue()));
		}
		tf_bgColor.setBackground(createColor(tf_bgRGB));
		tf_chColor.setBackground(createColor(tf_chRGB));
	}

	private String preStr;

	public void focusGained(FocusEvent e) {
		preStr = ((JTextField) e.getComponent()).getText();
	}

	public void focusLost(FocusEvent e) {
		int num;
		try {
			num = Integer.parseInt(((JTextField) e.getComponent()).getText());
		} catch (NumberFormatException e1) {
			((JTextField) e.getComponent()).setText(preStr);
			JOptionPane.showMessageDialog(this, "数値を入力して下さい");
			return;
		}
		if (e.getSource() == tf_fontSize) {
			tf_fontSize.setText(String.valueOf(checkInput(num, 10, 300)));
		} else {
			for (int i = 0; i < 3; i++) {
				sb_bgRGB[i].setValue(checkInput(
						Integer.parseInt(tf_bgRGB[i].getText()), 0, 255));
				sb_chRGB[i].setValue(checkInput(
						Integer.parseInt(tf_chRGB[i].getText()), 0, 255));
			}
			tf_bgColor.setBackground(createColor(tf_bgRGB));
			tf_chColor.setBackground(createColor(tf_chRGB));
		}
	}

	private int checkInput(int input, int lower, int upper) {
		if (input < lower || input > upper) {
			input = (input < lower) ? lower : upper;
			JOptionPane.showMessageDialog(this, lower + "以上" + upper + "以下の値に設定してください");
		}
		return input;
	}
}