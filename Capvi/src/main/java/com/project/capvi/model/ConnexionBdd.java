package com.project.capvi.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionBdd {

	public Connection conn = null;
	
	private ConnexionBdd()
    {
		connect();
    }
 
    /** Instance unique prÃ©-initialisÃ©e */
    private static ConnexionBdd INSTANCE = null;
     
    /** Point d'accÃ¨s pour l'instance unique du singleton */
    public static ConnexionBdd getInstance(){  
    	if (INSTANCE == null)
        {   INSTANCE = new ConnexionBdd(); 
        }
    	return INSTANCE;
    }

	public void connect() {
		
		try {
		      Class.forName("org.postgresql.Driver");
		      System.out.println("Driver O.K.");

		      String url = "jdbc:postgresql://localhost:5432/LesRoses";
		      String user = "postgres";
		      String passwd = "roses";

		      Connection co = DriverManager.getConnection(url, user, passwd);
		      this.conn=co;
		      System.out.println("Connexion effective !"); 
		     } catch (Exception e) {
		      e.printStackTrace();
		    }	
	}
}