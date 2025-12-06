package com.bp.my_pos.coreparty.service.impl;

import com.bp.my_pos.coreparty.jpa.PermissionRepository;
import com.bp.my_pos.coreparty.jpa.RoleRepository;
import com.bp.my_pos.coreparty.model.entity.Permission;
import com.bp.my_pos.coreparty.model.entity.Role;
import com.bp.my_pos.coreparty.service.RolePermissionService;
import com.bp.my_pos.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-05 09:41 AM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

@Service
@RequiredArgsConstructor
@Transactional
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Role addPermissionToRole(String roleCode, String permissionCode) {
        Role role = roleRepository.findByCode(roleCode)
                .orElseThrow(() -> new NotFoundException("Role not found: " + roleCode));

        Permission perm = permissionRepository.findByCode(permissionCode)
                .orElseThrow(() -> new NotFoundException("Permission not found: " + permissionCode));

        role.getPermissions().add(perm);

        return roleRepository.save(role);
    }
}
