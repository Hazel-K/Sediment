package blog.hyojin4588.pjt.db;

import java.sql.*;

public class DbCon {
	public static Connection getCon() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "hr";
		String pswd = "koreait2020";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, pswd);
		return con;
	}
	
	public static void close(Connection con, PreparedStatement ps) {
		if (ps != null) { try {ps.close();} catch (Exception e) {} }
		if (con != null) { try {con.close();} catch (Exception e) {} }
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if (rs != null) { try {rs.close();} catch (Exception e) {} }
		close(con, ps);
	}
}