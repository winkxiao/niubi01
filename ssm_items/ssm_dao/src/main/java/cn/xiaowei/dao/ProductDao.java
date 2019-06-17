package cn.xiaowei.dao;

import cn.xiaowei.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description: 持久层接口 产品的dao接口
 * @author: winkxiao
 * @date: 2019/3/25 11:14
 */
public interface ProductDao {

    /**
     * 功能描述:
     * 〈查询所有Product表〉
     *
     * @param
     * @return : java.util.List<cn.xiaowei.domain.Product>
     * @author : WinkXiao
     * @date : 2019/3/25 11:17
     */
    @Select("select * from product")
    public List<Product> findAll();


    /**
     * 功能描述:
     * 〈保存一个产品〉
     *
     * @param product 1
     * @return : void
     * @author : WinkXiao
     * @date : 2019/3/25 19:35
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void saveProduct(Product product);


    /**
     * 功能描述:
     * 〈根据id查询一个〉
     *
     * @param id 1
     * @return : java.util.List<cn.xiaowei.domain.Product>
     * @author : WinkXiao
     * @date : 2019/3/25 22:45
     */
    @Select("select * from product where id=#{id}")
    public Product findById(String id);
}
