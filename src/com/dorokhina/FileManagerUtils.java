package com.dorokhina;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileManagerUtils {
	public static void copyFile(Path file, Path path) {
		Path p1 = file;
		Path p2 = path;
		try {
			Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
			System.out.println(p2);
			System.out.println(Files.exists(p2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void moveFile(Path file, Path path) {
		Path p3 = file;
		Path p4 = Paths.get(path.toFile().getAbsolutePath(), file.toFile().getName());
	
		try {
			Files.move(p3, p4);
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
