package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class TitleBar extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMinimizar;
	private JLabel lblCerrar;
	private JFrame frame;
	private ImageIcon iconCerrar;
	private ImageIcon iconCerrarSelec;
	private ImageIcon iconMinim;
	private ImageIcon iconMinimSelec;
	
	public TitleBar(JFrame frame) {
		this.frame=frame;
		iconCerrar=new ImageIcon(TitleBar.class.getResource("/img/iconClose.png"));
		iconCerrarSelec=new ImageIcon(TitleBar.class.getResource("/img/iconCloseSelected.png"));
		
		iconMinim=new ImageIcon(TitleBar.class.getResource("/img/iconMini.png"));
		iconMinimSelec=new ImageIcon(TitleBar.class.getResource("/img/iconMiniSelected.png"));
		
		
		this.setBackground(new Color(27, 94, 32));
		this.setSize(1300, 55);
		setLayout(null);
		
		
		lblMinimizar = new JLabel(iconMinim);
		lblMinimizar.setBounds(1214, 11, 33, 33);	
		add(lblMinimizar);
		
		lblCerrar = new JLabel(iconCerrar);
		lblCerrar.setBounds(1257, 11, 33, 33);
		add(lblCerrar);
		
		
		lblMinimizar.addMouseListener(this);
		lblCerrar.addMouseListener(this);
		
		JLabel lblBeerde = new JLabel("BEERDE");
		lblBeerde.setFont(new Font("Arial", Font.BOLD, 32));
		lblBeerde.setForeground(Color.WHITE);
		lblBeerde.setBounds(41, 11, 132, 33);
		add(lblBeerde);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==lblMinimizar) {
			frame.setState(JFrame.ICONIFIED);
		}else if(e.getSource()==lblCerrar) {
			frame.dispose();
		}	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==lblCerrar) {
			lblCerrar.setIcon(iconCerrarSelec);
			lblCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}else if(e.getSource()==lblMinimizar) {
			lblMinimizar.setIcon(iconMinimSelec);
			lblMinimizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		} 
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub				
		if(e.getSource()==lblCerrar) {
			lblCerrar.setIcon(iconCerrar);	
			lblCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}else if(e.getSource()==lblMinimizar) {
			lblMinimizar.setIcon(iconMinim);
			lblMinimizar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		} 
	}
}