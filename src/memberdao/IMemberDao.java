package memberdao;

import java.util.List;

public interface IMemberDao {
	
	public int insertMember(Member member) ;
	
	public void updateMember(Member member);
	
	public void deleteMember(int num);
	
	public Member selectOne(int num);
	public Member selectOne(String id);
	
	public List<Member> selectAll();
}
