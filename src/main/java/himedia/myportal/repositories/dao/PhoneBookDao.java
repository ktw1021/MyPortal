package himedia.myportal.repositories.dao;

import java.util.List;
import himedia.myportal.repositories.vo.PhoneBookVo;

public interface PhoneBookDao {
    List<PhoneBookVo> selectAll();
    int insert(PhoneBookVo phoneBook);
    int delete(Long phId);
}
