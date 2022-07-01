package conn.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DBConn {

	public static SqlSession getSqlSession() { 
		SqlSession sess = null;
		
		String config = "resources/mybatis-config.xml"; // mybatis-config 경로 설정하기
		try {
			// session factory builder로 build(inputStream)해서 session factory를 만든다
			InputStream is = Resources.getResourceAsStream(config);
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is, "development"); 
			// 위에서 만든 session factory를 가지고 session을 만들었다..!  위에서 sqlsession을 만들었으니 그대로 변수 사용하면 됨.
			sess = ssf.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sess;
	}
	

}
