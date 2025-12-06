package com.bp.my_pos.coreparty.service.impl;

import com.bp.my_pos.coreparty.jpa.PartyRepository;
import com.bp.my_pos.coreparty.mapper.PartyMapper;
import com.bp.my_pos.coreparty.model.dto.PartyCreateRequest;
import com.bp.my_pos.coreparty.model.dto.PartyDto;
import com.bp.my_pos.coreparty.model.entity.BusinessParty;
import com.bp.my_pos.coreparty.service.PartyService;
import com.bp.my_pos.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 23:14 PM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

@Service
@RequiredArgsConstructor
@Transactional
public class PartyServiceImpl implements PartyService {

    private final PartyRepository partyRepository;
    private final PartyMapper partyMapper;

    @Override
    public PartyDto create(PartyCreateRequest request) {
        BusinessParty entity = partyMapper.toEntity(request);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setActive(true);
        return partyMapper.toDto(partyRepository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public PartyDto getById(Long id) {
        BusinessParty party = partyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Party not found: " + id));
        return partyMapper.toDto(party);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PartyDto> getAllCustomers() {
        return partyRepository.findByCustomerTrue().stream()
                .map(partyMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PartyDto> getAllSuppliers() {
        return partyRepository.findBySupplierTrue().stream()
                .map(partyMapper::toDto)
                .toList();
    }
}
