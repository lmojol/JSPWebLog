package notice.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import notice.db.DBCon;
import notice.vo.Notice;

public class NoticeDao {
	
	public List<Notice> getNotices(String field,String query) throws Exception {
		Connection conn=DBCon.getConnection(); //db연결 해당문장으로 대체가능
		
		//Statement 와 PrepareStatement 두가지 차이
//      String sql="select * from notices order by to_number(seq) desc";
		
//      String sql="select * from notices";
//            sql+=" where "+field+" like ?";
//            sql+=" order by to_number(seq) desc";
//      PreparedStatement pstmt=conn.prepareStatement(sql);
//      pstmt.setString(1, "%"+query+"%");
		
      String sql="select * from notices";
            sql+=" where "+field+" like '%"+query+"%'";
            sql+=" order by to_number(seq) desc";
      Statement st=conn.createStatement();
      
      
      //결과값 가져오기
      ResultSet rs=st.executeQuery(sql);
		
		//select결과물 모두를 List에 저장
		List<Notice> list=new ArrayList<Notice>();
		while(rs.next()) {
			Notice n=new Notice();
			n.setSeq(rs.getString("seq"));
			n.setTitle(rs.getString("title"));
			n.setWriter(rs.getString("writer"));
			n.setContent(rs.getString("content"));
			n.setRegdate(rs.getDate("regdate"));
			n.setHit(rs.getInt("hit"));
			
			list.add(n); //'list'안에 n의 정보들을 담음
		}
		return list;
	}
	
	public int insert(Notice n) throws Exception {
		/*
		 * String driver = "oracle.jdbc.driver.OracleDriver"; String url =
		 * "jdbc:oracle:thin:@localhost:1521:xe"; String user = "hr"; String pw =
		 * "123456";
		 * 
		 * Class.forName(driver); Connection conn = DriverManager.getConnection(url,
		 * user, pw);
		 */
		Connection conn=DBCon.getConnection();
		
		//접속성공
		String sql = "insert into notices(seq,title,writer,content,regdate,hit)"
				+ " values((select max(to_number(seq))+1 from notices),?,'park',?,sysdate,0)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, n.getTitle());
		pstmt.setString(2, n.getContent());

		//실행
		int cnt=pstmt.executeUpdate();//insert 실행 
		
		pstmt.close();
		conn.close();
		return cnt;
	}
	
	
	public int delete(String seq) throws Exception {
		/*
		 * String driver = "oracle.jdbc.driver.OracleDriver"; String url =
		 * "jdbc:oracle:thin:@localhost:1521:xe"; String user = "hr"; String pw =
		 * "123456";
		 * 
		 * Class.forName(driver); Connection conn = DriverManager.getConnection(url,
		 * user, pw);
		 */
		Connection conn=DBCon.getConnection();
		// 접속성공
		String sql = "delete from notices where seq=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, seq);
		int af = pstmt.executeUpdate();
		

		pstmt.close();		
		conn.close();
		return af;
	}

	// update(받는 타입 (명칭정하기))
	public int update(Notice notice) throws Exception {
		/*
		 * String driver = "oracle.jdbc.driver.OracleDriver"; String url =
		 * "jdbc:oracle:thin:@localhost:1521:xe"; String user = "hr"; String pw =
		 * "123456";
		 * 
		 * System.out.println("seq : " + notice.getSeq()); Class.forName(driver);
		 * Connection conn = DriverManager.getConnection(url, user, pw);
		 */
		Connection conn=DBCon.getConnection();

		// 접속성공
		String sql = "update notices set title=?,content=? where seq=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(3, notice.getSeq());
		pstmt.setString(2, notice.getContent());
		pstmt.setString(1, notice.getTitle());
		int cnt = pstmt.executeUpdate();// psmtm형식 실행
		
		pstmt.close();
		conn.close();
		
		return cnt;
	}
public Notice getNotice(String seq) throws Exception {
		
		Connection conn=DBCon.getConnection();

		// 접속성공
		String sql = "select * from notices where seq=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, seq);
		ResultSet rs = pstmt.executeQuery();// psmtm형식 실행
		rs.next();

		/* db에 셀렉트 결과를 Notice파일에 저장 */
		Notice n = new Notice();
		n.setSeq(rs.getString("seq"));
		n.setTitle(rs.getString("title"));
		n.setWriter(rs.getString("writer"));
		n.setContent(rs.getString("content"));
		n.setRegdate(rs.getDate("regdate"));
		n.setHit(rs.getInt("hit"));

		rs.close();
		pstmt.close();
		conn.close();
		return n;
	}

	public Notice getNotice(String seq,String hit) throws Exception {
		
		Connection conn=DBCon.getConnection();
		
		//hit 1씩 증가값 처리
		int hnum=Integer.parseInt(hit); //문자인 'hit'를 숫자화
		//메소드로 처리
		hitupdate(seq,hnum);

		// 접속성공
		String sql = "select * from notices where seq=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, seq);
		ResultSet rs = pstmt.executeQuery();// psmtm형식 실행
		rs.next();

		/* db에 셀렉트 결과를 Notice파일에 저장 */
		Notice n = new Notice();
		n.setSeq(rs.getString("seq"));
		n.setTitle(rs.getString("title"));
		n.setWriter(rs.getString("writer"));
		n.setContent(rs.getString("content"));
		n.setRegdate(rs.getDate("regdate"));
		n.setHit(rs.getInt("hit"));

		rs.close();
		pstmt.close();
		conn.close();
		return n;
	}

	private void hitupdate(String seq, int hnum) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=DBCon.getConnection();
		String sql="update notices set hit=hit+? where seq=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, hnum+1);
		pstmt.setString(2, seq);
		
		pstmt.executeUpdate();   //실행
	}
}
