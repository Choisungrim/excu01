package util_DB;

import java.sql.*;
import java.util.ArrayList;
// ** JDBC 처리 -> CRUD 
import java.util.List;
import vo.BoardVO;

public class BoardDAO {
	private Connection cn = DBConnection.getConnection();
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql;
	
	public List<BoardVO> selectList(){ //List 출력
		sql = "select * from board";
		List<BoardVO> list = new ArrayList<BoardVO>(); // List 형태로 생성자 선언
		try {
			st = cn.createStatement();  // statement 생성
			rs = st.executeQuery(sql); //sql문 쿼리 실행
			if(rs.next()) { // 진행할 결과값이 존재
				do {
					BoardVO vo = new BoardVO(); //vo객체 생성
					vo.setSeq(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setId(rs.getString(3));
					vo.setContent(rs.getString(4));
					vo.setRegdate(rs.getString(5));
					vo.setCnt(rs.getInt(6));
					list.add(vo);
				}while(rs.next());// 진행할 결과값이 존재
			}else {
				System.out.println("** 출력할 자료가 없습니다 **");
				return list=null ;
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return list=null;
		}
		return list;
	}// select *
	
	public BoardVO SelectOne(BoardVO vo) { //Select Detail
		sql = "select * from board where seq = ?";
		try {
			pst = cn.prepareStatement(sql); // 바인딩변수 처리를위한 prepareStatement 생성후 sql 쿼리 저장
			pst.setInt(1, vo.getSeq()); // 바인딩변수 처리
			rs = pst.executeQuery(); // 쿼리문 실행
			if(rs.next()) { // 출력할 결과 존재시 출력
				vo.setSeq(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setId(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setRegdate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
			}else {
				System.out.println("행 번호의 정보가 없습니다.");
				vo = null;
			}
		} catch (Exception e) {
			System.out.println("*********"+e.toString());
			vo = null;
		}
		return vo;
	}
	public int update(BoardVO vo) {
		sql="update board set cnt = cnt+1 where seq =?"; // 조회수 증가 sql
		try {
			pst=cn.prepareStatement(sql); // seq 바인딩 변수처리
			pst.setInt(1, vo.getSeq()); // 
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** update Exception => "+e);
			return 0;
		} finally {
			try {
				rs.close();
				pst.close();
				cn.close();
			} catch (Exception e2) {
				System.out.println(e2.toString());
			}
		}//try
	} //update
}
