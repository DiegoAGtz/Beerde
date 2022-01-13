package view;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrmNasaton extends JFrame implements MouseMotionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MainPane mainPane;
	private TitleBar titleBar;
	private int PositionX;
	private int PositionY;
	
	public FrmNasaton() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		titleBar = new TitleBar(this);
		titleBar.setBounds(0, 0, 1300, 55);
		contentPane.add(titleBar);
		
		mainPane = new MainPane();		
		contentPane.add(mainPane);
		
		titleBar.addMouseListener(this);
		titleBar.addMouseMotionListener(this);
		
	}
	
	//MouseMotionListener Mover la barra
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		setLocation(getX()+e.getX()-PositionX, getY()+e.getY()-PositionY);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//MouseListener capturar PosicionX/Y 
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		PositionX=e.getX();
		PositionY=e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		 * if(e.getSource()==lbnlCerrar) { lblCerrar.setIcon(new ImageIcon(new
		 * ImageIcon(FrmHome.class.getResource("/imag/DeleteSelected.png")));; }else
		 * if(e.getSource()==lblMinimizar) { lblMinimizar.setIcon(new ImageIcon(new
		 * ImageIcon(FrmHome.class.getResource("/imag/ExpandsArrowSelected.png")))); }
		 */
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		 * if(e.getSource()==lbnlCerrar) { lblCerrar.setIcon(new ImageIcon(new
		 * ImageIcon(FrmHome.class.getResource("/imag/Delete.png")));; }else
		 * if(e.getSource()==lblMinimizar) { lblMinimizar.setIcon(new ImageIcon(new
		 * ImageIcon(FrmHome.class.getResource("/imag/ExpandsArrow.png")))); }
		 */
	}
}




