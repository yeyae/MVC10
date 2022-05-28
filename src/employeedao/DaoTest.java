package employeedao;

import java.sql.SQLException;
import java.util.List;

import employeedao.Employee;
import employeedao.EmployeeDao;

public class DaoTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		try {
			
			EmployeeDao dao = new EmployeeDao();
			System.out.println("insert start");
			Employee e1 = new Employee(1, "홍길", 10, 200);
			Employee e2 = new Employee(2, "순신", 10, 200);
			
			dao.insertEmployee(e1.getEmpNo(), e1.geteName(), e1.getDeptNo(), e1.getSalary());
			dao.insertEmployee(e2.getEmpNo(), e2.geteName(), e2.getDeptNo(), e2.getSalary());
			
			List<Employee> list = dao.selectAll();
			
			for(Employee e:list) {
				
			}
			System.out.println(list.get(0));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

