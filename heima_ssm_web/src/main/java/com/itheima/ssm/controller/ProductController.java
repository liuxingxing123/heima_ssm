package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author liuxingxing
 * @date 2020-01-25 16:07
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")//在.xml文件中配置   同时导入jsr250坐标(jsr250-api)  此时这个注解就只有具有ADMIN这个权限的才能访问
    //此时可以省略ROLE_前缀
    public ModelAndView findAll(@RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "4") Integer pageSize)
            throws
            Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(products);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }
}
