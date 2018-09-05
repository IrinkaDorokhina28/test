package com.dorokhina.lesson;

import java.io.Console;

public class MyClass {

	public static void main(String[] args) {
		Console console = System.console();
		if(console == null) {
			System.out.println("WTF?MacOS?");
			System.exit(66613);
		}
		System.out.println("Console ok...");
		String login = console.readLine();   // не будет скрывать вводимые символы
		//console.readPassword();    // если нужно прочитать пароль
		char[] psw = console.readPassword();
		String password = new String(psw);
		
		if(login.equals("admin") && password.equals("123")) {
			System.out.println("Ok");
		} else {
			System.out.println("No");
		}
	}

}
