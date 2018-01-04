package cn.xzl.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by xuzhenglei on 2018/1/4.
 */
public class ConstantUtil {

    private static  Properties properties =null;

    static {
        properties=new Properties();
        try {
            properties.load(new InputStreamReader(ConstantUtil.class.getClassLoader().getResourceAsStream("constant.properties"),"utf-8"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化constant.properties文件异常");
        }
    }

    public static String get(String name){
        return (String)properties.get(name);
    }
}
