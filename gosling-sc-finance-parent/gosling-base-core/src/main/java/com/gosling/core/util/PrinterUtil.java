package com.gosling.core.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrinterUtil {
	 
  	public static void print(String s){
  		BufferedWriter writer = null;
  		try {
  			writer = new BufferedWriter(new FileWriter("D:\\t1.txt", true));
  			writer.write(s);
  			writer.newLine();
  			writer.flush();
  			writer.close();
  			System.out.println("文件写入完成...");
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
  	}
}
