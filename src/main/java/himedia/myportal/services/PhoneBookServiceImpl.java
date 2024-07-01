package himedia.myportal.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import himedia.myportal.repositories.dao.PhoneBookDao;
import himedia.myportal.repositories.vo.PhoneBookVo;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    @Autowired
    private PhoneBookDao phoneBookDao;

    @Override
    public List<PhoneBookVo> getList() {
        return phoneBookDao.selectAll();
    }

    @Override
    public void addPhoneBook(PhoneBookVo phoneBook) {
        phoneBookDao.insert(phoneBook);
    }

    @Override
    public void deletePhoneBook(Long phId) {
        phoneBookDao.delete(phId);
    }
}
