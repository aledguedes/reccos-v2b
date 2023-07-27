package com.reccos.admin.service;

import java.util.List;

import com.reccos.admin.dto.UserRequest;
import com.reccos.admin.dto.UserResponse;

public interface UserService {

	List<UserResponse> listAll();
    UserResponse userById(Long user_id);
    UserResponse createUser(UserRequest userRequest);
    UserResponse updateUser(UserRequest userRequest, Long user_id);
    void deleteUser(Long user_id);
}
