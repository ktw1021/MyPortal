package himedia.myportal.services;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import himedia.myportal.repositories.vo.BoardVo;

public interface BoardService {
    List<BoardVo> getList();
    BoardVo getContent(Long no);
    boolean write(BoardVo vo);
    boolean writeWithFile(BoardVo vo, MultipartFile file);
    boolean update(BoardVo vo);
    boolean updateWithFile(BoardVo vo, MultipartFile file);
    boolean delete(Long no);
    void increaseViewcount(Long no); // 추가된 메서드
}
