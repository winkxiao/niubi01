package cn.xiaowei.service;

import cn.xiaowei.domain.Product;

import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/25 11:20
 */
public interface ProductService {


    /**
     * 功能描述:
     * 〈查询所有Product表〉
     *
     * @param
     * @return : java.util.List<cn.xiaowei.domain.Product>
     * @author : WinkXiao
     * @date : 2019/3/25 11:17
     */
    public List<Product> findAll(int page,int size);

    /**
     * 功能描述:
     * 〈保存一个产品〉
     *
     * @param product 1
     * @return : void
     * @author : WinkXiao
     * @date : 2019/3/25 19:35
     */
    public void saveProduct(Product product);

    /**
     * 功能描述:
     * 〈查询一个产品〉
     *
     * @param id 1
     * @return : java.util.List<cn.xiaowei.domain.Product>
     * @author : WinkXiao
     * @date : 2019/3/25 22:46
     */
    public Product findById(String id);
}
