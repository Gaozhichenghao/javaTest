package CallableAndFuture;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//使用CountDownLatch来判断线程池所有线程结束
public class Test1 {

    public static ExecutorService executorService = Executors.newCachedThreadPool();
    private static CountDownLatch cdl = new CountDownLatch(10);
    private static final Random random = new Random();

    public void test() {
        for (int i = 0; i < 10; i++) executorService.execute(new ThreadTest());
    }

    public static void main(String[] args) {
        new Test1().test();

        //插入数据完成后  执行修改操作
        try {
            cdl.await();
        } catch (InterruptedException e) {
        }
        System.out.println("它们已经插完啦..............................");
        executorService.shutdown();

    }

    class ThreadTest implements Runnable {

        public void run() {
            //执行插入数据操作  每次插入一条s
            // 模拟耗时
            int time = random.nextInt(10000);
            System.err.println(time);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + "执行完了，耗时：" + time / 1000 + "秒");
        //执行完一个关一个
            cdl.countDown();
        }
    }
}