package himedia.myportal.repositories.dao;

import java.util.List;
import himedia.myportal.repositories.vo.BoardVo;

public interface BoardDao {
    List<BoardVo> selectAll();
    int insert(BoardVo vo);
    BoardVo getContent(Long no);
    int update(BoardVo vo);
    int increaseViewcount(Long no);
    int delete(Long no);
}
