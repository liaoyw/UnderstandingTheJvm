package ch02;

/**
 * Java虚拟机栈溢出OOM
 * 
 * VM Args: -Xss2M
 * 
 * @author wangsch
 */
//public class JavaVMStackOOM {
//	public static void main(String[] args) {
//		JavaVMStackOOM oom = new JavaVMStackOOM();
//		oom.doSomething();
//	}
//	
//	/**
//	 * 启动大量线程
//	 */
//	private void doSomething() {
//		Runner runner = new Runner();
//		while(true) {
//			new Thread(runner).start();
//		}
//	}
//	
//	class Runner implements Runnable {
//		@Override
//		public void run() {
//			while(true) {
//			}
//		}
//	}
//}

public class JavaVMStackOOM {
	 
    private void dontStop() {
           while (true) {
           }
    }

    public void stackLeakByThread() {
           while (true) {
                  Thread thread = new Thread(new Runnable() {
                         @Override
                         public void run() {
                                dontStop();
                         }
                  });
                  thread.start();
           }
    }

    public static void main(String[] args) throws Throwable {
           JavaVMStackOOM oom = new JavaVMStackOOM();
           oom.stackLeakByThread();
    }
}
