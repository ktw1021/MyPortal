package himedia.myportal.repositories.dao;

import java.util.List;

import himedia.myportal.repositories.vo.GuestBookVo;

public interface GuestBookDao {
    List<GuestBookVo> selectAll();
	int insert(GuestBookVo vo);
    int delete(GuestBookVo vo);
    int updateById(GuestBookVo vo); // 메서드 추가
    GuestBookVo selectById(Long no);
    
}
