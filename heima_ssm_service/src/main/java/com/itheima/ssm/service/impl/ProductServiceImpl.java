package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IProductDao;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liuxingxing
 * @date 2020-01-25 15:33
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll(int pageNum,int pageSize) throws Exception {
        //pageNum是页码值   pageSize 是每页显示条数  必须写在调用分页代码语句执行之前
        PageHelper.startPage(pageNum,pageSize);
        return productDao.findAll() ;
    }

    @Override
    public void save(Product product) throws Exception{
        productDao.save(product);
    }
}
