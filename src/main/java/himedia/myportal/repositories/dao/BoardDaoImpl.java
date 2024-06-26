package himedia.myportal.repositories.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import himedia.myportal.repositories.vo.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {

    private static final Log logger = LogFactory.getLog(BoardDaoImpl.class);

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "board.";

    @Override
    public List<BoardVo> selectAll() {
        try {
            return sqlSession.selectList(NAMESPACE + "selectAll");
        } catch (DataAccessException e) {
            logger.error("Error selecting all board entries", e);
            throw e;
        }
    }

    @Override
    public int insert(BoardVo vo) {
        try {
            return sqlSession.insert(NAMESPACE + "insert", vo);
        } catch (DataAccessException e) {
            logger.error("Error inserting board entry: " + vo, e);
            throw e;
        }
    }

    @Override
    public BoardVo getContent(Long no) {
        try {
            return sqlSession.selectOne(NAMESPACE + "getContent", no);
        } catch (DataAccessException e) {
            logger.error("Error getting content for board entry no: " + no, e);
            throw e;
        }
    }

    @Override
    public int update(BoardVo vo) {
        try {
            return sqlSession.update(NAMESPACE + "update", vo);
        } catch (DataAccessException e) {
            logger.error("Error updating board entry: " + vo, e);
            throw e;
        }
    }

    @Override
    public int increaseViewcount(Long no) {
        try {
            return sqlSession.update(NAMESPACE + "increaseViewcount", no);
        } catch (DataAccessException e) {
            logger.error("Error increasing view count for board entry no: " + no, e);
            throw e;
        }
    }
    
    @Override
    public int delete(Long no) {
        try {
            return sqlSession.delete(NAMESPACE + "delete", no);
        } catch (DataAccessException e) {
            logger.error("Error deleting board entry no: " + no, e);
            throw e;
        }
    }
}
