package com.bp.my_pos.coreparty.jpa;

import com.bp.my_pos.coreparty.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 17:09 PM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByCode(String code);
}
