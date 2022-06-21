package ScoreAdmin.service;

import java.util.List;

import ScoreAdmin.dao.ScoreItemDao;
import ScoreAdmin.domain.ScoreItem;
import ScoreAdmin.dto.Pagination;

public interface ScoreItemService {
	ScoreItemDao create(ScoreItem scoreItem);

	// 조회
	List<ScoreItem> selectAll(int page, int countPerPage);

	ScoreItem selectId(int id);

	List<ScoreItem> selectName(String Name);

	// 페이지네이션
	Pagination getPagination(int currentPage, int countPerPage, int pageSize, int totalCount);

	// 입력
	int selectNewId();

	int selectFirstId();

	int insertOne(ScoreItem scoreItem);

	// 수정
	int updateOne(ScoreItem scoreItem);

	// 삭제
	int deleteOne(int id);
}
