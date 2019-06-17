package cn.xiaowei.service;

import cn.xiaowei.domain.Member;
import cn.xiaowei.domain.Orders;

import java.util.List;

/**
 * @Description:    会员的service接口
 * @author: winkxiao
 * @date: 2019/3/26 21:38
 */
public interface MemberService {

    /**
     * 功能描述:
     * 〈查询所有会员〉
     *
     * @param page 1
     * @param size 2
     * @return : java.util.List<cn.xiaowei.domain.Orders>
     * @author : WinkXiao
     * @date : 2019/3/26 21:39
     */
    public List<Member> findAll(int page, int size);

    /**
     * 功能描述:
     * 〈根据id查会员〉
     *
     * @param id 1
     * @return : cn.xiaowei.domain.Member
     * @author : WinkXiao
     * @date : 2019/3/26 22:01
     */
    public Member findById(String id);
}
