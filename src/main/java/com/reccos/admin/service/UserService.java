package com.reccos.admin.service;

import java.util.List;

import com.reccos.admin.dto.UserRequest;
import com.reccos.admin.dto.UserResponse;

public interface UserService {

	List<UserResponse> listAll();
    void deleteUser(Long user_id);
    UserResponse userById(Long user_id);
    UserResponse finduserByEmail(String email);
    UserResponse createUser(UserRequest userRequest);
    UserResponse updateUser(UserRequest userRequest, Long user_id);
}
