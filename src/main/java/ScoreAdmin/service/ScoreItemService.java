package ScoreAdmin.service;

import ScoreAdmin.dto.Pagination;

public interface ScoreItemService {
	Pagination getPagination(int countPerPage, int pageSize, int totalCount);

}
