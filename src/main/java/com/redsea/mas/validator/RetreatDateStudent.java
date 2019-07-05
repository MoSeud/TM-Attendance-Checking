package com.redsea.mas.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = RetreatDateStudentValidator.class)
public @interface RetreatDateStudent {
	String message() default "{com.students.mum.validator.retreatDateStudent}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
