package com.bp.my_pos.coreparty.service;

import com.bp.my_pos.coreparty.model.dto.PartyCreateRequest;
import com.bp.my_pos.coreparty.model.dto.PartyDto;

import java.util.List;

public interface PartyService {

    PartyDto create(PartyCreateRequest request);

    PartyDto getById(Long id);

    List<PartyDto> getAllCustomers();

    List<PartyDto> getAllSuppliers();
}
