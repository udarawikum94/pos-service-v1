package com.bp.my_pos.coreparty.service;

import com.bp.my_pos.coreparty.model.dto.UserCreateRequest;
import com.bp.my_pos.coreparty.model.dto.UserDto;

public interface UserService {

    UserDto create(UserCreateRequest request);
}
