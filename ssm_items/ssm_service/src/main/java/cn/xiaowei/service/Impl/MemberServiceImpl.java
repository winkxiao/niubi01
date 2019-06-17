package cn.xiaowei.service.Impl;

import cn.xiaowei.dao.MemberDao;
import cn.xiaowei.domain.Member;
import cn.xiaowei.service.MemberService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/26 21:39
 */
@Service
@Transactional//添加事务的注解
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public List<Member> findAll(int page, int size) {
        // 参数pageNum    页码值，pagesize 每页显示条数
        PageHelper.startPage(page,size);
        return memberDao.findAll();
    }

    @Override
    public Member findById(String id) {
        return memberDao.findById(id);
    }
}
