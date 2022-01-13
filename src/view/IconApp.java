package view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class IconApp extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon iconApp;
	
	public IconApp() {
		iconApp = new ImageIcon(this.getClass().getResource("/img/iconApp.jpeg"));
		this.setOpaque(false);
		this.setBorder(null);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(iconApp.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);		
		super.paint(g);
	}
	
}
