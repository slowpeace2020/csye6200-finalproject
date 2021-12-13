package edu.neu.csye6200.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	//This function takes a string as a parameter and writes to file
	public static void writeTextFile(String entry,  String fileName) {
	writeTextFile(entry,fileName,true);
	}
	
	//This function takes a string as a parameter and writes to file
	public static void writeTextFile(String entry,  String fileName,boolean append) {
		File entryFile = new File(fileName);
		try (FileWriter fileWriter = new FileWriter(entryFile, append);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
			bufferedWriter.write(entry);
			bufferedWriter.newLine();
			
		} catch (IOException e) {
			// TODO: handle exception
			System.err.format("IOException: %s%n", e);
		}
		
	}
	
	//This function reads the file and returns a string
	public static List<String> readTextFile(String fileName) {
		List<String> entries = new ArrayList<>();
		File file = new File("");
		String prefixPath = file.getAbsolutePath();
		try (BufferedReader bufferedReader =  new BufferedReader(new FileReader(prefixPath+ "/data/" +fileName))
				) {
			String line ="";
			while((line = bufferedReader.readLine())!=null) {
				if(line.equals("")){
					continue;
				}
				entries.add(line);
				System.out.println(line);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.format("Exception: %s%n", e);
		}
		
		return entries;
	}


}
