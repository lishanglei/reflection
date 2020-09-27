package com.reflection.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/9/27
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/9/27              lishanglei      v1.0.0           Created
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {

    String key();

    int timeOut()default 10;

    TimeUnit timeUnit() default TimeUnit.MINUTES;

}
