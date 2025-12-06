package com.bp.my_pos.coreparty.jpa;

import com.bp.my_pos.coreparty.model.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 17:03 PM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Optional<Permission> findByCode(String code);
}
