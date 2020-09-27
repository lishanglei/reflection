package com.reflection.controller;

import com.reflection.annoation.Cache;
import com.reflection.pojo.User;

/**
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/9/27
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/9/27              lishanglei      v1.0.0           Created
 */
public class UserController {

    private User[] users =new User[]{
            new User(            "张三",18,"1001"),
            new User(            "李四",18,"1001"),
            new User(            "王五",18,"1001"),
            new User(            "赵六",18,"1001"),
            new User(            "田七",18,"1001"),
    };

    @Cache(key = "user")
    public User getUserById(Integer id){

        System.out.println("查询用户方法执行了");
        return users[id];
    }
}
