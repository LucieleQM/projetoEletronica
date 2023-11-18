/*package br.projetoEletronica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost/dbeletronica", "postgres", "");
		} catch (SQLException ex) {
			System.out.println("Problema ao abrir o banco" + ex.getMessage());
            return null;
		}catch(ClassNotFoundException ex){
            System.out.println("Problema ao carregar o driver de conexão!");
		}
		return null;
	}
}*/
package model;







