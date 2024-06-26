package himedia.myportal.services;

import java.util.List;
import himedia.myportal.repositories.vo.BoardVo;

public interface BoardService {
    List<BoardVo> getList();
    BoardVo getContent(Long no);
    boolean write(BoardVo vo);
    boolean update(BoardVo vo);
    boolean delete(Long no);
}
