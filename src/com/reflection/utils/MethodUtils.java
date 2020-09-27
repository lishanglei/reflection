package com.reflection.utils;

import com.reflection.annoation.Cache;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/9/27
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/9/27              lishanglei      v1.0.0           Created
 */
public final class MethodUtils {

    private static Map<String,Object> map =new ConcurrentHashMap<>();
    private MethodUtils(){}

    /**
     * 执行给定类的特定方法
     * @param obj           类对象
     * @param methodName    方法名称
     * @param params        方法参数
     * @return
     */
    public static Object invokeMethod(Object obj,String methodName,Object... params) throws Exception {

        Class<?> aClass = obj.getClass();
        if(params==null ||params.length==0){

            //无参数 以大key为缓存的key
            Method method = aClass.getDeclaredMethod(methodName);
            method.setAccessible(true);

            Cache cache = method.getAnnotation(Cache.class);
            if(cache!=null){
                String key = cache.key();
                Object o = map.get(key);
                if(o!=null){
                    return o;
                }
            }
            Object invoke = method.invoke(obj);
            System.out.println(invoke);
            if(cache!=null){
                String key = cache.key();
               map.put(key,invoke);
            }
            return invoke;
        }else{
            int size =params.length;
            Class<?>[] classes =new Class[size];
            Object[] objects =new Object[size];
            for (int i=0;i<size;i++){

                //参数的Class对象集合
                classes[i] =params[i].getClass();
                //参数集合
                objects[i]=params[i];
            }
            Method declaredMethod = aClass.getDeclaredMethod(methodName, classes);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(obj, objects);

            Cache cache =declaredMethod.getAnnotation(Cache.class);
            if(cache!=null){
                String key = cache.key();
                Object valueKey =objects[0];
                String cacheKey =key+"::"+valueKey;
                Object o = map.get(cacheKey);
                if(cache!=null){
                    map.put(key,invoke);
                }
            }
            System.out.println(invoke);
            return invoke;
        }

    }
}
