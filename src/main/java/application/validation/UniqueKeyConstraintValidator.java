package application.validation;


import application.service.BankSeekService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueKeyConstraintValidator implements ConstraintValidator <UniqueKey, String> {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BankSeekService bankSeekService;

    @Override
    public void initialize(UniqueKey uniqueKey) {
    }

    @Override
    public boolean isValid(String target, ConstraintValidatorContext constraintValidatorContext) {
        if (target != null) {
            try {
                return bankSeekService.validateBank(target);
            }
            catch (NullPointerException err) {
                return false;
            }
        }
        else {
            return true;
        }

    }
}
