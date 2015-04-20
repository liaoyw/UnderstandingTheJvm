package ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * Java方法区（运行时常量池）OOM
 * VM Args: -XX:PermSize=10m -XX:MaxPermSize=10m
 * @author wangsch
 */
public class RuntimeConstantsPoolOOM {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		int i = 0;
		
		while(true) {
			list.add(String.valueOf(++i).intern());
		}
	}
	
	/*
	 * Result
	 * JDK1.6：OOM
	 * Exception in thread "main" java.lang.OutOfMemoryError: PermGen space
	        at java.lang.String.intern(Native Method)
	        ...
	        
	   JDK1.7：正常运行
	 */
}
