package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.ISysLogDao;
import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuxingxing
 * @date 2020-01-29 16:52
 */
@Service
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;


    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer pageNum, Integer pageSize) throws Exception {
        //pageNum是页码值   pageSize 是每页显示条数  必须写在调用分页代码语句执行之前
        PageHelper.startPage(pageNum,pageSize);
        return sysLogDao.findAll(pageNum,pageSize);
    }
}
