package com.bp.my_pos.coreparty.jpa;

import com.bp.my_pos.coreparty.model.entity.BusinessParty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 12:07 PM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

public interface PartyRepository extends JpaRepository<BusinessParty, Long> {

    Optional<BusinessParty> findByCode(String code);

    List<BusinessParty> findByCustomerTrue();

    List<BusinessParty> findBySupplierTrue();
}
