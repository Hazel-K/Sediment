package blog.hyojin4588.pjt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTemplate {
	
	public static int executeUpdate(String sql, JdbcUpdateInterface jdbc) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			jdbc.update(ps);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps);
		}
		
		return result;
	}
	
	public static int executeQuery(String sql, JdbcSelectInterface jdbc) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			jdbc.prepared(ps);
			rs = ps.executeQuery();
			result = jdbc.executeQuery(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps);
		}
		
		return result;
	}
	
}
