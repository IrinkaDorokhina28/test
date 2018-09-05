package com.dorokhina.lesson;

public class SomeClassI {
	public void someMethod(MyInt myInt) {  // MyInt - это название интерфейса, и потом можно передавать как аргумент любой объект, который реализует данный 
											// интерфейс
		myInt.doSomething();
	}
	int a = 5;
	int b = 6;

}
