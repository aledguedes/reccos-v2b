package com.reccos.admin.mapper;

import org.springframework.stereotype.Component;

import com.reccos.admin.dto.UserRequest;
import com.reccos.admin.dto.UserResponse;
import com.reccos.admin.models.User;

@Component
public class UserMapperImpl implements UserMapper {

	@Override
	public User toUser(UserRequest userRequest) {
		if (userRequest == null) {
            return null;
        }
		
		return User.builder()
	            .name(userRequest.getName())
	            .email(userRequest.getEmail())
	            .password(userRequest.getPassword())
				.img_perfil(userRequest.getImg_perfil())
				.role(userRequest.getRole())
	            .status(userRequest.getStatus())
				.federation(userRequest.getFederation())
	            .build();
	}

	@Override
	public UserResponse toUserResponse(User user) {
		if (user == null) {
            return null;
        }
		
		return UserResponse.builder()
				.id(user.getId())
	            .name(user.getName())
	            .email(user.getEmail())
	            .img_perfil(user.getImg_perfil())
	            .createdAt(user.getCreatedAt())
	            .updatedAt(user.getUpdatedAt())
				.role(user.getRole())
	            .status(user.getStatus())
				.federation(user.getFederation())
	            .build();
	}

}
