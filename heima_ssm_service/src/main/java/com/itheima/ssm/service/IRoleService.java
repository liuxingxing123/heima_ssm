package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    List<Permission> findOptionalPermission(String roleId) throws Exception;

    Role findById(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] ids) throws Exception;
}
