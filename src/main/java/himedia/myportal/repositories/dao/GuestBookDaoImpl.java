package himedia.myportal.repositories.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.repositories.vo.GuestBookVo;

@Repository("guestbookDao")
public class GuestBookDaoImpl implements GuestBookDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<GuestBookVo> selectAll() {
		List<GuestBookVo> list = sqlSession.selectList("guestbook.selectAll");
		return list;
	}

	@Override
	public int insert(GuestBookVo vo) {
		int insertedCount = 0;
		try {
		insertedCount = sqlSession.insert("guestbook.insert", vo);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// Dao의 Exception은 구체적인 사용자 정의 예외로 전환하여 throw 한다.
			throw new GuestBookDaoException("방명록 기록 중 예외 발생",vo);
		}
		return insertedCount;
	}
	
	@Override
	public int delete(GuestBookVo vo) {
		try {
			return sqlSession.delete("guestbook.delete", vo);
		} catch (Exception e) {
			throw new GuestBookDaoException("방명록 삭제 중 예외 발생!",vo);
		}
	}
	 @Override
	    public int updateById(GuestBookVo vo) {
	        return sqlSession.update("guestbook.updateById", vo);
	    }
	@Override
	public GuestBookVo selectById(Long no) {
	    return sqlSession.selectOne("guestbook.selectById", no);
	}


}
