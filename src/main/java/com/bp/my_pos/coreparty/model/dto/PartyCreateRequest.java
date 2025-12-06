package com.bp.my_pos.coreparty.model.dto;

import jakarta.validation.constraints.NotBlank;

public record PartyCreateRequest(
        @NotBlank
        String code,

        @NotBlank
        String fullName,

        String contactPerson,
        String phone,
        String email,
        String address,
        boolean customer,
        boolean supplier,
        boolean staff
) {}
