package application.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueKeyConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueKey {

    public String message() default "Банк с указанным БИК уже содержиться в системе";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
