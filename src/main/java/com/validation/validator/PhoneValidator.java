package com.validation.validator;

import com.validation.annotation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(null == value || value.isBlank()){
            return false;
        }
        Pattern pattern = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher match = pattern.matcher(value);
        return (match.find() && match.group().equals(value));
    }

}
