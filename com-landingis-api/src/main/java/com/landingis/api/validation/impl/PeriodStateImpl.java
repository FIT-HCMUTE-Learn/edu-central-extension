package com.landingis.api.validation.impl;

import com.landingis.api.validation.PeriodState;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

import static com.landingis.api.constant.PeriodStateConstant.*;

public class PeriodStateImpl implements ConstraintValidator<PeriodState, Integer> {
        public static final List<Integer> VALID_PERIOD_STATE = Arrays.asList(INIT, RECRUIT, DONE);

    @Override
    public void initialize(PeriodState constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return VALID_PERIOD_STATE.contains(value);
    }
}
