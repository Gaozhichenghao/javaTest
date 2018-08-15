package javaTest;
import java.util.concurrent.locks.*;
public class ProduceTest {
    public static void main(String[] args) {
        Resource r = new Resource();
        Consumer c = new Consumer(r);
        Producer p = new Producer(r);
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(p);
        Thread t4 = new Thread(p);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class Consumer implements Runnable {
    private Resource r;
    public Consumer(Resource r) {
        this.r = r;
    }
    @Override
    public void run() {
        while (true) {
            r.out();
        }
    }
}
class Producer implements Runnable {
    private Resource r;
    public Producer(Resource r) {
        this.r = r;
    }
    @Override
    public void run() {
        while (true) {
            r.setResource("zhangsan");
        }
    }
}
class Resource {
    private String name;
    private int count = 0;
    boolean flag = false;
    private final Lock lock = new ReentrantLock();
    private final Condition  p_cd = lock.newCondition();//多个Condition对象
    private final Condition  c_cd = lock.newCondition();//可以查看api：java.util.concurrent.locks 包里面
    public void setResource(String name) {
        lock.lock();
        try {
            while (this.flag) {
                //生产的锁
                try {p_cd.await();} catch (InterruptedException e) {}
            }
            this.name = name + "--" + count++;
            System.out.println(Thread.currentThread().getName()+ " ....生产者.... " + this.name );
            this.flag = true;
            //唤醒消费线程
            c_cd.signal();  
        } finally {//解锁（必须做）
            lock.unlock();
        }
    }
    public void out() {
        lock.lock();
        try {
            while (!this.flag) {
                //消费的锁
                try {c_cd.await();} catch (InterruptedException e) {}
            }
            System.out.println(Thread.currentThread().getName()+ " ............消费者........... " + this.name );
            this.flag = false;
            //唤醒生产的线程
            p_cd.signal();  
        } finally {//解锁（必须做）
            lock.unlock();
        }
    }
}