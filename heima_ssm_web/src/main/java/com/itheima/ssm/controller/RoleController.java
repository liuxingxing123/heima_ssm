package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author liuxingxing
 * @date 2020-01-28 20:18
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")//在.xml中文件中配置   此时这个注解就只有具有ADMIN这个权限的才能访问  此时可以不可省略ROLE_前缀
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception{
        roleService.save(role);
        return "redirect:findAll.do";
    }

    /**
     * 查询可选权限
     * @param roleId
     * @return
     */
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name="id",required = true) String roleId) throws
            Exception{
        Role role = roleService.findById(roleId);
        List<Permission> optionalPermission = roleService.findOptionalPermission(roleId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role", role);
        modelAndView.addObject("permissionList", optionalPermission);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    /**
     * 添加权限
     * @return
     */
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name="roleId",required = true) String roleId, @RequestParam
            (name="ids",required = true) String[] ids)
            throws Exception{
        if (roleId == null || "".equals(roleId) || ids == null || ids.length == 0) {
            return "redirect:findAll";
        }
        roleService.addPermissionToRole(roleId, ids);
        return "redirect:findAll";
    }


}
