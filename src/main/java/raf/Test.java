package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
		for (int i = 0; i < 26; i++) {
			raf.write(65 + i);
		}
		
		System.out.println("写完了!");
		raf.close();
	}
}
