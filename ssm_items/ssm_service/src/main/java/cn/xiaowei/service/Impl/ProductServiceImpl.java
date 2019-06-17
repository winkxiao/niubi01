package cn.xiaowei.service.Impl;

import cn.xiaowei.dao.ProductDao;
import cn.xiaowei.service.ProductService;
import cn.xiaowei.domain.Product;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/25 11:21
 */
@Service
@Transactional//添加事务的注解
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao producDao;

    @Override
    public List<Product> findAll(int page,int size) {
    // 参数pageNum    页码值，pagesize 每页显示条数
        PageHelper.startPage(page,size);
        return producDao.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        producDao.saveProduct(product);
    }

    @Override
    public Product findById(String id) {
        return producDao.findById(id);
    }

}
