package com.dorokhina.lesson;

import java.util.ArrayList;
import java.util.List;

public class LambdaMain {

	public static void main(String[] args) {
		
		MyInt myInt = new MyInt() {

			@Override
			public void doSomething() {
				System.out.println("Hello from lambda");
				
			}};
			myInt.doSomething();
			//List al = new ArrayList();
			SomeClassI sc = new SomeClassI();
			sc.someMethod(() -> System.out.println("Hello from lambda"));
		//	sc.dowell((5, 7) -> System.out.println("a + b" + (a + b)));	
				
//			MyInterf = myInterf = new MyInterf(33, "hello") {
//
//				@Override
//				public void dowell(int age, String s) {
//					
//					
//				}
//				
//			};
		
		

	}

}
