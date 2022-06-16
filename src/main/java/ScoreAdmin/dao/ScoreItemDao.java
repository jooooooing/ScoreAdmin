package ScoreAdmin.dao;

import java.util.List;

import ScoreAdmin.domain.ScoreItem;

public interface ScoreItemDao {
	String TABLE_NAME = "score";
	String COLUMN_NAME = "name";
	String COLUMN_ID = "studentid";
	String COLUMN_KOR = "kor";
	String COLUMN_ENG = "eng";
	String COLUMN_MAT = "mat";
	
	List<ScoreItem> getAll();
	
	void create(ScoreItem scoreitem);
	void delete(ScoreItem scoreitem);
	void insert(ScoreItem scoreitem);
	
	void allView(ScoreItem scoreitem);
	void add(ScoreItem scoreitem);
	void update(ScoreItem scoreitem);
	
	
	
	


}
