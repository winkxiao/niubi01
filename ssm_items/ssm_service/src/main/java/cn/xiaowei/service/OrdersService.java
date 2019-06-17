package cn.xiaowei.service;

import cn.xiaowei.domain.Orders;
import cn.xiaowei.domain.Product;

import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/25 22:50
 */
public interface OrdersService {

    /**
     * 功能描述:
     * 〈查询所有订单〉
     *
     * @param page 1
     * @param size 2
     * @return : java.util.List<cn.xiaowei.domain.Orders>
     * @author : WinkXiao
     * @date : 2019/3/26 20:00
     */
    public List<Orders> findAll(int page,int size);

    /**
     * 功能描述:
     * 〈根据id查订单详情〉
     *
     * @param id 1
     * @return : cn.xiaowei.domain.Orders
     * @author : WinkXiao
     * @date : 2019/3/26 21:16
     */
    public Orders findById(String id);
}
