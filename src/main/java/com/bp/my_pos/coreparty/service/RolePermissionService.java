package com.bp.my_pos.coreparty.service;

import com.bp.my_pos.coreparty.model.entity.Permission;
import com.bp.my_pos.coreparty.model.entity.Role;

public interface RolePermissionService {

    Role createRole(Role role);

    Permission createPermission(Permission permission);

    Role addPermissionToRole(String roleCode, String permissionCode);
}
