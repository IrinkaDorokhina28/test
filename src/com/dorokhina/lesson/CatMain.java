package com.dorokhina.lesson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CatMain {

	public static void main(String[] args) {
		Owner owner = new Owner("Yaroslaff");
		Cat cat = new Cat("Vitalina", 21);
		cat.setOwner(owner);
		System.out.println(cat);
		
//		try {
//			Cat cloneCat = (Cat) cat.clone();
//			owner.setName("Gallina");
//			System.out.println(cloneCat);
//			System.out.println(cat);
//		}
		
		// сериализация
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  // write
		//FileOutputStream fos = new FileOutputStream("cat2clone.bin");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);  //контейнер для нашего объекта
			oos.writeObject(cat);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
//		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());  // read
//		try{
//			ObjectInputStream oos = new ObjectInputStream(bais);
//			//System.out.println(cloneCat);
//			System.out.println("Changin owner name");
//			owner.setName("Sergio");
//			System.out.println(cat);
//			//System.out.println(cloneCat);
//		} catch (IOException e | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
	}

}
