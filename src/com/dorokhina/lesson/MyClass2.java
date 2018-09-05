package com.dorokhina.lesson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyClass2 {

	public static void main(String[] args) {
		Cat cat = new Cat("Susleg", 12);
		//System.out.println(cat);
//		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("cat.bin"))){
//			dos.writeUTF(cat.getName());
//			dos.writeInt(cat.getAge());
//			System.out.println("Cat is binary now");
//		} catch (Exception e) {
//			System.out.println("Oooops... something going apple");c
//		}
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream("cat.bin"))){
			Cat c = new Cat(dis.readUTF(), dis.readInt());
			System.out.println("Cat from file" + c);
		} catch (Exception e) {
			System.out.println("Oooops... something going apple");
		}

	}

}
