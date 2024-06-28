package himedia.myportal.services;

import java.util.List;
import himedia.myportal.repositories.vo.PhoneBookVo;

public interface PhoneBookService {
    List<PhoneBookVo> getList();
    boolean addPhoneBook(PhoneBookVo phoneBook);
    boolean deletePhoneBook(Long phId);
}
