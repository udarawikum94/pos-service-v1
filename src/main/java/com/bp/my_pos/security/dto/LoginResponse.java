package com.bp.my_pos.security.dto;

import java.util.Set;

public record LoginResponse(
        String username,
        String token,
        Set<String> permissions
) {}
