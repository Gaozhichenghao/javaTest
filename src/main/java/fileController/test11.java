package fileController;

//关于锁问题
public class test11 implements Runnable {
	int b = 100;

	public synchronized void A() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + ":" + "B值修改为1000"+System.currentTimeMillis());

		b = 1000;

		System.out.println(Thread.currentThread().getName() + ":" + "运行方法A");

		Thread.sleep(5000);
		System.out.println(Thread.currentThread().getName() + ":" + "A" + b);
	}

	public synchronized void B() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + ":" + "运行方法b"+":"+System.currentTimeMillis());
		Thread.sleep(2500);
		b = 2000;

		System.out.println(Thread.currentThread().getName() + ":" + "B" + b);

	}

	public void run() {
		try {
			A();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		test11 t = new test11();
		Thread i = new Thread(t);
		System.out.println(System.currentTimeMillis());
		i.start();
//		 t.B();
		System.out.println(Thread.currentThread().getName() + ":" + "运行方法main" + t.b);

	}
}