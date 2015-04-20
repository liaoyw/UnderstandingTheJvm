package ch02;

/**
 * String.intern方法在JDK6和JDK7的区别
 * @author wangsch
 */
public class StringInternInJdk6And7 {
	public static void main(String[] args) {
		String str1 = new StringBuilder("中国").append("钓鱼岛").toString();
		System.out.println(str1.intern() == str1);
			
		/*
		 * JDK1.7下，因为“java”已经出现过，所以str2.intern()返回的是首次出现时的引用，和str2不等。而“中国钓鱼岛”是首次出现，所以返回了true
		 */
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}
	
	/*
	 * 
	 * Result
	 * JDK1.6: false, false
	 * 
	 * JDK1.7: true, false
	 * 
	 */
}
