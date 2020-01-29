package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

public interface IProductService {
    /**
     * 查询所有的产品信息
     * @return
     * @throws Exception
     */
    public List<Product> findAll(int pageNum,int pageSize) throws Exception;

    void save(Product product) throws Exception;
}
