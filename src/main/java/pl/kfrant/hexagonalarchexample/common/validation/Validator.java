package pl.kfrant.hexagonalarchexample.common.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;

import java.util.Set;

public class Validator {

    private final static jakarta.validation.Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> void validate (T subject){
        Set<ConstraintViolation<T>> violationSet = validator.validate(subject);
        if(!violationSet.isEmpty()){
            throw new ConstraintViolationException(violationSet);
        }
    }
}
