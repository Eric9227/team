package team.community.annotation;


import java.lang.annotation.*;

/**
 * @author TAN00XU
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldName {



    String value() default "";
}
