package hello;

import java.sql.Connection;
import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="jinwoo";
		String password="1234";
		
		Connection conn = null;
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩완료");
			//연결생성
			conn = DriverManager.getConnection(url,user,password);
			
			System.out.println("연결 성공");
			
			stmt = conn.createStatement();
			
			String sql = "select * from emp where ename='SMITH'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int empno=rs.getInt(1);
				String ename=rs.getString(2);
				System.out.println("사원 이름 : "+ename);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
