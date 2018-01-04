package cn.xzl.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by xuzhenglei on 2018/1/4.
 * 操作数据库的封装
 */
public class DbUtil {

    public static void execute(String sql){
        Connection conn = DBCPUtil.getConnection();
        Statement statement =null;
        try {
             statement= conn.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBCPUtil.releaseAll(conn,statement,null);
        }
    }
}
