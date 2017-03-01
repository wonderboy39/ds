package com.utils.textParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TextFileParser {
	private InputStream inputStream = null;
	private OutputStream outputStream = null;
	private File file = null;
//	private final int MAX_BUFF=4096;
	private char [] buff = null;
	private int length = 0;
	private String filename;
	private String fullString;
	public TextFileParser(String filename){
		this.filename = filename;
	}
	public String readStringFromText(){
		try {
			file = new File(filename);
			inputStream = new FileInputStream(file);
			length = (int)file.length();
			buff = new char[length];
			fullString = "FAILED TO READ FILE";
			
			int index = 0;
			int result = 0;
			while((result=inputStream.read())!=-1){
				buff[index++] = (char)result;
			}
			
			fullString = new String(buff);
			return fullString;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fullString;
	}
	
	public void close(){
		try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void printOrgString(){
		System.out.println(fullString);
	}
}
