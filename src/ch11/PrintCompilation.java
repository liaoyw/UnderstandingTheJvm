package ch11;

/**
 * 
 * 打印JIT编译信息
 * 
 * VM Args: -XX:+PrintCompilation
 * 
 * QUES 虚拟机参数“-XX:+PrintInlining”，报错：Improperly specified VM option 'PrintInlining'
 * QUES 编译器输出与“p340，代码清单 11-3”不同
 * 
 * @author wangsch
 */
public class PrintCompilation {
	public static final int NUM = 15000;

	public static int doubleValue(int i) {
		for(int j=0; j<100000; j++);
		return i * 2;
	}

	public static long calcSum() {
		long sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += doubleValue(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		for (int i = 0; i < NUM; i++) {
			calcSum();
		}
	}
	
	/*
	 * 编译器输出：
	 *      69    1 %           ch11.PrintCompilation::doubleValue @ 5 (18 bytes)
		     73    2             ch11.PrintCompilation::doubleValue (18 bytes)
		     73    3             ch11.PrintCompilation::calcSum (26 bytes)
		     77    4 %           ch11.PrintCompilation::main @ 5 (20 bytes)
	 * 
	 */
}
