package com.validation.validator;

import com.validation.annotation.NoHtml;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoHtmlValidator implements ConstraintValidator<NoHtml, String> {

    private static final PolicyFactory DISALLOW_ALL = new HtmlPolicyBuilder().toFactory();

    @Override
    public void initialize(NoHtml constraintAnnotation) {
        // TODO specify the policy as an annotation attribute
        // to use them, values from annotation are stored in private properties here
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(null == value || value.isBlank()){
            return false;
        }
        String sanitized = DISALLOW_ALL.sanitize(value);
        return sanitized.equals(value);
    }

}
