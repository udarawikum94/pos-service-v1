package com.bp.my_pos.coreparty.model.dto;

public record PartyDto(
        Long id,
        String code,
        String fullName,
        String contactPerson,
        String phone,
        String email,
        String address,
        boolean customer,
        boolean supplier,
        boolean staff,
        boolean active
) {}
