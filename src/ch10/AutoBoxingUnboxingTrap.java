package ch10;

/**
 * 自动拆箱/装箱陷阱
 * 1. 没有运算符时，“==”不会自动拆箱
 * 2. 有运算符时，操作数被自动拆箱，“==”运算自动拆箱
 * 3. 包装类型的“equals”方法不会进行类型转换，如：Integer->Long
 * 4. QUES 为何第1行返回true，第2行返回false
 * 
 * @author wangsch
 *
 */
public class AutoBoxingUnboxingTrap {
	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
/*1*/		System.out.println(c == d);	// true
/*2*/		System.out.println(e == f);	// false
		System.out.println(c == (a + b));		// true
		System.out.println(c.equals(a + b));	// true
		System.out.println(g == (a + b));		// true
		System.out.println(g.equals(a + b));	// false
		
		/*
		 * jd-gui反编译后的结果
		 * Integer a = Integer.valueOf(1);
		    Integer b = Integer.valueOf(2);
		    Integer c = Integer.valueOf(3);
		    Integer d = Integer.valueOf(3);
		    Integer e = Integer.valueOf(321);
		    Integer f = Integer.valueOf(321);
		    Long g = Long.valueOf(3L);
		    System.out.println(c == d);
		    System.out.println(e == f);
		    System.out.println(c.intValue() == a.intValue() + b.intValue());
		    System.out.println(c.equals(Integer.valueOf(a.intValue() + b.intValue())));
		    System.out.println(g.longValue() == a.intValue() + b.intValue());
		    System.out.println(g.equals(Integer.valueOf(a.intValue() + b.intValue())));
		 */
	}
}
