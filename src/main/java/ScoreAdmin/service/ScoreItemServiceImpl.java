package ScoreAdmin.service;

import java.util.List;

import ScoreAdmin.dao.ScoreItemDao;
import ScoreAdmin.domain.ScoreItem;
import ScoreAdmin.dto.Pagination;

public class ScoreItemServiceImpl implements ScoreItemService {

	private ScoreItemDao scoreItemDao;

	@Override
	public Pagination getPagination(int currPage, int countPerPage, int pageSize, int totalCount) {
		// TODO Auto-generated method stub
		// Parameter : currPage : 현재 페이지 , countPerPage : 한 페이지에 보여줄 쪽 수, pageSize : 한
		// 페이지 게시글 수, totalCount : 전체 게시글 수

		if (currPage <= 1) {
			currPage = 1;
		}

		// firstPage : 제일 처음 페이지
		int firstPage = 1;

		// finalPage : 제일 마지막 페이지
		int finalPage = (int) Math.ceil((double) totalCount / pageSize); // 숫자 올림

		// 현재 페이지가 마지막 페이지보다 크면 > 현재 페이지는 마지막 페이지
		if (currPage >= finalPage) {
			currPage = finalPage;
		}

		// previousListPage : 앞 숫자 목록의 처음 숫자(<를 누르면 나오는 숫자)
		int previousListPage = (int) Math.floor((double) currPage / countPerPage);
		// int previousListPage = (currPage/countPerPage) * countPerPage + 1;

		if (previousListPage <= 1) {
			previousListPage = 1;
		} else {
			previousListPage = (previousListPage - 1) * countPerPage + 1;
		}

		// nextListPage : 다음 목록의 처음 숫자 (>를 누르면 나오는 숫자)
		int nextListPage = (int) (Math.ceil((double) currPage / countPerPage) * countPerPage) + 1;

		if (nextListPage > finalPage) {
			nextListPage = finalPage;
		}

		/*
		 * if (countPerPage <= 1) { countPerPage = 1; }
		 */
		
		if (totalCount == 0) {

			firstPage = 1;
			previousListPage = 1;
			nextListPage = 1;
			finalPage = 1;
			currPage = 1;

		}

		Pagination pagination = new Pagination();
		pagination.setPpPage(firstPage);
		pagination.setpPage(previousListPage);
		pagination.setnPage(nextListPage);
		pagination.setNnPage(finalPage);
		pagination.setcPage(currPage);

		return pagination;

	}

	@Override
	public ScoreItemDao create(ScoreItem scoreItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreItem selecOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScoreItem> selectAll(int page, int countPerPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreItemDao getScoreItemDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScoreItemDao(ScoreItemDao scoreItemDao) {
		// TODO Auto-generated method stub

	}

}
