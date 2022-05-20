package influencer;

import java.sql.Connection;
import java.sql.DriverManager;

//** DB 연결
//=> Connection 클래스가 DB 연결및 연결정보를 관리함
// 즉, Connection 객체를 생성해야함
public class DBConnection {
	
	// ** connection 객체 생성
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/influencer?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			System.out.println("** JDBC COnnection 성공 **");
			return DriverManager.getConnection(url,"root","mysql");
		} catch (Exception e) {
			System.out.println("** JDBC Connection 실패 => "+e);
			return null;
		}
	}
}
