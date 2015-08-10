package io;

import java.io.File;

public class ListDir {
	public static void main(String[] args) {
		File dir = new File(".");

		if (dir.isDirectory()) {
			System.out.println("Listing of: " + dir.getAbsolutePath());

			// List directory
			for (File fileName : dir.listFiles()) {
				if (fileName.isDirectory()) {
					System.out.println("[" + fileName.getName()+"]");
				}
			}
			// List directory
			for (File fileName : dir.listFiles()) {
				if (!fileName.isDirectory()) {
					System.out.println("  " + fileName.getName());
				}
			}
		} else {
			System.err.printf("File %s is not directory", dir);
		}
	}
}
