package com.bp.my_pos.coreparty.jpa;

import com.bp.my_pos.coreparty.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 16:59 PM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);
}
