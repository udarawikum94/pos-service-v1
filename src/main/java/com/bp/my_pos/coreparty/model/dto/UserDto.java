package com.bp.my_pos.coreparty.model.dto;

import java.util.Set;

public record UserDto(
        Long id,
        String username,
        boolean active,
        Set<String> roles
) {}
