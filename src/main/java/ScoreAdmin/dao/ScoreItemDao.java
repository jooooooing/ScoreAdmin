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
	
	void create(ScoreItem scoreItem);
	ScoreItem selectOne(int id);
	List<ScoreItem> selectAll(int page, int countPerPage);	

}
