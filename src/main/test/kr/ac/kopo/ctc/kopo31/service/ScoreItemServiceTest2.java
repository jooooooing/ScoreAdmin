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
		Pagination p = scoreItemService.getPagination(1, 15, 50, 1025);		
		assertEquals(p.getPpPage(), 1); //1 고정
		assertEquals(p.getpPage(), 1); //전 페이지 첫번째 쪽
		assertEquals(p.getnPage(), 16); //다음 페이지 첫번재 쪽
		assertEquals(p.getNnPage(), 21); //끝페이지 전체 목록 / 1페이지 목록+나머지(+1)
		assertEquals(p.getcPage(), 1); //현재 페이지
	}
	
	@Test
	void testPagination2() {
		Pagination p = scoreItemService.getPagination(40, 15, 50, 1025);
		assertEquals(p.getPpPage(), 1); //1 고정
		assertEquals(p.getpPage(), 1); //전 페이지 첫번째 쪽
		assertEquals(p.getnPage(), 21); //다음 페이지 첫번재 쪽
		assertEquals(p.getNnPage(), 21); //끝페이지 전체 목록 / 1페이지 목록+나머지(+1)
		assertEquals(p.getcPage(), 21); //현재 페이지
	}
	
	@Test
	void testPagination3() {
		Pagination p = scoreItemService.getPagination(27, 10, 50, 2551);
		assertEquals(p.getPpPage(), 1); //1 고정
		assertEquals(p.getpPage(), 11); //전 페이지 첫번째 쪽
		assertEquals(p.getnPage(), 31); //다음 페이지 첫번재 쪽
		assertEquals(p.getNnPage(), 52); //끝페이지 전체 목록 / 1페이지 목록+나머지(+1)
		assertEquals(p.getcPage(), 27); //현재 페이지
	}

}
