package ScoreAdmin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ScoreAdmin.domain.ScoreItem;

public class ScoreItemDaoImpl implements ScoreItemDao {

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
				+ "as ranking from examtable4 as b limit 0, 10";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.102:3306/kopoctc", "root",
				"koposw31"); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String name = rs.getString(COLUMN_NAME);
				int studentid = rs.getInt(COLUMN_ID);
				int kor = rs.getInt(COLUMN_KOR);
				int eng = rs.getInt(COLUMN_ENG);
				int mat = rs.getInt(COLUMN_MAT);
				
				ScoreItem scoreItem = new ScoreItem(name, studentid, kor, eng, mat);
				scoreItem.setName(name);
				scoreItem.setStudentid(studentid);
				scoreItem.setKor(kor);
				scoreItem.setEng(eng);
				scoreItem.setMat(mat);
				
				results.add(scoreItem);
			}

		} catch (SQLException e) {
			throw new IllegalStateException("DB연결 실패" + e.getMessage());
		}

		return results;
	}

	@Override
	public int selectNewId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectFirstId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertOne(ScoreItem scoreItem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(ScoreItem scoreItem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
