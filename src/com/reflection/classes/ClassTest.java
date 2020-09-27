package com.reflection.classes;

import com.reflection.pojo.Animal;
import com.reflection.pojo.User;
import com.reflection.utils.MethodUtils;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/9/27
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/9/27              lishanglei      v1.0.0           Created
 */
public class ClassTest {

    @Test
    public void testClass1() throws ClassNotFoundException {

        //获取一个Class
        Class<User> userClass = User.class;
        //getName  获取类名,字段,方法,构造的名称
        System.out.println(userClass.getName());
        //获取不带包名的全类名
        System.out.println(userClass.getSimpleName());
        //获取一个Class 方法2
        Class<?> userClass2 = Class.forName("com.reflection.pojo.User");
        System.out.println(userClass2.getSimpleName());

        User user = new User();
        //获取一个Class 方法3
        Class<? extends User> userClass3 = user.getClass();
        System.out.println(userClass2.getSimpleName());
    }

    @Test
    public void testClassMethod() throws IllegalAccessException, InstantiationException {

        Class<User> userClass = User.class;
        System.out.println("包名: " + userClass.getPackage());

        User user = userClass.newInstance();
        System.out.println("实例: " + user);

        //获取类加载器
        ClassLoader classLoader = userClass.getClassLoader();
        System.out.println("类加载器: " + classLoader);

        Class<?>[] classes = userClass.getClasses();
        for (Class<?> aClass : classes) {
            System.out.println("获取该类中的公共类/接口:" + aClass.getSimpleName());
        }

        Class<?>[] declaredClasses = userClass.getDeclaredClasses();
        for (Class<?> declaredClass : declaredClasses) {
            System.out.println("获取该类中包含的所有类/接口: " + declaredClass.getSimpleName());
        }
    }

    @Test
    public void testExtends() {

        Class<User> userClass = User.class;

        //把传递的类的对象转换成代表其子类的对象
        Class<? extends Animal> aClass = userClass.asSubclass(Animal.class);
        System.out.println("把传递的类的对象转换成代表其子类的对象: "+aClass.getName());

        //获取当前类继承的父类的名字
        Class<? super User> superclass = userClass.getSuperclass();
        System.out.println("获取当前类继承的父类的名字: "+superclass.getName());

        //当前类实现的接口
        Class<?>[] interfaces = userClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("当前类实现的接口: "+anInterface.getName());
        }
    }


    @Test
    public void testClassField(){

        Class<User> userClass = User.class;
        Field[] fields = userClass.getFields();
        for (Field field : fields) {
            System.out.println("获取所有共有字段: "+field.getName());
        }

        System.out.println("==========================");

        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("获取所有方法: "+declaredField.getName());
        }

    }

    @Test
    public void testClassAnnotation(){

        Class<User> userClass = User.class;

        //获取指定的注解,可以根据此注解是否存在,进行操作
        Annotation[] annotations = userClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("该Class对象的注解: "+annotation.toString());
        }

        System.out.println("=====================");
        Logger annotation = userClass.getAnnotation(Logger.class);
        System.out.println("获取指定注解: "+annotation);
    }

    @Test
    public void testClassConstructor() throws NoSuchMethodException {

        Class<User> userClass = User.class;

        //获取该类的所有公有构造方法
        Constructor<?>[] constructors = userClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("获取该类的所有公有构造方法:" +constructor);
        }
        System.out.println("=======================");

        //获取该类的所有构造方法
        Constructor<?>[] declaredConstructors = userClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println("获取该类的所有构造方法:" +constructor);
        }
        System.out.println();

        //根据参数类型获取指定的构造方法
        Constructor<User> declaredConstructor = userClass.getDeclaredConstructor(String.class,Integer.class,String.class);
        System.out.println(declaredConstructor.getName()+" : " +declaredConstructor.getParameterCount());
    }


    @Test
    public void testClassOtherMethod(){

        Class<User> userClass = User.class;
        System.out.println(userClass.isAnnotation());
        System.out.println(userClass.isInterface());
    }



    @Test
    public void testMethodUtils() throws Exception {

        User user =new User("张三",18,"10086");

        MethodUtils.invokeMethod(user, "setName", "李四");
        MethodUtils.invokeMethod(user, "getName");
    }

}
