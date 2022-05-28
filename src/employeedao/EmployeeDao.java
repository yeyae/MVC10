package employeedao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	private Connection conn;
	
	public EmployeeDao() throws ClassNotFoundException, SQLException {
		this.conn = ConnectionProvider.geConnection();
	}
	
	public Employee selectOne(int empno) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		Employee emp = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from employee_test"+"where enum="+empno;
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				String ename=rs.getString("ename");
				int deptno=rs.getInt("deptno");
				int salary=rs.getInt("salary");
				emp=new Employee(empno,ename,deptno,salary);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			if(stmt!=null) {
				stmt.close();
			}
			if(rs!=null) 
				rs.close();
		
		}
		return emp;
	}
	public List<Employee> selectAll() throws SQLException {
		List<Employee> empList = new ArrayList<Employee>();
		Statement stmt = null;
		ResultSet rs = null;
		Employee emp = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from employee_test";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				emp=new Employee();
				emp.setEmpNo(rs.getInt(1));
				emp.seteName(rs.getString(2));
				emp.setDeptNo(rs.getInt(3));
				emp.setSalary(rs.getInt(4));
				empList.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(stmt!=null) {
				stmt.close();
			}
			if(rs!=null) rs.close();
		}
		
		
		return empList;
	}
	
	public int insertEmployee(int empNo, String eName ,int deptNo ,int salary) throws SQLException {
		int res=0;
		Statement stmt = null;
		
		try {
			stmt=conn.createStatement();
			String sql = "insert into employee_test"+"values("+empNo+","
					+"'"+eName+"'"+","+deptNo+","+salary+")";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(stmt!=null) {
				stmt.close();
			}
		}
		return res;
														
	}
	public int deleteEmployee(int empno) throws SQLException {
		int res=0;
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			String sql = "delete from employee_test"+"where enum="+empno;
			res=stmt.executeUpdate(sql);
			System.out.println(res+"개의 행 영향");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(stmt!=null) {
				stmt.close();
			}
		return res;
		}
	}	
	public int updateEmployee(int empNo, String eName ,int deptNo ,int salary) throws SQLException {
		int res=0;
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			String sql = "update employee_test"+"set ename="+eName+","
					+"depno = "+deptNo+","
					+"salary = "+salary
					+"where enum = "+empNo;
			res=stmt.executeUpdate(sql);
			System.out.println(res+"개의 행 영향");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(stmt!=null) {
				stmt.close();
			}
		}	
		return res;
	}
}
