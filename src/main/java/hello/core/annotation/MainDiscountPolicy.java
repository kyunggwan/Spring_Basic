package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import java.lang.annotation.*;

 // Qualifer 어노테이션의 부분들 복사
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
