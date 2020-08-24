package blog.hyojin4588.pjt.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface JdbcUpdateInterface { // 인터페이스는 부모 역할만 한다, 스스로 객체화할 수 없음
	
	void update(PreparedStatement ps) throws SQLException; // 앞에 public abstract가 생략되어 있다

}
