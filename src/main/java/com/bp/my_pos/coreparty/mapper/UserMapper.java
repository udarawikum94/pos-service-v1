package com.bp.my_pos.coreparty.mapper;

import com.bp.my_pos.coreparty.model.dto.UserDto;
import com.bp.my_pos.coreparty.model.entity.AppUser;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 16:56 PM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

@Component
public class UserMapper {

    public UserDto toDto(AppUser user) {
        if (user == null) return null;
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.isActive(),
                user.getRoles().stream()
                        .map(r -> r.getCode())
                        .collect(Collectors.toSet())
        );
    }
}
