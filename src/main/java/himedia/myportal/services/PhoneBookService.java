package himedia.myportal.services;

import java.util.List;
import himedia.myportal.repositories.vo.PhoneBookVo;

public interface PhoneBookService {
    List<PhoneBookVo> getList();
    void addPhoneBook(PhoneBookVo phoneBook);
    void deletePhoneBook(Long phId);
}
