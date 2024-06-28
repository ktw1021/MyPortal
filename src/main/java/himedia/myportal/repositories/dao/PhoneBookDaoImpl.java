package himedia.myportal.repositories.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import himedia.myportal.repositories.vo.PhoneBookVo;

@Repository
public class PhoneBookDaoImpl implements PhoneBookDao {

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "phonebook.";

    @Override
    public List<PhoneBookVo> selectAll() {
        return sqlSession.selectList(NAMESPACE + "selectAll");
    }

    @Override
    public int insert(PhoneBookVo phoneBook) {
        return sqlSession.insert(NAMESPACE + "insert", phoneBook);
    }

    @Override
    public int delete(Long phId) {
        return sqlSession.delete(NAMESPACE + "delete", phId);
    }
}
