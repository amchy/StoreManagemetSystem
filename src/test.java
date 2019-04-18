import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public class test {
	public static void main(String[] args) {
			java.sql.Connection conn = null;
		    java.sql.Statement st = null;
		    java.sql.ResultSet rs = null;
		    String dbUrl = "jdbc:mysql://localhost/ahmed";
		    String dbUsr = "root";
		    String dbPass = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection (dbUrl,dbUsr,dbPass);
//	        st = conn.createStatement();
//            String str = "INSERT INTO `as` (`id`, `name`, `pwd`) VALUES (NULL, 'a', 's');";
//            st.executeUpdate(str);
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM `as`");
            while(rs.next()){
                //Get values
//                String someValue =rs.getString("`as`.`name`");
              System.out.print(rs.getString("id"));
              System.out.println(rs.getString("name"));
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
	}
}
