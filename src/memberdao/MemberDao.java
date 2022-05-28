package memberdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import employeedao.ConnectionProvider;

public class MemberDao implements IMemberDao{

	private Connection conn;
	private static final String url="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user="jinwoo";
	private static final String password="1234";
	
	public static Connection geConnection() throws ClassNotFoundException, SQLException 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url,user,password);
	}
	
	@Override
	public int insertMember(Member member) {
		
			String sql = "insert into member values("+"member_seq.nextval,?,?,?,?, sysdate)";
			PreparedStatement pstmt = null;
			
			int result =0;
			
			try {
				conn=ConnectionProvider.geConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,member.getId());
				pstmt.setString(2,member.getPw());
				pstmt.setString(3,member.getName());
				pstmt.setString(4,member.getEmail());
				
				result = pstmt.executeUpdate();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(pstmt!=null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		return result;
	}

	@Override
	public void updateMember(Member member) {
		// TODO Auto-generated method stub
		String sql = "update member "
	            + " set id = ?,"
	            + " pw = ?,"
	            + " name = ?,"
	            + " email = ?,"
	            + " regDate = ?"
	            + " where num = ?";
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionProvider.geConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,member.getId());
			pstmt.setString(2,member.getPw());
			pstmt.setString(3,member.getName());
			pstmt.setString(4,member.getEmail());
			pstmt.setDate(5,(java.sql.Date)member.getRegDate());
			
			pstmt.setInt(6,member.getNum());
			pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void deleteMember(int num) {
		// TODO Auto-generated method stub
		String sql = "delete from member where num = ?";
		PreparedStatement pstmt = null;
			try {
				conn = ConnectionProvider.geConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1,num);
				pstmt.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(pstmt!=null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}

	@Override
	public Member selectOne(int num) {
		// TODO Auto-generated method stub
		String sql ="select * from member where num=?";
		PreparedStatement pstmt = null;
		Member member=null;
		ResultSet rs =null;

		try {
			conn = ConnectionProvider.geConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member=new Member();
				member.setNum(rs.getInt("num"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setRegDate(rs.getDate("regDate"));
				
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
		
		return member;
	}

	@Override
	public Member selectOne(String id) {
		// TODO Auto-generated method stub
		String sql ="select * from member where id=?";
		PreparedStatement pstmt = null;
		Member member=null;
		ResultSet rs =null;

		try {
			conn = ConnectionProvider.geConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member=new Member();
				member.setNum(rs.getInt("num"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setRegDate(rs.getDate("regDate"));
	
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
		
		return member;
	}

	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		String sql ="select * from member";
		PreparedStatement pstmt = null;
		Member member=null;
		ResultSet rs =null;
		List<Member> memberList = new ArrayList<Member>();
		try {
			conn = ConnectionProvider.geConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				member=new Member();
				member.setNum(rs.getInt("num"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setRegDate(rs.getDate("regDate"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return memberList;
	}
	
	
}
