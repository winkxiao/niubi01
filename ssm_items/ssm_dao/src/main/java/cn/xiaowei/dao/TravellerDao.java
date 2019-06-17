package cn.xiaowei.dao;


import cn.xiaowei.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description: 旅客dao
 * @author: winkxiao
 * @date: 2019/3/26 22:06
 */
public interface TravellerDao {


    /**
     * 功能描述:
     * 〈根据OrderID查询旅客〉
     *
     * @param oderId 1
     * @return : cn.xiaowei.domain.Traveller
     * @author : WinkXiao
     * @date : 2019/3/26 22:28
     */
    @Select("select * from traveller where id in(select travellerId  from order_traveller where orderId = #{oderId})")
    public List<Traveller> findByOrdersId(String oderId);
}
