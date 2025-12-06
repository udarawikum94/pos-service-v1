package com.bp.my_pos.coreparty.service.impl;

import com.bp.my_pos.coreparty.jpa.AppUserRepository;
import com.bp.my_pos.coreparty.jpa.PartyRepository;
import com.bp.my_pos.coreparty.jpa.RoleRepository;
import com.bp.my_pos.coreparty.mapper.UserMapper;
import com.bp.my_pos.coreparty.model.dto.UserCreateRequest;
import com.bp.my_pos.coreparty.model.dto.UserDto;
import com.bp.my_pos.coreparty.model.entity.AppUser;
import com.bp.my_pos.coreparty.model.entity.BusinessParty;
import com.bp.my_pos.coreparty.model.entity.Role;
import com.bp.my_pos.coreparty.service.UserService;
import com.bp.my_pos.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 22:41 PM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final AppUserRepository appUserRepository;
    private final PartyRepository partyRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserDto create(UserCreateRequest request) {
        BusinessParty party = null;
        if (request.partyId() != null) {
            party = partyRepository.findById(request.partyId())
                    .orElseThrow(() -> new NotFoundException("Party not found: " + request.partyId()));
        }

        Set<Role> roles = new HashSet<>();
        if (request.roleCodes() != null) {
            for (String code : request.roleCodes()) {
                Role role = roleRepository.findByCode(code)
                        .orElseThrow(() -> new NotFoundException("Role not found: " + code));
                roles.add(role);
            }
        }

        AppUser user = new AppUser();
        user.setUsername(request.username());
        user.setPasswordHash(passwordEncoder.encode(request.password()));
        user.setActive(true);
        user.setParty(party);
        user.setRoles(roles);

        return userMapper.toDto(appUserRepository.save(user));
    }
}
