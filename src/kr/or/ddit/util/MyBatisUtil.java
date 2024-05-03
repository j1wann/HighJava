package kr.or.ddit.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		try { //초기화
			// 1-1. 설정파일을 읽기위한 Reader 객체 생성하기
			// 설정파일의 인코딩 정보 설정(한글처리를 위해서...)
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("config/mybatis-config.xml");
			
			// 1-2. Reader객체를 사용하여 SqlSessionFactory객체 생성하기
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
			rd.close(); //자원반납
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
	/**
	 * SqlSession객체를 제공하기 위한 메서드
	 * @return
	 */
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession(); //기본값 : autoCommit false.
	}
	
	/**
	 * SqlSession객체를 제공하기 위한 메서드
	 * @param autoCommit autoCommit 여부값 
	 * @return SqlSession객체
	 */
	public static SqlSession getSqlSession(boolean autoCommit) {
		return sqlSessionFactory.openSession(true); //기본값 : autoCommit false.
	}
	
}
