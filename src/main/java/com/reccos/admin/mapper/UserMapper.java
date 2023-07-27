package com.reccos.admin.mapper;

import com.reccos.admin.dto.UserRequest;
import com.reccos.admin.dto.UserResponse;
import com.reccos.admin.models.User;

public interface UserMapper {

	User toUser(UserRequest userRequest);
    UserResponse toUserResponse(User user);
}
