package com.quan.iodemo;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
// ghi file bang FileOutputStream
		try {
			//khong can file san
			FileOutputStream fileOutputStream = new FileOutputStream("D:\\testFileOut2.txt");
			String string = "Nguyen Viet Quan";
			byte[] bytes = string.getBytes();
			fileOutputStream.write(bytes);
			fileOutputStream.close();
			System.out.println("ok");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public static void main1(String[] args) {
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("D:\\testOutFile.txt");
			fileOutputStream.write(65);
			System.out.println("ok");
			fileOutputStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
