package cn.xzl.singlethread;

import cn.xzl.utils.ConstantUtil;
import cn.xzl.utils.DBCPUtil;
import cn.xzl.utils.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by xuzhenglei on 2018/1/4.
 * 单线程批量插入数据入口。
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i <Integer.valueOf(ConstantUtil.get("single.size")) ; i++) {
            DbUtil.execute(ConstantUtil.get("single.sql"));
        }
    }
}
