package cn.xzl.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by xuzhenglei on 2018/1/4.
 *  dbcp连接池工具类
 */
public class DBCPUtil {

    static DataSource ds = null;

    static {
        try {
            // 得到配置文件
            Properties prop = new Properties();
            prop.load(DBCPUtil.class.getClassLoader().getResourceAsStream(
                    "db.properties"));
            // 根据配置文件创建数据库连接池（数据源）
            ds = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("DBCP初始化异常，请检查配置文件！！！");
        }
    }

    /**
     * 得到数据库连接对象
     */
    public static Connection getConnection() {
        try {
            return ds.getConnection();

        } catch (SQLException e) {
            throw new RuntimeException("服务器忙。。。");
        }
    }

    /**
     * 关闭所有资源连接
     *
     */
    public static void releaseAll(Connection conn, Statement ps, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps = null;
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
    }

}
