package com.reccos.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.reccos.admin.dto.UserRequest;
import com.reccos.admin.dto.UserResponse;
import com.reccos.admin.exceptions.core.UserNotFoundException;
import com.reccos.admin.mapper.UserMapper;
import com.reccos.admin.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;
    private final UserRepository userReporitory;
    
	@Override
	public List<UserResponse> listAll() {
		return userReporitory.findAll()
                .stream()
                .map(userMapper::toUserResponse)
                .toList();
	}

	@Override
	public UserResponse userById(Long user_id) {
		return userReporitory.findById(user_id)
				.map(userMapper::toUserResponse)
                .orElseThrow(UserNotFoundException::new);
	}

	@Override
	public UserResponse createUser(UserRequest userRequest) {
		System.out.println("DEBUG SERVICE");
		var newUser = userMapper.toUser(userRequest);
        var createdFederation = userReporitory.save(newUser);
        return userMapper.toUserResponse(createdFederation);
	}

	@Override
	public UserResponse updateUser(UserRequest userRequest, Long user_id) {
		var user = userReporitory.findById(user_id)
                .orElseThrow(UserNotFoundException::new);
        BeanUtils.copyProperties(userRequest, user, "id", "email", "password", "createdAt", "updatedAt");
        var userAtualizado = userReporitory.save(user);
        return userMapper.toUserResponse(userAtualizado);
	}

	@Override
	public void deleteUser(Long user_id) {
		userReporitory.deleteById(user_id);
	}

}
