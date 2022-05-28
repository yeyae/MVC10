package memberdao;

public class MemberDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDao();
		
		Member member = new Member();
		
		member.setId("yeajin");
		member.setPw("1234");
		member.setName("예진");
		member.setEmail("yeajin@naver.com");
		
		dao.insertMember(member);
	}

}
