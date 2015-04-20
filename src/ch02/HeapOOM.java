package ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆溢出
 * 
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author wangsch
 */
public class HeapOOM {
	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		
		while(true) {
			list.add(new Object());
		}
	}
	
	/*
	 *  Result: 
	 *  java.lang.OutOfMemoryError: Java heap space
		Dumping heap to java_pid3740.hprof ...
		Heap dump file created [27889538 bytes in 0.171 secs]
		Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
		...
	 */
}
