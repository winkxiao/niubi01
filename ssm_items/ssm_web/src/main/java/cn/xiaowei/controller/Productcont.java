package cn.xiaowei.controller;

import cn.xiaowei.domain.Product;
import cn.xiaowei.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description: 产品的控制器类
 * @author: winkxiao
 * @date: 2019/3/25 11:48
 */
@Controller
@RequestMapping("/product")
public class Productcont {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    //  @RequestParam(name = "请求的key",defaultValue = "默认值" ,required =true【需要】)-->绑定给 int page
    public String findAll(BindingAwareModelMap model, @RequestParam(name = "page",defaultValue = "1",required = true)Integer page, @RequestParam(name = "size",defaultValue = "5",required = true)Integer size) throws Exception{
        // 查询
        List<Product> all = productService.findAll(page,size);
        System.out.println(all);
        // pageInfo 就是一个分页bean
        PageInfo info = new PageInfo(all);

        model.addAttribute("productInfoList",info);


        return "product-list1";
    }


    @RequestMapping("/saveProduct")
    public String saveProduct(Product product){

        productService.saveProduct(product);

        // 重定向
        return "redirect:findAll.do";
    }
}
