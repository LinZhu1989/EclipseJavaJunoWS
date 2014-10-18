package myComponents;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

public class MyLabel extends JLabel {

	private java.awt.Font defaultFont;
	private Dimension defaultDim;
	private Color defaultColor;

	public MyLabel(String s, int c) {
		super(s, c);
		this.defaultColor = Color.WHITE;
		this.defaultDim = new Dimension(10, 10);
		this.defaultFont = new java.awt.Font("Dialog", 1, 26);
	}

	public MyLabel(String s) {
		super(s);
	}

	public void customSetting(java.awt.Font f, Dimension d, Color c) {
		this.defaultColor = c;
		this.defaultDim = d;
		this.defaultFont = f;
		this.setFont(defaultFont);
		this.setPreferredSize(defaultDim);
		this.setForeground(defaultColor);
	}

	public void toDefaultColor() {
		this.setForeground(defaultColor);
	}

	public void toWarningColor() {
		this.setForeground(Color.RED);
	}

	public void toOKColor() {
		this.setForeground(Color.GREEN);
	}

}
