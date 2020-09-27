package com.reflection.pojo;

import com.reflection.annoation.MyAnnotation;
import jdk.nashorn.internal.runtime.logging.Logger;

/**
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/9/27
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/9/27              lishanglei      v1.0.0           Created
 */
@Logger
@MyAnnotation(content ="我是内容" ,num = 1)
public class User extends Animal implements MyInterface{

    private String name;

    protected Integer age;

    public String idNumber;

    public static String salary;

    public static String getSalary() {
        return salary;
    }

    public static void setSalary(String salary) {
        User.salary = salary;
    }

    public User() {
    }

    public User(String name, Integer age, String idNumber) {
        this.name = name;
        this.age = age;
        this.idNumber = idNumber;
    }

    private User(String name) {
        this.name = name;
    }


    @MyAnnotation(content = "我是李四",num = 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Integer getAge() {
        return age;
    }

    protected void setAge(Integer age) {
        this.age = age;
    }

    private String getIdNumber() {
        return idNumber;
    }

    private void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public void method1() {

    }

    public static class Bike{

        private String name;
    }

    private static class Clothes{
        private String name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }
}
