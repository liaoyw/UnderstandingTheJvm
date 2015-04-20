package ch02;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * 直接内存溢出OOM
 * 
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * 
 * @author wangsch
 */
public class DirectMemoryOOM {
	private static final int _1MB = 1024 * 1024;

	// QUES 未能生成hprof
	public static void main(String[] args) throws Exception {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while (true) {
			unsafe.allocateMemory(_1MB);
		}
	}
	
	/*
	 * Result
	 * Exception in thread "main" java.lang.OutOfMemoryError
	   	   at sun.misc.Unsafe.allocateMemory(Native Method)
	   	   ...
	 * 
	 * 
	 */
}
