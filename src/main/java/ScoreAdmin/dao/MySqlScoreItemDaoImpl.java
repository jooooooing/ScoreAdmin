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

public class MySqlScoreItemDaoImpl implements ScoreItemDao {

	public MySqlScoreItemDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("jdbc 드라이버 로드 실패");
		}
	}

	@Override
	public List<ScoreItem> getAll() {
		// TODO Auto-generated method stub
		List<ScoreItem> results = new ArrayList<>();
		String sql = "SELECT * FROM examtable4";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.102:3306/kopoctc", "root",
				"koposw31"); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String name = rs.getString(COLUMN_NAME);
				int studentid = rs.getInt(COLUMN_ID);
				int kor = rs.getInt(COLUMN_KOR);
				int eng = rs.getInt(COLUMN_ENG);
				int mat = rs.getInt(COLUMN_MAT);	

				
			}

		} catch (SQLException e) {
			throw new IllegalStateException("DB연결 실패");
		}

		return results;
	}

	@Override
	public void create(ScoreItem scoreitem) {
		// TODO Auto-generated method stub
		String sql = "create table examtable4(" + "name varchar(20)," + "studentid int not null primary key,"
				+ "kor int," + "eng int," + "mat int)" + "DEFAULT CHARSET=utf8;";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.102:3306/kopoctc", "root",
				"koposw31"); Statement stmt = conn.createStatement();) {

		} catch (SQLException e) {
			throw new IllegalStateException("DB연결 실패");
		}

	}

	@Override
	public void delete(ScoreItem scoreitem) {
		// TODO Auto-generated method stub
		String sql = "drop table examtable4;";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.102:3306/kopoctc", "root", "koposw31");
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.executeUpdate();			
		} catch (SQLException e) {
			throw new IllegalStateException("drop table 실패" + e.getMessage());
		}

		
	}

	@Override
	public void insert(ScoreItem scoreitem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void allView(ScoreItem scoreitem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(ScoreItem scoreitem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ScoreItem scoreitem) {
		// TODO Auto-generated method stub
		
	}

}
