package fileController;

import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JavaTest_Callable {
    public static ExecutorService executorService = Executors.newCachedThreadPool();

    public  void test(){
        Future<Boolean>[] futures=new Future[10];
        for (int i = 0 ;i<10;i++)
            futures[i]=executorService.submit(new ThreadTest());
        for (int i = 0; i < 10; i++) {
            try {
                boolean success= futures[i].get();
                System.out.println(String.format(Locale.CHINA,"执行完毕，结果为%s",success));
            } catch (InterruptedException|ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new JavaTest_Callable().test();
        System.out.println("执行其他任务");
        executorService.shutdown();

    }

    class ThreadTest implements Callable<Boolean>{

        @Override
        public Boolean call() throws Exception {
            System.out.println("开始插入数据");
            Thread.sleep(2000);
            return true;
        }
    }
}