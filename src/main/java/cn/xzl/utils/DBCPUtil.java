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
 *  dbcp���ӳع�����
 */
public class DBCPUtil {

    static DataSource ds = null;

    static {
        try {
            // �õ������ļ�
            Properties prop = new Properties();
            prop.load(DBCPUtil.class.getClassLoader().getResourceAsStream(
                    "db.properties"));
            // ���������ļ��������ݿ����ӳأ�����Դ��
            ds = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("DBCP��ʼ���쳣�����������ļ�������");
        }
    }

    /**
     * �õ����ݿ����Ӷ���
     */
    public static Connection getConnection() {
        try {
            return ds.getConnection();

        } catch (SQLException e) {
            throw new RuntimeException("������æ������");
        }
    }

    /**
     * �ر�������Դ����
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
