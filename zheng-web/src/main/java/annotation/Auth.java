package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by XR on 2016/8/29.
 */
/*该元注解通常都是用于对软件的测试*/
@Retention(RetentionPolicy.RUNTIME)

@Target({ElementType.METHOD})
public @interface Auth {
    String rule();
}
