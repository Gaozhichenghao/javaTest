import java.text.SimpleDateFormat;
import java.util.Date;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                System.out.println("线程启动了");
                while (!isInterrupted()) {
                    System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + "--" + isInterrupted());//调用之后为true
                }
                System.out.println("哈哈，被中断了");
            }
        };
        thread.start();
        System.out.println("线程是不是结束了"+thread.isAlive());
        Thread.sleep(1000 * 2);
        thread.interrupt();//注意，此方法不会中断一个正在运行的线程，它的作用是：在线程受到阻塞时抛出一个中断信号，这样线程就得以退出阻塞的状态
        System.out.println("线程是否被中断：" + thread.isInterrupted());//true
        System.out.println("线程是不是结束了"+thread.isAlive());
    }
}