package kr.ac.kopo.ctc.kopo31.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ScoreAdmin.dao.ScoreItemDao;
import ScoreAdmin.dao.ScoreItemDaoImpl;
import ScoreAdmin.domain.ScoreItem;

class ScoreItemDaoTest {

	private ScoreItemDao scoreItemDao = new ScoreItemDaoImpl();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/* 조회 관련 메서드 */
	@Test
	void selectAll1() { // 전체 조회

		List<ScoreItem> scoreItems = scoreItemDao.selectAll(0, 10);
		assertEquals(scoreItems.get(0).getName(), "나연");
		assertEquals(scoreItems.get(0).getStudentid(), 209901);
		assertEquals(scoreItems.get(0).getKor(), 95);
		assertEquals(scoreItems.get(0).getEng(), 100);
		assertEquals(scoreItems.get(0).getMat(), 95);
		assertEquals(scoreItems.get(1).getName(), "정연");
		assertEquals(scoreItems.get(1).getStudentid(), 209902);
		assertEquals(scoreItems.get(1).getKor(), 100);
		assertEquals(scoreItems.get(1).getEng(), 40);
		assertEquals(scoreItems.get(1).getMat(), 20);

	}

	@Test
	void selectTotalCount1() { // DB 데이터 총 개수 조회

		int selectTotalCount = scoreItemDao.selectTotalCount();
		assertEquals(selectTotalCount, 20);
	}

	@Test
	void selectId() { // 개별 상세 조회(학번)
		ScoreItem scoreItem = scoreItemDao.selectId(209901);

		assertEquals(scoreItem.getName(), "나연");
		assertEquals(scoreItem.getStudentid(), 209901);
		assertEquals(scoreItem.getKor(), 95);
		assertEquals(scoreItem.getEng(), 100);
		assertEquals(scoreItem.getMat(), 95);
	}

	@Test
	void selectName() { // 개별 상세 조회(이름클릭)
		List<ScoreItem> scoreItems = scoreItemDao.selectName("나연");
		assertEquals(scoreItems.get(0).getName(), "나연");
		assertEquals(scoreItems.get(0).getStudentid(), 209901);
		assertEquals(scoreItems.get(0).getKor(), 95);
		assertEquals(scoreItems.get(0).getEng(), 100);
		assertEquals(scoreItems.get(0).getMat(), 95);
		assertEquals(scoreItems.get(1).getName(), "나연");
		assertEquals(scoreItems.get(1).getStudentid(), 209917);
		assertEquals(scoreItems.get(1).getKor(), 43);
		assertEquals(scoreItems.get(1).getEng(), 50);
		assertEquals(scoreItems.get(1).getMat(), 70);
	}

	/* 입력 관련 메서드 */
//	@Test
//	void selectNewId() { // 새로운 학번 추가를 위한 조회
//
//		int newId = scoreItemDao.selectNewId();
//		assertEquals(newId, 209923);
//
//	}
//
//	@Test
//	void selectFirstId() { // 새로운 학번 추가를 위한 조회
//		
//		int firstId = scoreItemDao.selectFirstId();
//		assertEquals(firstId, 209901);
//
//	}

//	@Test
//	void insertOne() { // 데이터 추가
//		ScoreItem scoreItemInput = new ScoreItem();
//
//		scoreItemInput.setName("테스트");
//		scoreItemInput.setStudentid(209923);
//		scoreItemInput.setKor(99);
//		scoreItemInput.setEng(99);
//		scoreItemInput.setMat(99);
//
//		int result = scoreItemDao.insertOne(scoreItemInput);
//		ScoreItem scoreItemOutput = scoreItemDao.selectId(209923);
//		
//		
//		assertEquals(result, 1);
//		assertEquals(scoreItemOutput.getName(), "테스트");
//		assertEquals(scoreItemOutput.getStudentid(), 209923);
//		assertEquals(scoreItemOutput.getKor(), 99);
//		assertEquals(scoreItemOutput.getEng(), 99);
//		assertEquals(scoreItemOutput.getMat(), 99);
//
//	}

	/* 수정 관련 메서드 */
	
//	@Test
//	void updateOne() {
//		ScoreItem scoreItemUpdate = new ScoreItem();
//		
//		scoreItemUpdate.setName("업데이트");
//		scoreItemUpdate.setStudentid(209923);
//		scoreItemUpdate.setKor(100);
//		scoreItemUpdate.setEng(100);
//		scoreItemUpdate.setMat(100);
//		
//		int result = scoreItemDao.updateOne(scoreItemUpdate);
//		ScoreItem scoreItemOutput = scoreItemDao.selectId(209923);
//		
//		assertEquals(result, 1);
//		assertEquals(scoreItemOutput.getName(), "업데이트");
//		assertEquals(scoreItemOutput.getStudentid(), 209923);
//		assertEquals(scoreItemOutput.getKor(), 100);
//		assertEquals(scoreItemOutput.getEng(), 100);
//		assertEquals(scoreItemOutput.getMat(), 100);
//	}

	/* 삭제 관련 메서드 */
//	@Test
//	void deleteOne() {	
//		
//		int result = scoreItemDao.deleteOne(209923);
//		assertEquals(result, 1);
//		assertEquals(scoreItemDao.selectTotalCount(), 20);
//	
//		
//	}
}
