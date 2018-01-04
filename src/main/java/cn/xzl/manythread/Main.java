package cn.xzl.manythread;

import cn.xzl.utils.ConstantUtil;
import cn.xzl.utils.DbUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xuzhenglei on 2018/1/4.
 * 多线程批量插入数据
 */
public class Main {
    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        for (int i = 0; i <Integer.valueOf(ConstantUtil.get("many.size")) ; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    DbUtil.execute(ConstantUtil.get("many.sql"));
                }
            });
        }
        //关闭线程池
        threadPool.shutdown();
    }
}
