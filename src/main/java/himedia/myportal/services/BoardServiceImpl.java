package himedia.myportal.services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import himedia.myportal.repositories.dao.BoardDao;
import himedia.myportal.repositories.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {
    private static final Log logger = LogFactory.getLog(BoardServiceImpl.class);

    @Autowired
    private BoardDao boardDao;

    @Override
    public List<BoardVo> getList() {
        try {
            return boardDao.selectAll();
        } catch (Exception e) {
            logger.error("Error fetching board list", e);
            throw new RuntimeException("게시물 목록을 가져오는 중 오류가 발생했습니다.");
        }
    }

    @Override
    @Transactional
    public BoardVo getContent(Long no) {
        try {
            // 조회수 증가
            boardDao.increaseViewcount(no);
            return boardDao.getContent(no);
        } catch (Exception e) {
            logger.error("Error fetching board content", e);
            throw new RuntimeException("게시물 내용을 가져오는 중 오류가 발생했습니다.");
        }
    }

    @Override
    public boolean write(BoardVo vo) {
        try {
            return boardDao.insert(vo) > 0;
        } catch (Exception e) {
            logger.error("Error writing board content", e);
            throw new RuntimeException("게시물을 작성하는 중 오류가 발생했습니다.");
        }
    }

    @Override
    public boolean update(BoardVo vo) {
        try {
            return boardDao.update(vo) > 0;
        } catch (Exception e) {
            logger.error("Error updating board content", e);
            throw new RuntimeException("게시물을 수정하는 중 오류가 발생했습니다.");
        }
    }

    @Override
    public boolean delete(Long no) {
        try {
            return boardDao.delete(no) > 0;
        } catch (Exception e) {
            logger.error("Error deleting board content", e);
            throw new RuntimeException("게시물을 삭제하는 중 오류가 발생했습니다.");
        }
    }
}
