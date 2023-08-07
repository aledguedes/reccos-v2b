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
				.surname(userRequest.getSurname())
	            .email(userRequest.getEmail())
	            .password(userRequest.getPassword())
				.img_perfil(userRequest.getImg_perfil())
				.role(userRequest.getRole())
				.phone(userRequest.getPhone())
	            .status(userRequest.getStatus())
	            .birth_date(userRequest.getBirth_date())
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
				.surname(user.getSurname())
	            .name(user.getName())
	            .email(user.getEmail())
				.phone(user.getPhone())
	            .img_perfil(user.getImg_perfil())
	            .createdAt(user.getCreatedAt())
	            .updatedAt(user.getUpdatedAt())
				.role(user.getRole())
	            .status(user.getStatus())
	            .birth_date(user.getBirth_date())
				.federation(user.getFederation())
	            .build();
	}

}
