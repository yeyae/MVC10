package hello;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="jinwoo";
		String password="1234";
		
		Connection conn = null;
		java.sql.Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩완료");
			//연결생성
			conn = DriverManager.getConnection(url,user,password);
			
			System.out.println("연결 성공");
			
			stmt = conn.createStatement();
			
			String sql = "insert into dept values(50,'sw','Seoul')";
			int rowCount = stmt.executeUpdate(sql);
			System.out.println(rowCount+"개의 행 영향");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
