package himedia.myportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.repositories.dao.GuestBookDao;
import himedia.myportal.repositories.vo.GuestBookVo;

@Service("guestbookService")
public class GuestBookServiceImpl implements GuestBookService {

    @Autowired
    GuestBookDao guestbookDao;

    @Override
    public List<GuestBookVo> getMessageList() {
        return guestbookDao.selectAll();
    }

    @Override
    public boolean writeMessage(GuestBookVo vo) {
        // 작성 기능 구현
    	int insertedCount = guestbookDao.insert(vo);
    	
        return insertedCount == 1;
    }

    @Override
    public boolean deleteMessage(GuestBookVo vo) {
        return 1 == guestbookDao.delete(vo);
    }

    @Override
    public GuestBookVo getMessageById(Long no) {
        return guestbookDao.selectById(no);
    }

    @Override
    public boolean updateMessage(GuestBookVo vo) {
        GuestBookVo existingVo = guestbookDao.selectById(vo.getNo());
        if (existingVo != null && existingVo.getPassword().equals(vo.getPassword())) {
            return guestbookDao.updateById(vo) > 0;
        }
        return false;
    }

}
