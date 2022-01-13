package controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class TableConsumoEnergetico {
	
	public ConsumoEnergetico find(String city, Connection connection) {
		ConsumoEnergetico conEner = null;
		PreparedStatement statement;
		String sql = "SELECT * FROM `consumo energetico` WHERE Ciudad = ?;";
		ResultSet rs;		
		
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, city);
			rs = statement.executeQuery();
			if(rs.first()) {
				conEner = new ConsumoEnergetico(rs.getInt("id"), rs.getString("Ciudad"), rs.getFloat("Domestico"), 
							rs.getFloat("Agricola"), rs.getFloat("Industrial"), rs.getFloat("Km/s"));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getStackTrace());
		}
		
		return conEner;
	}
	
	public ArrayList<ConsumoEnergetico> getCitys(Connection connection) {
		ArrayList<ConsumoEnergetico> citys = null;
		ConsumoEnergetico consumoEnergetico = null;
		Statement statement;
		ResultSet rs;
		String sql = "SELECT * FROM `consumo energetico`;";
		try {
			statement = (Statement) connection.createStatement();
			rs = statement.executeQuery(sql);
			citys=new ArrayList<ConsumoEnergetico>();
			while(rs.next()) {
				consumoEnergetico = new ConsumoEnergetico(rs.getInt("id"));
				consumoEnergetico.setCiudad(rs.getString("Ciudad"));
				consumoEnergetico.setDomestico(rs.getFloat("Domestico"));
				consumoEnergetico.setAgricola(rs.getFloat("Agricola"));
				consumoEnergetico.setIndustrial(rs.getFloat("Industrial"));
				consumoEnergetico.setVelocidad(rs.getFloat("Km/s"));
				citys.add(consumoEnergetico);
			}
		}catch(Exception e) {
			System.out.println("Error Table: " + e.getMessage());
		}
		
		return citys;
	}

}
