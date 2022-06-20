package kr.ac.kopo.ctc.kopo31.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ScoreAdmin.dao.ScoreItemDao;
import ScoreAdmin.dto.Pagination;
import ScoreAdmin.service.ScoreItemService;
import ScoreAdmin.service.ScoreItemServiceImpl;
import kr.ac.kopo.ctc.kopo31.dao.ScoreItemDaoMock;

class ScoreItemServiceTest2 {

	private ScoreItemDao scoreItemDao = new ScoreItemDaoMock();
	private ScoreItemService scoreItemService = new ScoreItemServiceImpl();

	@BeforeEach
	void setUp() throws Exception {
		scoreItemService.setScoreItemDao(scoreItemDao);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	//Parameter : currPage : 현재 페이지 , countPerPage : 한 페이지에 나올 숫자 목록, pageSize : 한 페이지 게시글 수, totalCount : 전체 게시글 수
	//결과값 : PpPage : 첫 페이지, pPage: 이전 쪽, nPage : 다음 쪽, nnPage: 끝페이지, cPage:현재 페이지
	
	@Test
	void testPagination() {
		Pagination p = scoreItemService.getPagination(1, 15, 50, 1025);		// 현재 페이지, 페이지당 쪽수, 한 페이지 게시글 수, 전체 게시글 수
		assertEquals(p.getPpPage(), 1); //1 고정
		assertEquals(p.getpPage(), 1); //전 페이지 첫번째 쪽
		assertEquals(p.getnPage(), 16); //다음 페이지 첫번재 쪽
		assertEquals(p.getNnPage(), 21); //끝페이지 전체 목록 / 1페이지 목록+나머지(+1)
		assertEquals(p.getcPage(), 1); //현재 페이지
	}
	
	@Test
	void testPagination2() {
		Pagination p = scoreItemService.getPagination(17, 15, 50, 1025);		// 현재 페이지, 페이지당 쪽수, 한 페이지 게시글 수, 전체 게시글 수
		assertEquals(p.getPpPage(), 1); //1 고정
		assertEquals(p.getpPage(), 1); //전 페이지 첫번째 쪽
		assertEquals(p.getnPage(), 21); //다음 페이지 첫번재 쪽
		assertEquals(p.getNnPage(), 21); //끝페이지 전체 목록 / 1페이지 목록+나머지(+1)
		assertEquals(p.getcPage(), 17); //현재 페이지
	}
	
	@Test
	void testPagination3() {
		Pagination p = scoreItemService.getPagination(21, 15, 50, 1025);		// 현재 페이지, 페이지당 쪽수, 한 페이지 게시글 수, 전체 게시글 수
		assertEquals(p.getPpPage(), 1); //1 고정
		assertEquals(p.getpPage(), 1); //전 페이지 첫번째 쪽
		assertEquals(p.getnPage(), 21); //다음 페이지 첫번재 쪽
		assertEquals(p.getNnPage(), 21); //끝페이지 전체 목록 / 1페이지 목록+나머지(+1)
		assertEquals(p.getcPage(), 21); //현재 페이지
	}
	
	@Test
	void testPagination4() {
		Pagination p = scoreItemService.getPagination(-10, 15, 50, 1025);		// 현재 페이지, 페이지당 쪽수, 한 페이지 게시글 수, 전체 게시글 수
		assertEquals(p.getPpPage(), 1); //1 고정
		assertEquals(p.getpPage(), 1); //전 페이지 첫번째 쪽
		assertEquals(p.getnPage(), 16); //다음 페이지 첫번재 쪽
		assertEquals(p.getNnPage(), 21); //끝페이지 전체 목록 / 1페이지 목록+나머지(+1)
		assertEquals(p.getcPage(), 1); //현재 페이지
	}
	
	@Test
	void testPagination5() {
		Pagination p = scoreItemService.getPagination(25, 15, 50, 1025);		// 현재 페이지, 페이지당 쪽수, 한 페이지 게시글 수, 전체 게시글 수
		assertEquals(p.getPpPage(), 1); //1 고정
		assertEquals(p.getpPage(), 1); //전 페이지 첫번째 쪽
		assertEquals(p.getnPage(), 21); //다음 페이지 첫번재 쪽
		assertEquals(p.getNnPage(), 21); //끝페이지 전체 목록 / 1페이지 목록+나머지(+1)
		assertEquals(p.getcPage(), 21); //현재 페이지
	}
	
	@Test
	void testPagination6() {
		Pagination p = scoreItemService.getPagination(1, 10, 30, 725);		// 현재 페이지, 페이지당 쪽수, 한 페이지 게시글 수, 전체 게시글 수
		assertEquals(p.getPpPage(), 1); //1 고정
		assertEquals(p.getpPage(), 1); //전 페이지 첫번째 쪽
		assertEquals(p.getnPage(), 11); //다음 페이지 첫번재 쪽
		assertEquals(p.getNnPage(), 25); //끝페이지 전체 목록 / 1페이지 목록+나머지(+1)
		assertEquals(p.getcPage(), 1); //현재 페이지
	}
	
	@Test
	void testPagination7() {
		Pagination p = scoreItemService.getPagination(16, 10, 30, 725);		// 현재 페이지, 페이지당 쪽수, 한 페이지 게시글 수, 전체 게시글 수
		assertEquals(p.getPpPage(), 1); //1 고정
		assertEquals(p.getpPage(), 1); //전 페이지 첫번째 쪽
		assertEquals(p.getnPage(), 21); //다음 페이지 첫번재 쪽
		assertEquals(p.getNnPage(), 25); //끝페이지 전체 목록 / 1페이지 목록+나머지(+1)
		assertEquals(p.getcPage(), 16); //현재 페이지
	}
	
	@Test
	void testPagination8() {
		Pagination p = scoreItemService.getPagination(25, 10, 30, 725);		// 현재 페이지, 페이지당 쪽수, 한 페이지 게시글 수, 전체 게시글 수
		assertEquals(p.getPpPage(), 1); //1 고정
		assertEquals(p.getpPage(), 11); //전 페이지 첫번째 쪽
		assertEquals(p.getnPage(), 25); //다음 페이지 첫번재 쪽
		assertEquals(p.getNnPage(), 25); //끝페이지 전체 목록 / 1페이지 목록+나머지(+1)
		assertEquals(p.getcPage(), 25); //현재 페이지
	}
	
	@Test
	void testPagination9() {
		Pagination p = scoreItemService.getPagination(-100, 10, 30, 725);		// 현재 페이지, 페이지당 쪽수, 한 페이지 게시글 수, 전체 게시글 수
		assertEquals(p.getPpPage(), 1); //1 고정
		assertEquals(p.getpPage(), 1); //전 페이지 첫번째 쪽
		assertEquals(p.getnPage(), 11); //다음 페이지 첫번재 쪽
		assertEquals(p.getNnPage(), 25); //끝페이지 전체 목록 / 1페이지 목록+나머지(+1)
		assertEquals(p.getcPage(), 1); //현재 페이지
	}
	
	@Test
	void testPagination10() {
		Pagination p = scoreItemService.getPagination(100, 10, 30, 725);		// 현재 페이지, 페이지당 쪽수, 한 페이지 게시글 수, 전체 게시글 수
		assertEquals(p.getPpPage(), 1); //1 고정
		assertEquals(p.getpPage(), 11); //전 페이지 첫번째 쪽
		assertEquals(p.getnPage(), 25); //다음 페이지 첫번재 쪽
		assertEquals(p.getNnPage(), 25); //끝페이지 전체 목록 / 1페이지 목록+나머지(+1)
		assertEquals(p.getcPage(), 25); //현재 페이지
	}
	
	
	@Test
	void testPagination11() {
		Pagination p = scoreItemService.getPagination(1, 10, 30, 0);		// 현재 페이지, 페이지당 쪽수, 한 페이지 게시글 수, 전체 게시글 수
		assertEquals(p.getPpPage(), 1); //1 고정
		assertEquals(p.getpPage(), 1); //전 페이지 첫번째 쪽
		assertEquals(p.getnPage(), 1); //다음 페이지 첫번재 쪽
		assertEquals(p.getNnPage(), 1); //끝페이지 전체 목록 / 1페이지 목록+나머지(+1)
		assertEquals(p.getcPage(), 1); //현재 페이지
	}

}
