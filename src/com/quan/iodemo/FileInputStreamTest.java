package com.quan.iodemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInputStreamTest {
	
	public static void main(String[] args) {
		try {
			//input la phai co file san
			FileInputStream fileInputStream = new FileInputStream(new File("inputText.txt"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
