package ScoreAdmin.dao;

import java.util.List;

import ScoreAdmin.domain.ScoreItem;

public interface ScoreItemDao {
	String TABLE_NAME = "examtable4";
	String COLUMN_NAME = "name";
	String COLUMN_ID = "studentid";
	String COLUMN_KOR = "kor";
	String COLUMN_ENG = "eng";
	String COLUMN_MAT = "mat";

	// 조회
	List<ScoreItem> selectAll(int startNum, int countPerPage);
	
	int selectTotalCount();
	
	ScoreItem selectId(int id);
	
	List<ScoreItem> selectName(String Name);

	// 입력
	int selectNewId();

	int selectFirstId();

	int insertOne(ScoreItem scoreItem);
	
	//수정
	int updateOne(ScoreItem scoreItem);

	// 삭제
	int deleteOne(int id);

}
