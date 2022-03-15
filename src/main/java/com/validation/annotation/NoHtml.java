package com.validation.annotation;

import com.validation.validator.NoHtmlValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = NoHtmlValidator.class)
@Documented
public @interface NoHtml {

    String message() default "{xss.request}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
