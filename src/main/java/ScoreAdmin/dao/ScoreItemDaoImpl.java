package ScoreAdmin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ScoreAdmin.domain.ScoreItem;

public class ScoreItemDaoImpl implements ScoreItemDao {
	
	//클래스 시작 시 드라이버 로드
	public ScoreItemDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("jdbc 드라이버 로드 실패" + e.getMessage());
		}
	}

	@Override
	public List<ScoreItem> selectAll(int startNum, int countPerPage) {
		// TODO Auto-generated method stub
		List<ScoreItem> results = new ArrayList<>();
		String sql = "select *, kor+eng+mat as sum, (kor+eng+mat)/3 as ave, (select count(*)+1 from examtable4 as a where (a.kor+a.eng+a.mat) > (b.kor+b.eng+b.mat)) "
				+ "as ranking from examtable4 as b limit ?, ?";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.102:3306/kopoctc", "root",
				"koposw31"); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, countPerPage);
		try (ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				String name = rs.getString(COLUMN_NAME);
				int studentId = rs.getInt(COLUMN_ID);
				int kor = rs.getInt(COLUMN_KOR);
				int eng = rs.getInt(COLUMN_ENG);
				int mat = rs.getInt(COLUMN_MAT);

				ScoreItem scoreItem = new ScoreItem(name, studentId, kor, eng, mat);
				scoreItem.setName(name);
				scoreItem.setStudentid(studentId);
				scoreItem.setKor(kor);
				scoreItem.setEng(eng);
				scoreItem.setMat(mat);

				results.add(scoreItem);
			}
		}

	}catch(Exception e) {
		throw new IllegalStateException("DB연결 실패" + e.getMessage());
	}

	return results;
	}

	@Override
	public int selectTotalCount() {
		String sql = "select count(*) from examtable4";
		int result = 0;

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.102:3306/kopoctc", "root",
				"koposw31");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			throw new IllegalStateException("DB 연결 실패" + e.getMessage());
		}

		return result;
	}

	@Override
	public ScoreItem selectId(int id) {
		String sql = "select * from examtable4 where studentid=?";
		ScoreItem scoreItem = new ScoreItem();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.102:3306/kopoctc", "root",
				"koposw31"); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			ResultSet rset = pstmt.executeQuery();
			{
				if (rset.next()) {
					scoreItem = new ScoreItem();
					scoreItem.setName(rset.getString("name"));
					scoreItem.setStudentid(rset.getInt("studentid"));
					scoreItem.setKor(rset.getInt("kor"));
					scoreItem.setEng(rset.getInt("eng"));
					scoreItem.setMat(rset.getInt("mat"));
				} else {
					scoreItem.setName("해당 학번 없음");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// throw new IllegalStateException("DB 연결 실패" + e.getMessage());
		}

		return scoreItem;
	}

	@Override
	public List<ScoreItem> selectName(String name) {
		String sql = "select * from examtable4 where name=?";
		List<ScoreItem> scoreItems = new ArrayList<ScoreItem>();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.102:3306/kopoctc", "root",
				"koposw31"); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, name);
			try (ResultSet rset = pstmt.executeQuery();) {
				while (rset.next()) {
					ScoreItem scoreItem = new ScoreItem();
					scoreItem.setName(rset.getString("name"));
					scoreItem.setStudentid(rset.getInt("studentid"));
					scoreItem.setKor(rset.getInt("kor"));
					scoreItem.setEng(rset.getInt("eng"));
					scoreItem.setMat(rset.getInt("mat"));

					scoreItems.add(scoreItem);
				}
			}
//			System.out.println(scoreItems);
		} catch (Exception e) {
			throw new IllegalStateException("DB 연결 실패" + e.getMessage());
		}

		return scoreItems;
	}

	@Override
	public int selectNewId() {
		String sql = "select studentid+1 from examtable4 where (studentid+1) not in (select studentid from examtable4)";
		int newId = 0;

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.102:3306/kopoctc", "root",
				"koposw31"); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			try (ResultSet rset = pstmt.executeQuery();) {
				rset.next();
				newId = rset.getInt(1);
			}
		} catch (Exception e) {
			throw new IllegalStateException("DB 연결 실패");
		}

		return newId;
	}

	@Override
	public int selectFirstId() {
		String sql = "select studentid from examtable4 limit 1";
		int firstId = 0;

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.102:3306/kopoctc", "root",
				"koposw31"); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			try (ResultSet rset = pstmt.executeQuery();) {
				rset.next();
				firstId = rset.getInt(1);
			}
//			System.out.println(firstId);
		} catch (Exception e) {
			throw new IllegalStateException("DB 연결 실패" + e.getMessage());
		}

		return firstId;

	}

	@Override
	public int insertOne(ScoreItem scoreItem) {
		String sql = "insert into examtable4 values(?, ?, ?, ?, ?)";
		int result = 0;

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.102:3306/kopoctc", "root",
				"koposw31"); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, scoreItem.getName());
			pstmt.setInt(2, scoreItem.getStudentid());
			pstmt.setInt(3, scoreItem.getKor());
			pstmt.setInt(4, scoreItem.getEng());
			pstmt.setInt(5, scoreItem.getMat());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}

		return result;
	}

	@Override
	public int updateOne(ScoreItem scoreItem) {
		String sql = "update examtable4 set name=?, kor=?, eng=?, mat=? where studentid=?";
		int result = 0;

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.102:3306/kopoctc", "root",
				"koposw31"); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, scoreItem.getName());
			pstmt.setInt(2, scoreItem.getKor());
			pstmt.setInt(3, scoreItem.getEng());
			pstmt.setInt(4, scoreItem.getMat());
			pstmt.setInt(5, scoreItem.getStudentid());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}

		return result;
	}

	@Override
	public int deleteOne(int id) {
		String sql = "delete from examtable4 where studentid=?";
		int result = 0;

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.102:3306/kopoctc", "root",
				"koposw31"); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}

		return result;
	}

	@Override
	public int dropTable() {
		// TODO Auto-generated method stub
		String sql = "drop table examtable4";
		int result = 0;
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.102:3306/kopoctc", "root",
				"koposw31"); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}
		
		return 0;
	}

}
