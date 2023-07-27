package com.reccos.admin.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldsAreEqualsValidator.class)
public @interface FieldsAreEquals {
	
	String message() default "A senha deve ser igual ao campo '{field}'";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String field();
    String fieldMatch();

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        FieldsAreEquals[] value();
    }

}
