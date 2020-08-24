package blog.hyojin4588.pjt.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import blog.hyojin4588.pjt.vo.UserLoginHistoryVO;
import blog.hyojin4588.pjt.vo.UserVO;

public class UserDAO {
	
	public static int insUserLoginHistory(UserLoginHistoryVO param) {
		String sql = " INSERT INTO t_user_loginhistory(i_history, i_user, ip_addr, os, browser) SELECT SEQ_USERLOGINHISTORY.nextval, ?, ?, ?, ? FROM DUAL ";
		
		return JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {
			@Override
			public void update(PreparedStatement ps) throws SQLException {
				ps.setInt(1, param.getI_user());
				ps.setNString(2, param.getIp_addr());
				ps.setNString(3, param.getOs());
				ps.setNString(4, param.getBrowser());
			}
		});
	}

	public static int insUser(UserVO param) {
		String sql = "INSERT INTO t_user"
				+ "(i_user, u_id, u_pw, u_nm, u_email) "
				+ "VALUES "
				+ "(seq_user.nextval, ?, ?, ?, ?) ";

		return JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() { // 인터페이스를 객체화한 것이 아니라 implements의 한 종류임
			@Override
			public void update(PreparedStatement ps) throws SQLException {
				ps.setNString(1, param.getUser_id());
				ps.setNString(2, param.getUser_pw());
				ps.setNString(3, param.getUser_nm());
				ps.setNString(4, param.getEmail());
			}
		});
	}
	
	public static int login(UserVO param) {
		String sql = " SELECT i_user, u_id, u_pw, u_nm FROM t_user WHERE u_id = ? ";
		
		return JdbcTemplate.executeQuery(sql, new JdbcSelectInterface() { // 인터페이스를 객체화한 것이 아니라 implements의 한 종류임

			@Override
			public void prepared(PreparedStatement ps) throws SQLException {
				ps.setNString(1, param.getUser_id());
			}

			@Override
			public int executeQuery(ResultSet rs) throws SQLException {
				if (rs.next()) {
					param.setUser_nm(rs.getNString("u_nm"));
					param.setI_user(rs.getInt("i_user"));
//					System.out.println("dd : " + param.getI_user());
					String pw = rs.getNString("u_pw");
//					System.out.println(pw);
					String mypw = param.getUser_pw();
//					System.out.println(mypw);
					if(pw.equals(mypw)) { // 문자를 == 비교하면 주소값 비교하므로 안됨
						return 1;
					} else {
						return 2;
					}
				}
				return 3;
			}
		});
	}
}
