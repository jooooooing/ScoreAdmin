package kr.ac.kopo.ctc.kopo31.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ScoreAdmin.dao.ScoreItemDao;
import ScoreAdmin.dao.ScoreItemDaoImpl;
import ScoreAdmin.domain.ScoreItem;
import ScoreAdmin.dto.Pagination;

class ScoreItemDaoTest {
	
	private ScoreItemDao scoreItemDao = new ScoreItemDaoImpl();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void allViewTest1() {
		try {
			List<ScoreItem> scoreItems = scoreItemDao.selectAll(0, 1);
			assertEquals(scoreItems.get(0).getName(), "나연");
			assertEquals(scoreItems.get(0).getStudentid(), 209901);
			assertEquals(scoreItems.get(0).getKor(), 95);
			assertEquals(scoreItems.get(0).getEng(), 100);
			assertEquals(scoreItems.get(0).getMat(), 95);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
