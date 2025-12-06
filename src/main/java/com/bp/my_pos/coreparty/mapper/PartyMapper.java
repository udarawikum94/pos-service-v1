package com.bp.my_pos.coreparty.mapper;

import com.bp.my_pos.coreparty.model.dto.PartyCreateRequest;
import com.bp.my_pos.coreparty.model.dto.PartyDto;
import com.bp.my_pos.coreparty.model.entity.BusinessParty;
import org.springframework.stereotype.Component;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 11:38 AM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

@Component
public class PartyMapper {

    public BusinessParty toEntity(final PartyCreateRequest req) {
        if (req == null) return null;

        BusinessParty p = new BusinessParty();

        p.setCode(req.code());
        p.setFullName(req.fullName());
        p.setContactPerson(req.contactPerson());
        p.setPhone(req.phone());
        p.setEmail(req.email());
        p.setAddress(req.address());
        p.setCustomer(req.customer());
        p.setSupplier(req.supplier());
        p.setStaff(req.staff());
        p.setActive(true);

        return p;
    }

    public PartyDto toDto(final BusinessParty p) {
        if (p == null) return null;

        return new PartyDto(
                p.getId(),
                p.getCode(),
                p.getFullName(),
                p.getContactPerson(),
                p.getPhone(),
                p.getEmail(),
                p.getAddress(),
                p.isCustomer(),
                p.isSupplier(),
                p.isStaff(),
                p.isActive()
        );
    }
}
