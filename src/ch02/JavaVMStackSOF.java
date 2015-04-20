package ch02;

/**
 * Java虚拟机栈溢出SOF
 * 
 * VM Args: -Xss128k
 * 
 * @author wangsch
 */
public class JavaVMStackSOF {
	
	public int count;
	
	public static void main(String[] args) {
		JavaVMStackSOF sof = new JavaVMStackSOF();
		try {
			sof.loop();
		} catch (Throwable e) {
			System.out.println("Current count is " + sof.count);
			e.printStackTrace();
		}
	}
	
	/*
	 * Result:
	 *  Current count is 988
		java.lang.StackOverflowError
		at ch02.JavaVMStackSOF.loop(JavaVMStackSOF.java:25)
		...
	 */

	private void loop() {
		count++;
		loop();
	}
}
