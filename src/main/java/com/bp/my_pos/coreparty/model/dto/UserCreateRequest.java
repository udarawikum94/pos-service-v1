package com.bp.my_pos.coreparty.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record UserCreateRequest(
        @NotBlank
        String username,

        @NotBlank
        String password,

        Long partyId,
        Set<String> roleCodes
) {}
