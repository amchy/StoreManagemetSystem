package databaseConnection;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import main.MainWindow;

public class userLogin {

	public static String userLogins(String uname, String pwd) {
		java.sql.Connection conn = null;
	    java.sql.Statement st = null;
	    java.sql.ResultSet rs = null;
	    String dbUrl = "jdbc:mysql://localhost/3idots_store_management_system";
	    String dbUsr = "root";
	    String dbPass = "";
	    try {
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection (dbUrl,dbUsr,dbPass);
            st = conn.createStatement();
            rs = st.executeQuery(
            		"SELECT * FROM `employeeinfo` where username='"
            				+uname+"' and password='"+pwd+"'");
            users.userLogin ul = new users.userLogin();
            
            if(rs.next()==true){
//            	ul.successLogin(rs.getString("name"), 
//            					rs.getString("piority"), 
//            					rs.getString("employeeID"));
            	ul.dispose();
            	DisappearingMessage dm = new DisappearingMessage
            			(rs.getString("name").toUpperCase(), 3, rs.getString("piority"));
            	dm.passing(rs.getString("name"), 
    					rs.getString("piority"), 
    					Integer.parseInt(rs.getString("employeeID")));
            	
            	
            }else {
            	JOptionPane.showMessageDialog(
            			null, "Invalide username or password", 
            			"Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		return pwd;
		
	}
}
