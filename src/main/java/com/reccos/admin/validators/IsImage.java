package com.reccos.admin.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsImageValidator.class)
public @interface IsImage {

	String message() default "Despule, mas seu arquivo deve ser um arquivo de imagem!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
