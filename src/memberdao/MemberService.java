package memberdao;

import java.util.List;

public class MemberService {
	
	public MemberDao dao;
	
	public boolean regist(Member member) {
		boolean b =false;
		
		Member m= dao.selectOne(member.getId());
		
		if(m!=null) {
			return false;
		}
		List<Member> memberList = dao.selectAll();
		for(Member mem : memberList) {
			if(mem.getEmail().equals(member.getEmail())) {
				return false;
			}
		}
		int result = dao.insertMember(member);
		if(result ==1)
			b=true;
		else
			b=false;
		
		
		
		return b;
	}
	public boolean login(String id, String pw) {
		boolean result =false;
		
		Member member=dao.selectOne(id);
		
		if(member!=null) {
			if(member.getPw().equals(pw)) {
				result=true;
			}else
				result = false;
		}else {
			result=false;
		}
		
		return result;
	}
	
	public boolean update(Member member) {
		boolean result =false;
		
		Member m=dao.selectOne(member.getId());
		
		if(m!=null) {
			result=true;
			dao.updateMember(m);
		}
		return result;
	}
	
	public void delete(Member member) {
	      int num = member.getNum();
	      
	      dao.deleteMember(num);
	   }
}
