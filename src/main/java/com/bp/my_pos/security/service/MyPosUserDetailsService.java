package com.bp.my_pos.security.service;

import com.bp.my_pos.coreparty.jpa.AppUserRepository;
import com.bp.my_pos.coreparty.model.entity.AppUser;
import com.bp.my_pos.security.model.MyPosUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 11:20 AM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

@Service
@RequiredArgsConstructor
public class MyPosUserDetailsService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(perm -> new SimpleGrantedAuthority(perm.getCode()))
                .collect(Collectors.toSet());

        return new MyPosUserDetails(
                user.getUsername(),
                user.getPasswordHash(),
                user.isActive(),
                authorities
        );
    }
}
