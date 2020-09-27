package com.reflection.classes;

import com.reflection.annoation.MyAnnotation;
import com.reflection.pojo.User;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/9/27
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/9/27              lishanglei      v1.0.0           Created
 */
public class AnnotationTest {

    @Test
    public void test1() throws NoSuchMethodException {

        Class<User> userClass = User.class;
        MyAnnotation annotation = userClass.getAnnotation(MyAnnotation.class);
        if(annotation!=null){
            System.out.println(annotation.content());
        }

        System.out.println();
        Method method = userClass.getDeclaredMethod("getName");
        if(method!=null){
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            if(myAnnotation!=null){
                System.out.println(myAnnotation.content());
            }
        }
    }
}
