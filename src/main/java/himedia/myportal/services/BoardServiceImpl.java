package himedia.myportal.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import himedia.myportal.repositories.dao.BoardDao;
import himedia.myportal.repositories.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao boardDao;

    @Override
    public List<BoardVo> getList() {
        return boardDao.selectAll();
    }

    @Override
    public BoardVo getContent(Long no) {
        increaseViewcount(no); // 조회수 증가 호출
        return boardDao.getContent(no);
    }

    @Override
    public boolean write(BoardVo vo) {
        return boardDao.insert(vo) == 1;
    }

    @Override
    public boolean writeWithFile(BoardVo vo, MultipartFile file) {
        if (!file.isEmpty()) {
            String filePath = saveFile(file);
            vo.setFilePath(filePath);
        }
        return write(vo);
    }

    @Override
    public boolean update(BoardVo vo) {
        return boardDao.update(vo) == 1;
    }

    @Override
    public boolean updateWithFile(BoardVo vo, MultipartFile file) {
        if (!file.isEmpty()) {
            String filePath = saveFile(file);
            vo.setFilePath(filePath);
        }
        return update(vo);
    }

    @Override
    public boolean delete(Long no) {
        return boardDao.delete(no) == 1;
    }

    @Override
    public void increaseViewcount(Long no) {
        boardDao.increaseViewcount(no);
    }

    private String saveFile(MultipartFile file) {
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        String filePath = "C:/uploads/" + fileName; // 수정된 파일 저장 경로
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
