package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Jay
 * @date 2019/7/8
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(value = "page", defaultValue = "1") Integer pageNum, @RequestParam(value = "size", defaultValue = "5") Integer pageSize) throws Exception {
        List<SysLog> sysLogList = sysLogService.findAll(pageNum, pageSize);
        PageInfo<SysLog> pageInfo = new PageInfo<>(sysLogList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }

}
