package mySqlJDBC01;
import java.sql.*;
import java.util.Scanner;

public class Ex02_MemberTest {
	private static Connection cn = Ex01_DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;
	
	// 1) MemberList
	// => "select * from member" 실행
	// => DBConnection, sql구문처리, 결과를 전달.
	public static void memberList() {
		// 1.1) DBConnection
		// => 전역변수로 처리
		sql = "select * from member order by id asc";
		
		try {
			// 1.2) sql 구문 처리
			st = cn.createStatement();	
			rs = st.executeQuery(sql);
			// 실행 시 파라미터값 (sql)을 전달받는다.
			// 1.3) 결과처리
			// (rs) ResultSet 변수에 결과가 있는지 확인 후 마지막 데이터까지 출력
			if(rs.next()) {
				// 데이터가 존재하면 출력
				System.out.println("** Member List **");
				System.out.println("| id         | password | name | lev  | birthd      |  point  |  weight |");
				do {
					//console 출력
					System.out.print(rs.getString(1)+"\t\t"); // 컬럼인덱스 가능 --> 1부터 기능
					System.out.print(rs.getString(2)+"\t");
					System.out.print(rs.getString(3)+"\t"); // 또는, 속성명 가능
					System.out.print(rs.getString(4)+"\t");
					System.out.print(rs.getString(5)+"\t");
					System.out.print(rs.getInt(6)+"\t");
					System.out.print(rs.getDouble(7)+"\n");
				}while(rs.next());
			}//if 
			else {
				System.out.println("** 출력할 데이터가 없습니다. **");
			}
			rs.close();
			st.close();
			cn.close();
		} catch (Exception e) {
			System.out.println("** sql 에러발생 => "+e);
		}
		
	}//memberList
	public static void memberDetail(String sc) {
		sql = "select * from member where name ='"+sc+"'";
		try {
			st = cn.createStatement();
			// connection 의 Statement 를 st변수값에 추가함( 파라미터 x )
			rs = st.executeQuery(sql);
			if(rs.next()) {
				System.out.println("| id | password | name | lev  | birthd      |  point  |  weight |");
				for(int i=1; i<=7; i++) {
				System.out.print(""+rs.getString(i)+"\t");
				}
			}
			else System.out.println(sc+"님의 자료는 없습니다.");
		} catch (Exception e) {
			System.out.println("** sql Detail 에러발생 => "+e);
		}
	}
	
	//** preparedStatement
	//=> 전달받을 값 위치에 ? 사용
	//=> ? : 바인딩 변수
	public static void memberDetailPst(String name) {
		sql = "select * from member where name = ?";
		// select * from member where name = '스티브'
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, name);
			// ?) 바인딩 변수를 사용하기위해 sql 파라미터값을 미리추가함.
			rs = pst.executeQuery();
			// 실행 시 파라미터값이 없다.
			if(rs.next()) {
				System.out.println("| id | password | name | lev  | birthd      |  point  |  weight |");
				for(int i=1; i<=7; i++) {
				System.out.print(""+rs.getString(i)+"\t");
				}
			}
			else System.out.println(name+"님의 자료는 없습니다.");
		} catch (Exception e) {
			System.out.println("** sql Detail 에러발생 => "+e);
		}
	} // DetailPst
	public static void insert(String id, int point, double weight) {
		sql = "insert into member values(?,'12345','이유신','A','1990-01-02',?,?)";
		try {
			// 공통모듈 구현
			pst = cn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setInt(2, point);
			pst.setDouble(3, weight);
			int count = pst.executeUpdate(); // int type return --> 처리된 Date 갯수를 리턴
			
			if(count > 0) System.out.println("** insert 성공 **");
			else System.out.println("** insert 실패 **");
		} catch (Exception e) {
			System.out.println("** sql insert 에러발생 => "+e);
		}
	}
	public static void delete(String id) {
		sql = "delete from member where id = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, id);
			int count = pst.executeUpdate();
			if(count>0)System.out.println("delete 성공");
			else System.out.println("delete 실패");
		} catch (Exception e) {
			System.out.println("sql delete 에러발생 => "+e);
		}
	}
	public static void main(String[] args) {
		memberList();
		Scanner sc = new Scanner(System.in);
		System.out.println("출력할 이름을 입력하세요 => ");
		memberDetail(sc.nextLine());
		//insert("Red", 3000, 97.32);
		memberList();
		
		//delete("Red");
		sc.close();

	}// main
}// class
