package javaTest;
public class ThisLockDemo {
    public static void main(String[] args) {
        TicketDemo td = new TicketDemo();
        Thread t1 = new Thread(td);
        Thread t2 = new Thread(td);
        t1.setPriority(8);
        t1.start();
        try{Thread.sleep(1000);}catch(InterruptedException e){}
        td.flag = false;
        t2.setPriority(3);
        t2.start();
    }
}
class TicketDemo implements Runnable{
    private int tick = 20;
    public boolean flag = true;
    Object obj = new Object();
    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized(obj) {
                    if (tick > 0) {
                        try {Thread.sleep(1000);} catch (InterruptedException e) {}
                        System.out.println(Thread.currentThread().getName() + " if卖票啦  " + tick--);
                    }
                }
            }
        } else {
            while (true)
                saleTick();
        }
    }
    public synchronized void saleTick() {//this
        if (tick > 0) {
            try {Thread.sleep(1000);} catch (InterruptedException e) {}
            System.out.println(Thread.currentThread().getName() + " else卖票啦  " + tick--);
        }
    }
}