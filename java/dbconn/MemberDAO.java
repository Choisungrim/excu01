package mySqlJDBC02;

import java.util.*;
import java.sql.*;

import mySqlJDBC01.Ex01_DBConnection;

// Data Access Object
//** DAO(Data Access Object)
//=> SQL 구문 처리 *******************************
//=> CRUD 구현 
// 	 Create(insert), Read(select), Update, Detete

public class MemberDAO {
	private static Connection cn = Ex01_DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	// ** Read
    // => List, Detail
    // 1. memberList
    // => 처리결과(ResultSet) 를 요청클래스로 전달
    // => List 전달에 적합한 객체 필요 : ArrayList
    // => ArrayList 의 Type :  MemberVO
	public List<MemberVO> memberList() {
		sql = "select * from member order by id asc"; // 순서대로 정렬 asc(기본 값) // Desc(내림차순)
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			st = cn.createStatement();	
			rs = st.executeQuery(sql);
			// 실행 시 파라미터값 (sql)을 전달받는다.
			if(rs.next()) {
				// 데이터가 존재하면 list 에 add
				do {
					MemberVO vo = new MemberVO();
					vo.setId(rs.getString(1));
					vo.setPassword(rs.getString(2));
					vo.setName(rs.getString(3));
					vo.setLev(rs.getString(4));
					vo.setBirthd(rs.getString(5));
					vo.setPoint(rs.getInt(6));
					vo.setWeight(rs.getDouble(7));
					list.add(vo);
				}while(rs.next());
			}//if 
			else {
				System.out.println("** 출력할 데이터가 없습니다. **");
				list = null;
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			System.out.println("** sql 에러발생 => "+e);
			list = null;
		}
		return list;
	}// memberList
	
	// 2. MemberListDetail
	public MemberVO memberListDetail(MemberVO vo) {
		sql = "select * from member where id = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			// connection 의 Statement 를 st변수값에 추가함( 파라미터 x )
			rs = pst.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString(1));
				vo.setPassword(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setLev(rs.getString(4));
				vo.setBirthd(rs.getString(5));
				vo.setPoint(rs.getInt(6));
				vo.setWeight(rs.getDouble(7));
			}else vo = null;
		} catch (Exception e) {
			System.out.println("** sql Detail 에러발생 => "+e);
			vo = null;
		}
		return vo;
	}
	
	// 3. insert 
	public int insert(MemberVO vo) {
		sql = "insert into member values(?,?,?,?,?,?,?)";
		try {
			// 공통모듈 구현
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPassword());
			pst.setString(3, vo.getName());
			pst.setString(4, vo.getLev());
			pst.setString(5, vo.getBirthd());
			pst.setInt(6, vo.getPoint());
			pst.setDouble(7, vo.getWeight());
			return pst.executeUpdate(); // int type return --> 처리된 Date 갯수를 리턴
		} catch (Exception e) {
			System.out.println("insert Exception => "+e);
			return 0;
		
		}		
	}
	
	// 4. Update
	public int update(MemberVO vo) {
		sql = "update member set name=?, point=?, weight=? where id = ?";
			try {
				pst=cn.prepareStatement(sql);
				pst.setString(1, vo.getName());
				pst.setInt(2, vo.getPoint());
				pst.setDouble(3, vo.getWeight());
				pst.setString(4, vo.getId());
				return pst.executeUpdate();
			} catch (Exception e) {
				System.out.println("Update Exception => "+e);
				return 0;
			}// try
	}//update
	
	// 5. Delete
	public int delete(MemberVO vo) {
		sql = "delete from member where id = ?";
			try {
				pst=cn.prepareStatement(sql);
				pst.setString(1, vo.getId());
				return pst.executeUpdate();
			} catch (Exception e) {
				System.out.println("Delete Exception => "+e);
				return 0;
			}// try
	}// delete
	
}// class
