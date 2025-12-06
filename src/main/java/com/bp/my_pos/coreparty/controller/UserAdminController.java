package com.bp.my_pos.coreparty.controller;

import com.bp.my_pos.coreparty.model.dto.UserCreateRequest;
import com.bp.my_pos.coreparty.model.dto.UserDto;
import com.bp.my_pos.coreparty.model.entity.Permission;
import com.bp.my_pos.coreparty.model.entity.Role;
import com.bp.my_pos.coreparty.service.RolePermissionService;
import com.bp.my_pos.coreparty.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 16:49 PM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class UserAdminController {

    private final UserService userService;
    private final RolePermissionService rolePermissionService;

    @PostMapping("/users")
    @PreAuthorize("hasAuthority('USER_MANAGE')")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserCreateRequest request) {
        return ResponseEntity.ok(userService.create(request));
    }

    @PostMapping("/roles")
    @PreAuthorize("hasAuthority('ROLE_MANAGE')")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        return ResponseEntity.ok(rolePermissionService.createRole(role));
    }

    @PostMapping("/permissions")
    @PreAuthorize("hasAuthority('ROLE_MANAGE')")
    public ResponseEntity<Permission> createPermission(@RequestBody Permission permission) {
        return ResponseEntity.ok(rolePermissionService.createPermission(permission));
    }

    @PostMapping("/roles/{roleCode}/permissions/{permissionCode}")
    @PreAuthorize("hasAuthority('ROLE_MANAGE')")
    public ResponseEntity<Role> addPermissionToRole(@PathVariable String roleCode,
                                                    @PathVariable String permissionCode) {
        return ResponseEntity.ok(rolePermissionService.addPermissionToRole(roleCode, permissionCode));
    }
}
