package ScoreAdmin.service;

import java.util.List;

import ScoreAdmin.dao.ScoreItemDao;
import ScoreAdmin.domain.ScoreItem;
import ScoreAdmin.dto.Pagination;

public interface ScoreItemService {
	ScoreItemDao create(ScoreItem scoreItem);
	ScoreItem selecOne(int id);
	List<ScoreItem> selectAll(int page, int countPerPage);
	Pagination getPagination(int currentPage, int countPerPage, int pageSize, int totalCount);
	ScoreItemDao getScoreItemDao();
	void setScoreItemDao(ScoreItemDao scoreItemDao);
}
