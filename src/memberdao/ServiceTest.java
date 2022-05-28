package memberdao;

import java.util.List;

public class ServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberService service = new MemberService();
		MemberDao dao = new MemberDao();
		service.dao=dao;
		
		Member member = new Member();
		
//		member.setId("jinwoo");
//		member.setPw("1234");
//		member.setName("진우");
//		member.setEmail("jinwoo@naver.com");
//		
//		boolean result = service.regist(member);
//		if(result) System.out.println("회원가입 성공");
//		else System.out.println("실패");
		
//		String id="yeajin";
//		String pw="1234";
//		
//		boolean result = service.login(id, pw);
//		if(result) System.out.println("로그인 성공");
//		else System.out.println("실패 ㅠㅠㅠ");
		
		String id="yeajin";
		String pw="1234";
		member = dao.selectOne(id);
		System.out.println(member);
		
		member.setEmail("no@naver.com");
		member.setName("No yeajin");
		service.update(member);
		
		
		member = dao.selectOne(1);
		service.delete(member);
		List<Member> memberList = dao.selectAll();
		for(Member m : memberList)
			System.out.println(m);
	}

}
