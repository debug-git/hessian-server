package com.example.spring_boot_demo;

import com.example.spring_boot_demo.dao.UserMapper;
import com.example.spring_boot_demo.pojo.User;
import com.example.spring_boot_demo.service.UserService;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLock {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    //测试悲观锁
    @org.junit.Test
    public void test(){
        long start = System.currentTimeMillis();
        int threadCount = 10;   //线程数量
        int forNum = 10;    //每个线程内执行循环次数
        ThreadPoolExecutor executors = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 0; i < threadCount; i++) {
            executors.submit(() -> {
                for (int j = 0; j < forNum; j++) {
                    System.out.println(Thread.currentThread().getName() + "开始");
                    //在此方法内使用synchronized同步锁
                    int k = userService.kkk();
                    System.out.println(Thread.currentThread().getName() + "结束");
                }
            });
        }
        //等待线程池内所有线程都执行完毕
        while (executors.getCompletedTaskCount() < threadCount){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("已完成任务的线程数量:" + executors.getCompletedTaskCount());
        System.out.println("使用悲观锁执行耗时：" + (System.currentTimeMillis()-start));
        //打印最终结果
        User user2 = userMapper.selectById(1);
        System.out.println("最后结果等于：" + user2.getCount());
        TestCase.assertEquals("最终结果不等于"+(threadCount*forNum), new Integer(threadCount*forNum), user2.getCount());
    }

    //测试乐观锁
    @org.junit.Test
    public void testOptimisticLock(){
        long start = System.currentTimeMillis();
        int threadCount = 10;   //线程数量
        int forNum = 10;    //每个线程内执行循环次数
        LongAdder count = new LongAdder();  //统计总共进行了几次循环
        ThreadPoolExecutor executors = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 0; i < threadCount; i++) {
            executors.submit(() -> {
                for (int j = 0; j < forNum; j++) {
                    System.out.println(Thread.currentThread().getName() + "开始");
                    int k = 0;
                    do {
                        User user = userMapper.selectById(1);
                        user.setCount(user.getCount() + 1);
                        k = userMapper.updateVersionById(user);
                        count.add(1L);
                    }while (k < 1);
                    System.out.println(Thread.currentThread().getName() + "结束");
                }
            });
        }
        while (executors.getCompletedTaskCount() < threadCount){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("总计进行了几次循环:" + count);
        System.out.println("已完成任务的线程数量:" + executors.getCompletedTaskCount());
        System.out.println("使用乐观锁执行耗时：" + (System.currentTimeMillis()-start));
        //打印最终结果
        User user2 = userMapper.selectById(1);
        System.out.println("最后结果等于：" + user2.getCount());
        TestCase.assertEquals("最终结果不等于"+(threadCount*forNum), new Integer(threadCount*forNum), user2.getCount());
    }

}
