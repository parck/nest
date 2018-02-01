package cn.edots.nest.mvc.interceptor;

import java.lang.annotation.*;

/**
 * @Author ParckLee.
 * @Company wemoons.com
 * @Date 17/4/26.
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {

    boolean required() default true;

    boolean session() default true;

    boolean identity() default true;

    boolean sign() default false;
}
