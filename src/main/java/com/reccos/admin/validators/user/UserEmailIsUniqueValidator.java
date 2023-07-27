package com.reccos.admin.validators.user;

import org.springframework.stereotype.Component;

import com.reccos.admin.repository.UserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserEmailIsUniqueValidator implements ConstraintValidator<UserEmailIsUnique, String> {
	
	private final UserRepository userRepository;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
            return true;
        }
		
		var user = userRepository.findByEmail(value);
		if (user.isEmpty()) {
			return true;
		}
//		return user.isEmpty() || user.get().getEmail().equals(authentication.getName());
		return !userRepository.existsByEmail(value);
	}

}
