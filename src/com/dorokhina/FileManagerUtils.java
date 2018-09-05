package com.dorokhina;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileManagerUtils {
	public static void copyFile(File file, Path path) {
		Path p1 = file.toPath();
		Path p2 = path;
		try {
			Files.copy(p1, p2);
			System.out.println(p2);
			System.out.println(Files.exists(p2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void moveFile(File file, Path path) {
		Path p3 = file.toPath();
		Path p4 = path;
	
		try {
			Files.move(p3, p4, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteFile(File file) {
		
		try {
			Files.delete(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
