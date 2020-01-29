package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {
    /**
     * 查询所有订单的信息
     * @return
     * @throws Exception
     */
    List<Orders> findAll(int pageNum,int pageSize) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
