package com.reflection.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/9/27
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/9/27              lishanglei      v1.0.0           Created
 */

@Target({ElementType.TYPE,ElementType.METHOD})  //作用域 类和方法
@Retention(RetentionPolicy.RUNTIME)             //当前注解会被保留到class字节码文件中,并被jvm读取到
public @interface MyAnnotation {

    String content();

    int num()default 0;

}
