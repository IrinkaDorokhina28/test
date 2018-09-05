package com.dorokhina.lesson;

import java.io.File;

public class IOM {

	public static void main(String[] args) {
//		File file = new File("users/photos/cmd");
//		System.out.println(file.isDirectory());
//		System.out.println(file.isFile());
//		System.out.println(file.getAbsolutePath());
//		File[] files = file.listFiles();
//		for(File f: files) {
//			System.out.println(f.getName());
//		}
		
		
		File file1 = new File("/Users/irinadorokhina/");
		System.out.println(file1.isDirectory());
		System.out.println(file1.isFile());
		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.getName());
	}

}
