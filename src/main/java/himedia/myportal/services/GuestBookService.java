package himedia.myportal.services;

import java.util.List;
import himedia.myportal.repositories.vo.GuestBookVo;

public interface GuestBookService {
    List<GuestBookVo> getMessageList();
    boolean writeMessage(GuestBookVo vo);
    boolean deleteMessage(GuestBookVo vo);  
    GuestBookVo getMessageById(Long no);
    boolean updateMessage(GuestBookVo vo);

}
