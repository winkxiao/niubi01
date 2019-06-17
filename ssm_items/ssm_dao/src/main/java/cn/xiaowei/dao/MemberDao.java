package cn.xiaowei.dao;

import cn.xiaowei.domain.Member;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/26 21:41
 */
public interface MemberDao {

    @Select("select * from traveller")
    List<Member> findAll();

    @Select("select * from member where id = #{memberId}")
    Member findById(String memberId);
}
