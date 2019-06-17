package cn.xiaowei.dao;

import cn.xiaowei.domain.Member;
import cn.xiaowei.domain.Orders;
import cn.xiaowei.domain.Product;
import cn.xiaowei.domain.Traveller;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description: 订单dao
 * @author: winkxiao
 * @date: 2019/3/25 22:27
 */
public interface OrdersDao {

    /**
     * 功能描述:
     * 〈查询所有订单〉
     *
     * @param
     * @return : java.util.List<cn.xiaowei.domain.Orders>
     * @author : WinkXiao
     * @date : 2019/3/25 22:27
     */
    @Select("select * from Orders")
    @Results({@Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId",javaType = Product.class,one=@One(select = "cn.xiaowei.dao.ProductDao.findById"))
    })
    public List<Orders> findAll();

    /**
     * 功能描述:
     * 〈根据id查询订单详情〉
     *
     * @param id 1
     * @return : cn.xiaowei.domain.Orders
     * @author : WinkXiao
     * @date : 2019/3/26 21:18
     */
    @Select("select * from Orders where id = #{id}")
    @Results({@Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product", column = "productId",javaType = Product.class,one=@One(select = "cn.xiaowei.dao.ProductDao.findById")),
            @Result(property = "travellers", column = "id",javaType = List.class,many=@Many(select = "cn.xiaowei.dao.TravellerDao.findByOrdersId")),
            @Result(property = "member", column = "memberId",javaType = Member.class,one=@One(select = "cn.xiaowei.dao.MemberDao.findById"))
    })
    Orders findById(String id);
}
