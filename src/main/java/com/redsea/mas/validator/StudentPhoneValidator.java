package com.redsea.mas.validator;


import com.redsea.mas.domain.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StudentPhoneValidator implements ConstraintValidator<StudentPhone,Phone> {
    @Override
    public void initialize(StudentPhone studentPhone) {
        // left blank
    }

    @Override
    public boolean isValid(Phone phone, ConstraintValidatorContext context) {

        if(phone == null){
            return false;
        }

        if(phone.getPrefix() == null || phone.getNumbers()== null || phone.getArea()==null){
            return false;
        }

        System.out.println(phone.getArea());
        System.out.println(phone.getNumbers());
        System.out.println(phone.getPrefix());


        return true;
    }
}
