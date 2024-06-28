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
    public boolean addPhoneBook(PhoneBookVo phoneBook) {
        return phoneBookDao.insert(phoneBook) == 1;
    }

    @Override
    public boolean deletePhoneBook(Long phId) {
        return phoneBookDao.delete(phId) == 1;
    }
}
