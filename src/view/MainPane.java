package view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import controller.Calculos;
import controller.ConectionDb;
import controller.ConsumoEnergetico;
import controller.TableConsumoEnergetico;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MainPane extends JPanel implements MouseListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea txtResultados;
	private JTextField txtPorcionTerreno;
	private JComboBox<String> comboUbicacion;
	private JComboBox<String> comboTipoConstruccion;
	private JComboBox<String> comboTipoTerreno;
	private JCheckBox chckbxElectricidad;
	private JCheckBox chckbxAgua;
	private JCheckBox chckbxDrenaje;
	private JCheckBox chckbxGas;
	private JButton btnBeerde;
	private JTextArea txtData;
	private JTextField txtPeople;

	/**
	 * Create the panel.
	 */
	public MainPane() {
		this.setBounds(0, 55, 1300, 645);
		this.setBackground(new Color(61,125,68));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 372, 240);
		add(panel);
		panel.setLayout(null);
		
		IconApp icono = new IconApp();
		icono.setSize(120, 120);
		icono.setLocation(242, 11);
		panel.add(icono);
		
		JLabel lblBienvenidoABeerder = new JLabel("Welcome to BEERDE");
		lblBienvenidoABeerder.setFont(new Font("Arial", Font.BOLD, 19));
		lblBienvenidoABeerder.setBounds(14, 32, 206, 38);
		lblBienvenidoABeerder.setForeground(new Color(61,125,68));
		panel.add(lblBienvenidoABeerder);
		
		JTextArea txtrParaObtenerRecomendacione = new JTextArea();
		txtrParaObtenerRecomendacione.setFont(new Font("Arial", Font.BOLD, 19));
		txtrParaObtenerRecomendacione.setText("To get recommendations\r\nplease, fill the blank spaces.");
		txtrParaObtenerRecomendacione.setBounds(14, 136, 297, 73);
		txtrParaObtenerRecomendacione.setForeground(new Color(61,125,68));
		panel.add(txtrParaObtenerRecomendacione);				
		
		JLabel lblResultados = new JLabel("Results");
		lblResultados.setOpaque(true);
		lblResultados.setBackground(Color.LIGHT_GRAY);
		lblResultados.setForeground(Color.BLACK);
		lblResultados.setFont(new Font("Arial", Font.BOLD, 16));
		lblResultados.setBounds(0, 425, 1300, 30);
		add(lblResultados);
		
		txtResultados = new JTextArea();
		txtResultados.setFont(new Font("Arial", Font.PLAIN, 14));
		txtResultados.setEditable(false);
		txtResultados.setBounds(354, 455, 946, 190);
		add(txtResultados);
		
		comboUbicacion = new JComboBox<String>();
		comboUbicacion.setBounds(484, 33, 372, 30);
		add(comboUbicacion);
		
		comboTipoConstruccion = new JComboBox<String>();
		comboTipoConstruccion.setBounds(484, 95, 372, 30);
		add(comboTipoConstruccion);
		
		comboTipoTerreno = new JComboBox<String>();
		comboTipoTerreno.setEnabled(false);
		comboTipoTerreno.setBounds(484, 164, 372, 30);
		add(comboTipoTerreno);
		
		txtPorcionTerreno = new JTextField();
		txtPorcionTerreno.setFont(new Font("Arial", Font.BOLD, 15));
		txtPorcionTerreno.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPorcionTerreno.setBounds(484, 339, 188, 30);
		add(txtPorcionTerreno);
		txtPorcionTerreno.setColumns(10);
		
		chckbxElectricidad = new JCheckBox("");
		chckbxElectricidad.setEnabled(false);
		chckbxElectricidad.setOpaque(false);
		chckbxElectricidad.setBounds(493, 236, 40, 30);
		chckbxElectricidad.setIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheck.png")));
		chckbxElectricidad.setSelectedIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckSelected.png")));
		chckbxElectricidad.setRolloverIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckRollover.png")));
		add(chckbxElectricidad);
		
		chckbxAgua = new JCheckBox("");
		chckbxAgua.setEnabled(false);
		chckbxAgua.setOpaque(false);
		chckbxAgua.setBounds(591, 236, 40, 30);
		chckbxAgua.setIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheck.png")));
		chckbxAgua.setSelectedIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckSelected.png")));
		chckbxAgua.setRolloverIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckRollover.png")));
		add(chckbxAgua);
		
		chckbxDrenaje = new JCheckBox("");
		chckbxDrenaje.setEnabled(false);
		chckbxDrenaje.setOpaque(false);
		chckbxDrenaje.setBounds(697, 236, 40, 30);
		chckbxDrenaje.setIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheck.png")));
		chckbxDrenaje.setSelectedIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckSelected.png")));
		chckbxDrenaje.setRolloverIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckRollover.png")));
		add(chckbxDrenaje);
		
		chckbxGas = new JCheckBox("");
		chckbxGas.setEnabled(false);
		chckbxGas.setOpaque(false);
		chckbxGas.setBounds(816, 236, 40, 30);
		chckbxGas.setIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheck.png")));
		chckbxGas.setSelectedIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckSelected.png")));
		chckbxGas.setRolloverIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckRollover.png")));
		add(chckbxGas);
		
		JLabel lblUbicacin = new JLabel("Location");
		lblUbicacin.setForeground(Color.WHITE);
		lblUbicacin.setFont(new Font("Arial", Font.BOLD, 17));
		lblUbicacin.setBounds(619, 65, 77, 23);
		add(lblUbicacin);
		
		JLabel lblTipoDeConstruccion = new JLabel("Type of construction");
		lblTipoDeConstruccion.setForeground(Color.WHITE);
		lblTipoDeConstruccion.setFont(new Font("Arial", Font.BOLD, 17));
		lblTipoDeConstruccion.setBounds(571, 136, 166, 17);
		add(lblTipoDeConstruccion);
		
		JLabel lblTipoDeTerreno = new JLabel("Type of construction ground");
		lblTipoDeTerreno.setForeground(Color.WHITE);
		lblTipoDeTerreno.setFont(new Font("Arial", Font.BOLD, 17));
		lblTipoDeTerreno.setBounds(535, 205, 253, 16);
		add(lblTipoDeTerreno);
		
		JLabel lblServicios = new JLabel("Local services");
		lblServicios.setForeground(Color.WHITE);
		lblServicios.setFont(new Font("Arial", Font.BOLD, 17));
		lblServicios.setBounds(580, 292, 157, 23);
		add(lblServicios);
		
		JLabel lblPorcinDelTerreno = new JLabel("Lot of land (m2)");
		lblPorcinDelTerreno.setFont(new Font("Arial", Font.BOLD, 17));
		lblPorcinDelTerreno.setForeground(Color.WHITE);
		lblPorcinDelTerreno.setBounds(515, 380, 133, 23);
		add(lblPorcinDelTerreno);
		
		JLabel lblElectricidad = new JLabel("Electric energy");
		lblElectricidad.setFont(new Font("Arial", Font.BOLD, 15));
		lblElectricidad.setForeground(Color.WHITE);
		lblElectricidad.setBounds(447, 266, 118, 23);
		add(lblElectricidad);
		
		JLabel lblAgua = new JLabel("Water");
		lblAgua.setFont(new Font("Arial", Font.BOLD, 15));
		lblAgua.setForeground(Color.WHITE);
		lblAgua.setBounds(590, 266, 41, 23);
		add(lblAgua);
		
		JLabel lblDrenaje = new JLabel("Drainage service");
		lblDrenaje.setFont(new Font("Arial", Font.BOLD, 15));
		lblDrenaje.setForeground(Color.WHITE);
		lblDrenaje.setBounds(670, 266, 133, 23);
		add(lblDrenaje);
		
		JLabel lblGas = new JLabel("Gas");
		lblGas.setFont(new Font("Arial", Font.BOLD, 15));
		lblGas.setForeground(Color.WHITE);
		lblGas.setBounds(828, 266, 28, 23);
		add(lblGas);
		
		btnBeerde = new JButton("BEERDE");
		btnBeerde.setForeground(Color.BLACK);
		btnBeerde.setOpaque(true);
		btnBeerde.setHorizontalAlignment(SwingConstants.CENTER);
		btnBeerde.setBackground(Color.WHITE);
		btnBeerde.setFont(new Font("Arial", Font.BOLD, 35));
		btnBeerde.setBounds(42, 292, 296, 94);
		add(btnBeerde);

		txtData = new JTextArea();
		txtData.setFont(new Font("Arial", Font.PLAIN, 14));
		txtData.setDoubleBuffered(true);
		txtData.setBounds(0, 455, 351, 190);
		add(txtData);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(352, 455, 3, 190);
		add(label);
		
		llenarComboUbicacion();
		llenarComboConstruccion();
		llenarComboTipoTerreno();
		
		chckbxElectricidad.addMouseListener(this);
		chckbxAgua.addMouseListener(this);
		chckbxDrenaje.addMouseListener(this);
		chckbxGas.addMouseListener(this);
		btnBeerde.addMouseListener(this);
		
		btnBeerde.addActionListener(this);
		
		txtPeople = new JTextField();
		txtPeople.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPeople.setFont(new Font("Arial", Font.BOLD, 15));
		txtPeople.setBounds(697, 340, 157, 30);
		add(txtPeople);
		txtPeople.setColumns(10);
		
		JLabel lblPeopleCapacity = new JLabel("People capacity");
		lblPeopleCapacity.setForeground(Color.WHITE);
		lblPeopleCapacity.setFont(new Font("Arial", Font.BOLD, 17));
		lblPeopleCapacity.setBounds(717, 383, 125, 17);
		add(lblPeopleCapacity);
		
//		10000 + (np*precio)
		
	}
	
	private void llenarComboUbicacion() {
		comboUbicacion.removeAllItems();
		Connection connection = ConectionDb.connectDatabase();

		TableConsumoEnergetico tConsumoEnergeticon = new TableConsumoEnergetico();
		ArrayList<ConsumoEnergetico> list = tConsumoEnergeticon.getCitys(connection);
		
		for(int i=0; i<list.size();i++) {
			comboUbicacion.addItem(list.get(i).getCiudad());
		}
		ConectionDb.closeConection(connection);
	}
	
	private void llenarComboConstruccion() {
		comboTipoConstruccion.removeAllItems();
		comboTipoConstruccion.addItem("Domestic");
		comboTipoConstruccion.addItem("Agricultural");
		comboTipoConstruccion.addItem("Industrial");
	}
	
	private void llenarComboTipoTerreno() {
		comboTipoTerreno.removeAllItems();
		comboTipoTerreno.addItem("Flat");
		comboTipoTerreno.addItem("Mountainous");
		comboTipoTerreno.addItem("Sandy");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
		if(e.getSource()==btnBeerde) {
			btnBeerde.setForeground(new Color(61,125,68));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		if(e.getSource()==btnBeerde) {
			btnBeerde.setForeground(Color.BLACK);
		}
	}

	// Evento del boton [Calculos]
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		txtData.setText("");
		txtResultados.setText("");
		String city = comboUbicacion.getSelectedItem().toString();
		Connection connection = ConectionDb.connectDatabase();
		TableConsumoEnergetico tb = new TableConsumoEnergetico();
		ConsumoEnergetico consumoEnergetico =  tb.find(city, connection);
		
		String data = "General data of " + consumoEnergetico.getCiudad() + ":\n"
				+ "\tElectric energy consume:\n"
					+ "\tDomestic:    " + consumoEnergetico.getDomestico() + " kW/h\n"
					+ "\tAgricultural: " + consumoEnergetico.getAgricola() +" kW/h\n"
					+ "\tIndustrial:   " + consumoEnergetico.getIndustrial() + " kW/h\n"
				+ "Wind average speed: " + consumoEnergetico.getVelocidad() + " km/s\n";
		txtData.setText(data);
		ConectionDb.closeConection(connection);
		if(comboTipoConstruccion.getSelectedIndex()==0) {
			calcularPaneles(consumoEnergetico.getDomestico());
		}else if(comboTipoConstruccion.getSelectedIndex()==1) {
			calcularPaneles(consumoEnergetico.getAgricola());
			if(consumoEnergetico.getVelocidad()>3.5) {
				txtResultados.setText(txtResultados.getText().toString()+"Wind: the average wind speed in your area is " + 
						(consumoEnergetico.getVelocidad()*60/1000) + " km/h, we recomend to use an eolic generator.\n");
			}
		}else if(comboTipoConstruccion.getSelectedIndex()==2) {
			calcularPaneles(consumoEnergetico.getIndustrial());
		}
		
	}
	
	private void calcularPaneles(double tipoConstruccion) {
		Calculos cal = new Calculos();
		double paneles = cal.calculoPaneles(tipoConstruccion, Double.parseDouble(txtPorcionTerreno.getText().toString()));
		Math.round(paneles);		
		String s = "Sun: you may use " + (int) paneles + " solar panels.\n";
		txtResultados.setText(txtResultados.getText().toString()+s);
		
		calcularAreaVerde();
	}
	
	private void calcularAreaVerde() {
		int people = Integer.parseInt(txtPeople.getText().toString());
		int g = Integer.parseInt(txtPeople.getText().toString()) * 13;
		String text = "Green area: according to the people capacity of your building it is recomended to have " + g +" m^2 of green areas.\n";
		txtResultados.setText(txtResultados.getText().toString() + text);
	}
	
}
