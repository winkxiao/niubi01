package cn.xiaowei.service.Impl;

import cn.xiaowei.dao.OrdersDao;
import cn.xiaowei.domain.Orders;
import cn.xiaowei.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/25 22:50
 */
@Service
@Transactional//添加事务的注解
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page,int size) {
        // 参数pageNum    页码值，pagesize 每页显示条数
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) {
        return ordersDao.findById(id);
    }
}
