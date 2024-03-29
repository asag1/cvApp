package lt.codeacademy.cvbuilder.employer;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

@Target({TYPE, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidEmployer.EmployerValidator.class)
public @interface ValidActivity {

    String message() default "Invalid data";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    class ActivityValidator implements ConstraintValidator<ValidActivity, ActivityView> {

        @Override
        public boolean isValid(ActivityView activityView, ConstraintValidatorContext constraintValidatorContext) {
            if (activityView.getEndDate().isBefore(activityView.getStartDate())) {
                addValidationError("Start date is after end date", constraintValidatorContext);
                return false;
            }
            return true;
        }

        private void addValidationError(String message, ConstraintValidatorContext context) {
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
        }
    }
}

